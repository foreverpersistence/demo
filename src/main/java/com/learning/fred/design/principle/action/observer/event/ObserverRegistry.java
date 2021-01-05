package com.learning.fred.design.principle.action.observer.event;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fred
 * @date 2020/12/24 17:50
 * @description 注册表
 * 一个 eventType. 可以对应多个类的方法
 */
public class ObserverRegistry {

    // key: event-class, value: 包含 subscribe注解的 classes-methond
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void registry(Object observer) {

        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObservers(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();//参数

            Collection<ObserverAction> eventActions = entry.getValue();

            CopyOnWriteArraySet<ObserverAction> registryedEventActions = registry.get(eventType);
            if (registryedEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registryedEventActions = registry.get(eventType);
            }
            registryedEventActions.addAll(eventActions);

        }

    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            //类型 包含父类
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }


    private Map<Class<?>, Collection<ObserverAction>> findAllObservers(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();

        Class<?> clazz = observer.getClass();

        for (Method method : getAnnotatedMethos(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }

        return observerActions;
    }


    private List<Method> getAnnotatedMethos(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument( parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);

                annotatedMethods.add(method);
            }
        }

        return annotatedMethods;


    }

}
