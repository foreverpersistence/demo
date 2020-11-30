package com.learning.fred.mockdemo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fred
 * @date 2020/9/27 10:37 上午
 * @description todo
 */
@RestController
public class DemoController {

    @Autowired
    List<AbstractDemo> list;

    @GetMapping("/demo")
    public String demo() {
        System.out.println(list.size());
        return "success";
    }

}
