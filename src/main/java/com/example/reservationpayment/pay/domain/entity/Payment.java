package com.example.reservationpayment.pay.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "payments")
@Entity @AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private Integer price;
    private UUID amenityId;
    private UUID roomId;
    private UUID customerId;
    private String pNumber;
}
