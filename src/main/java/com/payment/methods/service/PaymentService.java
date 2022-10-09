package com.payment.methods.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.methods.dto.PaymentMethodDto;
import com.payment.methods.dto.PaymentRequest;
import com.payment.methods.dto.PaymentResponse;
import com.payment.methods.entity.PaymentMethod;
import com.payment.methods.exception.GenericException.*;
import com.payment.methods.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Service
public class PaymentService {

    private final ObjectMapper objectMapper;
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentService(ObjectMapper objectMapper, PaymentMethodRepository paymentMethodRepository) {
        this.objectMapper = objectMapper;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public PaymentResponse getAllPaymentMethods(Map<String, String> filter) {
        if(Objects.nonNull(filter.get("id"))) {
            return new PaymentResponse(Arrays.asList(objectMapper.convertValue(paymentMethodRepository.findPaymentMethodsByIdOfPaymentPlan(Integer.valueOf(filter.get("id"))), PaymentMethodDto[].class)));
        }

        if(Objects.nonNull(filter.get("name"))) {
            return new PaymentResponse(Arrays.asList(objectMapper.convertValue(paymentMethodRepository.findPaymentMethodsByName(filter.get("name")), PaymentMethodDto[].class)));
        }

        return new PaymentResponse(Arrays.asList(objectMapper.convertValue(paymentMethodRepository.findAll(), PaymentMethodDto[].class)));
    }

    public PaymentResponse addPaymentMethod(PaymentRequest paymentRequest) {
        var paymentMethods = Arrays.asList(objectMapper.convertValue(paymentRequest.getPaymentMethods(), PaymentMethod[].class));
        return new PaymentResponse(Arrays.asList(objectMapper.convertValue(paymentMethodRepository.saveAll(paymentMethods), PaymentMethodDto[].class)));
    }

    public PaymentResponse updatePaymentMethod(PaymentRequest paymentRequest) throws PaymentMethodNotFoundException{
        var paymentMethods = Arrays.asList(objectMapper.convertValue(paymentRequest.getPaymentMethods(), PaymentMethod[].class));

        for (var paymentMethod: paymentMethods) {
            var payment = paymentMethodRepository.findByNameAndDisplayNameAndPaymentType(paymentMethod.getName(), paymentMethod.getDisplayName(), paymentMethod.getPaymentType())
                    .orElseThrow(() -> new PaymentMethodNotFoundException("Payment Method Not Found"));
            paymentMethodRepository.save(paymentMethod);
        }

        return new PaymentResponse(paymentRequest.getPaymentMethods());
    }
}
