package com.example.reservationpayment.pay.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Room {
    private UUID roomId;
    private String roomName;
    private Integer price;
    private Date date;
    private UUID amenityId;
}