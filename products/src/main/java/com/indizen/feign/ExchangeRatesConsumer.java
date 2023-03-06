package com.indizen.feign;

import com.indizen.model.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name="EXCHANGERATES-SERVICE")
public interface ExchangeRatesConsumer {

    @GetMapping("/exchangeRates/list")
    public List<ExchangeRates> getExchangeRates();

}