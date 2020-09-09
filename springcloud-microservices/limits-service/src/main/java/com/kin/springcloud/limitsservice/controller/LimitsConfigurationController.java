package com.kin.springcloud.limitsservice.controller;

import com.kin.springcloud.limitsservice.beans.LimitsConfig;
import com.kin.springcloud.limitsservice.configuration.Configuration;
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

}
