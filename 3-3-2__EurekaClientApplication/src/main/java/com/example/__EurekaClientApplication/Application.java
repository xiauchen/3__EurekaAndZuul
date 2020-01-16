package com.example.__EurekaClientApplication;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import com.netflix.discovery.converters.jackson.mixin.ApplicationXmlMixIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application implements GreetingControler {
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public String greeting(){
		return String.format(
				"Hello from '%s'-1 !",eurekaClient.getApplication(appName).getName());
	}
}
