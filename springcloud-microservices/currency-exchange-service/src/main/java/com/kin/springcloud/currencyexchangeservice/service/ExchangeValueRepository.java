package com.kin.springcloud.currencyexchangeservice.service;

import com.kin.springcloud.currencyexchangeservice.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
    Optional<ExchangeValue> findByFromAndTo(String from, String to);
}
