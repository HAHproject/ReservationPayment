package com.example.reservationpayment.pay.client.api;


import com.example.reservationpayment.pay.client.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ORDER-COMMAND-SERVICE")
public interface OrderCommandClient {
    @PostMapping
    void save(OrderRequest request);
}
