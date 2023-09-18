package com.example.reservationpayment.pay.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Customer {
    private UUID id;
    private String name;
    private String Email;
}
