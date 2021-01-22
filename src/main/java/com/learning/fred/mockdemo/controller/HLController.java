package com.learning.fred.mockdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fred
 * @date 2021/1/18 18:48
 * @description todo
 */
@Controller
public class HLController {

    @RequestMapping("/hello")
    public ModelAndView hello() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "hello");
        return modelAndView;
    }
}
