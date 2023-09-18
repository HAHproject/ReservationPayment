package com.example.reservationpayment.pay.repository;

import com.example.reservationpayment.pay.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository
        extends JpaRepository<Payment, UUID> {
}
