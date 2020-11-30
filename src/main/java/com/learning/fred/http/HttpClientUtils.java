package com.learning.fred.http;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author fred
 * @date 2020/11/27 1:47 下午
 * @description todo
 */
public class HttpClientUtils {

    static PoolingHttpClientConnectionManager manager = null;
    static CloseableHttpClient httpClient = null;
    public static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {

            // todo 写法
            //注册访问协议相关的Socket 工厂
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", SSLConnectionSocketFactory.getSystemSocketFactory())
                    .build();

        }

        RegistryBuilder.create().build();
        return null;
    }
}
