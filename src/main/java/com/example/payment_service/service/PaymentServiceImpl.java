package com.example.payment_service.service;

import com.example.payment_service.dto.PaymentRequest;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    // Constructor injection (preferred)
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Payment createPayment(PaymentRequest request) {
        Payment p = new Payment();
        p.setPayer(request.getPayer());
        p.setPayee(request.getPayee());
        p.setAmount(request.getAmount());
        // createdAt set by default in entity if you have @PrePersist
        return repository.save(p);
    }

    @Override
    public Payment getPayment(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}
