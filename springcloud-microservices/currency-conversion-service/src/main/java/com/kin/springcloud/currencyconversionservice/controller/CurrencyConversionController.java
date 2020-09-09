package com.kin.springcloud.currencyconversionservice.controller;

import com.kin.springcloud.currencyconversionservice.bean.CurrencyConversionResult;
import com.kin.springcloud.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeServiceProxy proxy;
    @GetMapping("/currency-conversion-lagacy/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResult convertLagacy(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        // usage of restTemplate
        HashMap<String,String> uriParams= new HashMap();
        uriParams.put("from",from);
        uriParams.put("to",to);
        ResponseEntity<CurrencyConversionResult> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionResult.class, uriParams);
        if(responseEntity.hasBody()){
            CurrencyConversionResult res = responseEntity.getBody();
            return new CurrencyConversionResult(res.getId(),from,to,res.getRate(),quantity,quantity.multiply(res.getRate()),res.getPort());
        }
        return new CurrencyConversionResult(0l,from,to,BigDecimal.valueOf(0),quantity,BigDecimal.valueOf(0),0);

    }
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResult convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        // usage of feign
        CurrencyConversionResult res = proxy.exchange(from, to);
        return new CurrencyConversionResult(res.getId(),from,to,res.getRate(),quantity,quantity.multiply(res.getRate()),res.getPort());
    }
}
