package com.keyijie.user.controller;

import com.keyijie.common.restful.RestBody;
import com.keyijie.common.restful.RestCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/helloword")
    public String helloWord() {
        return "Hello Word";
    }

    @GetMapping("/json")
    public RestBody json() {
        RestBody<String> body = new RestBody<>(RestCode.OK);
        body.setData("这是User示例");
        return body;
    }
}
