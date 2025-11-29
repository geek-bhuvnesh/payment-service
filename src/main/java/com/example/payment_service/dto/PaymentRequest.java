package com.example.payment_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentRequest {
    @NotBlank(message = "Payer cannot be blank")
    private String payer;

    @NotBlank(message = "Payee cannot be blank")
    private String payee;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1")
    private Double amount;

    public PaymentRequest() {}

    public String getPayer() { return payer; }
    public void setPayer(String payer) { this.payer = payer; }

    public String getPayee() { return payee; }
    public void setPayee(String payee) { this.payee = payee; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}
