package com.learning.fred.mockdemo.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author fred
 * @date 2020/9/27 10:33 上午
 * @description todo
 */
@Component
@Order(2)
public class Two extends AbstractDemo {
}
