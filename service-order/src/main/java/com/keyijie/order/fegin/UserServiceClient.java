package com.keyijie.order.fegin;

import com.keyijie.common.restful.RestBody;
import com.keyijie.order.model.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-user", configuration = FeignConfig.class)
public interface UserServiceClient {

    @RequestMapping(value = "/user/test/{id}", method = RequestMethod.GET)
    RestBody<UserInfo> json(@PathVariable("id") long id);

    @GetMapping(value = "/user/{id}")
    UserInfo get(@PathVariable("id") long id);

}
