package com.kin.springcloud.limitsservice.controller;

import com.kin.springcloud.limitsservice.beans.LimitsConfig;
import com.kin.springcloud.limitsservice.configuration.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public LimitsConfig getLimitsConfig(){
        return new LimitsConfig(configuration.getMax(),configuration.getMin());
    }
    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackFaultAccess")
    public LimitsConfig faultAccess(){
        throw new RuntimeException("some exception");
    }
    public LimitsConfig fallbackFaultAccess(){
        return new LimitsConfig(555,5);
    }


}
