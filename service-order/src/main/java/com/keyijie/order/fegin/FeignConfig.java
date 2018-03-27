package com.keyijie.order.fegin;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfig {
    /**
     * 设置日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 关闭熔断功能
     * @return
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    /**
     * 错误处理
     * @return
     */
    @Bean
    public ErrorDecoder errorDecoder(){
        return new FeignErrorDecoder();
    }
}
