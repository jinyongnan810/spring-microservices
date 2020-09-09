package com.kin.springcloud.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionResult {
    private Long id;
    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal quantity;
    private BigDecimal total;
    private Integer port;

    public CurrencyConversionResult() {
    }

    public CurrencyConversionResult(Long id, String from, String to, BigDecimal rate, BigDecimal quantity, BigDecimal total, Integer port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.quantity = quantity;
        this.total = total;
        this.port = port;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getPort() {
        return port;
    }
}
