package com.example.__EurekaClientApplication;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingControler {
    @RequestMapping("/greeting")
    String greeting();
}
