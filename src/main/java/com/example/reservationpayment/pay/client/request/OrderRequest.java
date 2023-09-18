package com.example.reservationpayment.pay.client.request;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class OrderRequest {
    private UUID amenityId;
    private UUID customerId;
    private String pNumber;
    private UUID roomId;
    private Integer price;
    private Date date;
}
