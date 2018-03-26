package com.keyijie.order.controller;

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
        body.setData("这是示例");
        return body;
    }
}
