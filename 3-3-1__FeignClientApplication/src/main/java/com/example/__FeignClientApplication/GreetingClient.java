package com.example.__FeignClientApplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client-application")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}

//    @RequestMapping(method = RequestMethod.GET, value = "/stores")
//    List<Store> getStores();
//
//    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
//    Store update(@PathVariable("storeId") Long storeId, Store store);