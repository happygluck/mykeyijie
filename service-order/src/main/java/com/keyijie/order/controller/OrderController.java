package com.keyijie.order.controller;

import com.keyijie.common.restful.RestBody;
import com.keyijie.order.fegin.UserServiceClient;
import com.keyijie.order.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserServiceClient userClient;

    @GetMapping("/1")
    public RestBody<UserInfo> json() {
        RestBody<UserInfo> body = userClient.json(23);
        return body;
    }

    @GetMapping(value = "/{id}")
    public RestBody<UserInfo> test(@PathVariable("id") long id) {
        RestBody<UserInfo> body = new RestBody<>(200);
        UserInfo user = userClient.get(id);
        body.setData(user);
        return body;
    }
}
