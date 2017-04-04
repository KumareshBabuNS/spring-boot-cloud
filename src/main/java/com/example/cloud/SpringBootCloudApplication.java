package com.example.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootCloudApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringBootCloudApplication.class);

    @Value("${CF_INSTANCE_INDEX:'1'}")
    private String instanceId;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
	    LOGGER.info("Calling hello endpoint of instance {}", instanceId);
		return "hello cloud instance " + instanceId;
	}
}
