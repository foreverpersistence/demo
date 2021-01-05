package com.learning.fred.mockdemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author fred
 * @date 2020/12/18 13:49
 * @description todo
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/createOrCancel")
    public ResultInfo<Boolean> testPost(@RequestBody Map<String, Object> o) {

        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        System.out.println(o);

        return resultInfo.succeed().withData(true);
    }


    @GetMapping("/index")
    public String index() {
        return "hello";
    }


    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "hello" + name;
    }

}
