package com.example.__FeignClientApplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client-application")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}
