package com.hwm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ComputeService
 *
 * @author hwm
 * @since 2017/3/16
 **/
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    /**
     * 错误调用的方法
     */
    public String addServiceFallback() {
        return "error";
    }
}
