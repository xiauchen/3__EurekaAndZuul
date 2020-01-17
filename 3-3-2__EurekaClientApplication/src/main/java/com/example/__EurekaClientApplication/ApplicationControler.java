package com.example.__EurekaClientApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@Value()

public interface ApplicationControler {
    @RequestMapping("/greeting")
    String greeting();

}
