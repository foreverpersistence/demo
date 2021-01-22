package com.learning.fred.design.principle.pattern.struct.proxy;

import com.learning.fred.design.metricdemo.controller.v2.MetricsCollector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fred
 * @date 2020/12/21 13:32
 * @description todo
 */
public class MetricxCollectorProxy {

    private MetricsCollector metricsCollector;
    public MetricxCollectorProxy() {

        metricsCollector = new MetricsCollector(null);
    }

    public Object createProxy(Object proxyObject) {
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();

        DynamicProxyHandler handler = new DynamicProxyHandler(proxyObject);
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, handler);
    }


    private static class DynamicProxyHandler implements  InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();

            Object invoke = method.invoke(proxiedObject, args);

            long endTimestamp = System.currentTimeMillis();
            //collect

            return invoke;
        }
    }


}
