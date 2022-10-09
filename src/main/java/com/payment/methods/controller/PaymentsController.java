package com.payment.methods.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payment.methods.dto.PaymentRequest;
import com.payment.methods.dto.PaymentResponse;
import com.payment.methods.exception.GenericException.PaymentMethodNotFoundException;
import com.payment.methods.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/payment-methods")
public class PaymentsController {

    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public PaymentResponse getAllPaymentMethods(@RequestParam(required = false) Map<String, String> filter) throws JsonProcessingException {
        return paymentService.getAllPaymentMethods(filter);
    }

    @PostMapping
    public PaymentResponse addPaymentMethod(@Valid @RequestBody PaymentRequest paymentRequest) {
        return paymentService.addPaymentMethod(paymentRequest);
    }

    @PutMapping("/{id}")
    public PaymentResponse updatePaymentMethod(@RequestBody PaymentRequest paymentRequest) throws PaymentMethodNotFoundException {
        return paymentService.updatePaymentMethod(paymentRequest);
    }

}
