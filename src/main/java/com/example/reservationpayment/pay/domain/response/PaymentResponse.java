package com.example.reservationpayment.pay.domain.response;


import com.example.reservationpayment.pay.domain.dto.Customer;
import com.example.reservationpayment.pay.domain.dto.Room;
import com.example.reservationpayment.pay.domain.entity.Payment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class PaymentResponse {
    private Long id;
    private LocalDateTime createAt;
    private Integer price;
    private UUID amenityId;
    private UUID roomId;
    private UUID customerId;

    public PaymentResponse(Payment payment, UUID roomId, UUID customerId) {
        this.id = payment.getId();
        this.createAt = payment.getCreateAt();
        this.price = payment.getPrice();
        this.amenityId = payment.getAmenityId();
        this.roomId = roomId;
        this.customerId = customerId;
    }
}
