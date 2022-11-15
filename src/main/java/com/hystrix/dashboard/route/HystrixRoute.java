package com.hystrix.dashboard.route;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hystrix")
public class HystrixRoute {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(groupKey = "test1", commandKey = "test1", fallbackMethod = "getFallBack")
    @GetMapping("/stest1")
    public String engageService() {
        String engGet = restTemplate.getForObject("http://localhost:8082/cardservice/test/get", String.class);
        return engGet ;
    }

    @HystrixCommand(groupKey = "stest2", commandKey = "stest2", fallbackMethod = "getFallBack")
    @GetMapping("/stest2")
    public String swipepayService() {
        String twoFactorRoute1 = restTemplate.getForObject("http://localhost:8082/cardservice/test/post", String.class);

        return twoFactorRoute1;
    }

    private String getFallBack() {
        return "Sorry our services are busy! Try again later.";
    }

}
