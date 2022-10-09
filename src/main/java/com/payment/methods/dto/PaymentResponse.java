package com.payment.methods.dto;

import java.util.List;

public class PaymentResponse {

    private List<PaymentMethodDto> paymentMethods;

    public PaymentResponse() {
    }

    public PaymentResponse(List<PaymentMethodDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
