package com.keyijie.user.controller;

import com.keyijie.common.restful.RestBody;
import com.keyijie.common.restful.RestCode;
import com.keyijie.user.entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/test/{id}")
    public RestBody json(@PathVariable("id") long id) {
        RestBody<UserInfo> body = new RestBody<>(RestCode.OK);
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("刘涛");
        body.setData(userInfo);
        body.setMessage("mse");
        userInfo.setDate(new Date());
        return body;
    }

    @GetMapping(value = "/{id}")
    public UserInfo get(@PathVariable("id") long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("刘涛");
        userInfo.setDate(new Date());
        return userInfo;
    }
}
