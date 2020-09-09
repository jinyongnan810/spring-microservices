package com.kin.springcloud.currencyexchangeservice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
public class ExchangeValue {
    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal rate;
    private Integer port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal rate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.rate = rate;
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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
