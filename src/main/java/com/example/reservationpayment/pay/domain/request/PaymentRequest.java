package com.example.reservationpayment.pay.domain.request;

import com.example.reservationpayment.pay.config.TokenInfo;
import com.example.reservationpayment.pay.domain.entity.Payment;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PaymentRequest {
    private final Integer price;
    private final UUID amenityId;
    private final UUID roomId;

    public Payment toEntity(TokenInfo info){
        return Payment.builder()
                .createAt(LocalDateTime.now())
                .customerId(info.getId())
                .roomId(roomId)
                .amenityId(amenityId)
                .price(price)
                .build();
    }
}
