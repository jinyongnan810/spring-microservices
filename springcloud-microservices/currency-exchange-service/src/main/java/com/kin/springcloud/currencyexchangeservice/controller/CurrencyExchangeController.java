package com.kin.springcloud.currencyexchangeservice.controller;

import com.kin.springcloud.currencyexchangeservice.beans.ExchangeValue;
import com.kin.springcloud.currencyexchangeservice.service.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    // create logger
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ExchangeValueRepository exchangeValueRepository;
    @Autowired
    private Environment environment;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue exchange(@PathVariable String from,@PathVariable String to){
        Optional<ExchangeValue> resOpt = exchangeValueRepository.findByFromAndTo(from, to);
        if(resOpt.isPresent()){
            ExchangeValue res = resOpt.get();
            res.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            logger.info("{}",res);
            return res;
        }
        ExchangeValue res = new ExchangeValue(0L, from, to, BigDecimal.valueOf(0));
        res.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return res;
    }
}
