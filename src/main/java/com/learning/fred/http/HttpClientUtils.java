package com.learning.fred.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author fred
 * @date 2020/11/27 1:47 下午
 * @description todo
 */
public class HttpClientUtils {

    static PoolingHttpClientConnectionManager manager = null;
    static CloseableHttpClient httpClient = null;
    public  static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", SSLConnectionSocketFactory.getSystemSocketFactory())
                    .build();

            HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connectionFactory =
                    new ManagedHttpClientConnectionFactory(DefaultHttpRequestWriterFactory.INSTANCE, DefaultHttpResponseParserFactory.INSTANCE);
            //DNS
            DnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;
            //创建 池化连接管理器
            manager = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry, connectionFactory, dnsResolver);

            //默认设置 socket
            SocketConfig defaultSocketConfig = SocketConfig.custom()
                    .setTcpNoDelay(true).build();
            manager.setDefaultSocketConfig(defaultSocketConfig);

            // 设置 整个连接池的最大连接数
            manager.setMaxTotal(300);
            //每个路由的默认最大连接，每个路由实际最大连接数 默认为

            manager.setDefaultMaxPerRoute(200);

            // 在从 连接池获取连接时，连接不活跃 多长时间后 需要进行一次验证，默认2s
            manager.setValidateAfterInactivity(5 * 1000);

            //默认请求配置
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setConnectTimeout(2 * 1000)//设置 连接 超时时间
                    .setSocketTimeout(5 * 1000)//设置等待 数据超时时间
                    .setConnectionRequestTimeout(2000)//设置 从连接池 获取连接的等待 超时时间
                    .build();

            //创建  httpclient
            httpClient = HttpClients.custom()
                    .setConnectionManager(manager)
                    .setConnectionManagerShared(false)//非 共享模式
                    .evictIdleConnections(60, TimeUnit.SECONDS)//定期回收 空闲连接
                    .evictExpiredConnections()// 定期回收 过期连接
                    .setConnectionTimeToLive(60, TimeUnit.SECONDS)//连接存活时间，如果不设置，则根据长连接信息决定
                    .setDefaultRequestConfig(defaultRequestConfig)//设置默认请求配置
                    .setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)//连接重用策略，即是否能 keepAlive
                    .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)//长连接配置，即 获取 长连接 生产多长时间
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))//设置重试次数，默认是3次。当前是 禁用掉
            .build();


            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    try {
                        httpClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        return httpClient;
    }
}
