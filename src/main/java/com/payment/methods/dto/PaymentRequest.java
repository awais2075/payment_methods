package com.payment.methods.dto;

import javax.validation.Valid;
import java.util.List;

public class PaymentRequest {

    @Valid
    private List<PaymentMethodDto> paymentMethods;

    public PaymentRequest() {
    }

    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
