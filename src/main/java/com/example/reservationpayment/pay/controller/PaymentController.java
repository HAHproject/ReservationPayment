package com.example.reservationpayment.pay.controller;


import com.example.reservationpayment.pay.config.JwtService;
import com.example.reservationpayment.pay.config.TokenInfo;
import com.example.reservationpayment.pay.domain.entity.Payment;
import com.example.reservationpayment.pay.domain.request.PaymentRequest;
import com.example.reservationpayment.pay.domain.response.PaymentResponse;
import com.example.reservationpayment.pay.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private final PaymentService service;
    private final JwtService jwtService;
    @GetMapping
    public List<PaymentResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("my")
    public PaymentResponse getMy(
            @RequestHeader("Authorization") String token
    ){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.getByCustomerId(tokenInfo);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestHeader("Authorization") String token,
            @RequestBody PaymentRequest request
            ){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        service.save(request, tokenInfo);
    }
}
