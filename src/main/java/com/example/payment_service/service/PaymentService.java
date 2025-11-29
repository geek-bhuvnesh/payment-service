package com.example.payment_service.service;

import com.example.payment_service.dto.PaymentRequest;
import com.example.payment_service.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentRequest request);
    Payment getPayment(Long id);
    List<Payment> getAllPayments();    
    void deletePayment(Long id);
}