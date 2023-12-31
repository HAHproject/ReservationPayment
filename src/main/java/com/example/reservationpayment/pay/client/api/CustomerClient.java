package com.example.reservationpayment.pay.client.api;


import com.example.reservationpayment.pay.domain.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerClient {
    @GetMapping("/api/v1/customer/{id}")
    Customer getById(@PathVariable String id);
}
