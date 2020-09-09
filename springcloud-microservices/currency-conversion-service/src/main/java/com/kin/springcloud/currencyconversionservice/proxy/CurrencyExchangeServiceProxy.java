package com.kin.springcloud.currencyconversionservice.proxy;

import com.kin.springcloud.currencyconversionservice.bean.CurrencyConversionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionResult exchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
