package com.soft1010.commons.log4j2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jifuzhang on 17/8/10.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @RequestMapping("hello")
    public String test(){
        return "hello";
    }
}
