package com.example.reservationpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReservationPaymentApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReservationPaymentApplication.class, args);
	}
}
