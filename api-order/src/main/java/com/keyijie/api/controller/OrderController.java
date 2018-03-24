package com.keyijie.api.controller;

import com.keyijie.common.restful.RestBody;
import com.keyijie.common.restful.RestCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/1")
    public RestBody json() {
        RestBody<String> body = new RestBody<>(RestCode.OK);
        body.setData("这是订单示例");
        return body;
    }
}
