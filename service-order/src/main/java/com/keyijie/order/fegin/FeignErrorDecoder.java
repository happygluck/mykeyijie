package com.keyijie.order.fegin;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String str, Response response) {

        return new HystrixBadRequestException("自定义异常");
    }
}
