package com.hystrix.dashboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;


//@PropertySource(value="file:/opt/appdocs/hystrixdashboard/application.properties", ignoreResourceNotFound = true)

@PropertySource(value = "file:C:\\SwipeTech\\Projects\\SWIPE_SERVICES\\PROPERTY_FILES\\hystrixdashboard\\application.properties", ignoreResourceNotFound = true)

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class HystrixdashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixdashboardApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
