package com.example.payment_service.controller;

import com.example.payment_service.dto.PaymentRequest;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments") 
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    // create payment 
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody @Valid PaymentRequest request) {
        Payment created = service.createPayment(request); 
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    // Get payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        Payment payment = service.getPayment(id);
        if(payment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(payment);
    }

    // Get All Payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = service.getAllPayments();
        return ResponseEntity.ok(payments);
    }


    // Optional: delete payment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        Payment payment = service.getPayment(id);
        if (payment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
    
}