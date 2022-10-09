package com.payment.methods.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDto {

    @NotNull(message = "name should not be null")
    @NotBlank(message = "name should not be blank")
    private String name;

    @NotNull(message = "displayName should not be null")
    @NotBlank(message = "displayName should not be blank")
    private String displayName;

    @NotNull(message = "paymentType should not be null")
    @NotBlank(message = "paymentType should not be blank")
    private String paymentType;

    @Valid
    private List<PaymentPlanDto> paymentPlans = new ArrayList<>();

    public PaymentMethodDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PaymentPlanDto> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlanDto> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }
}
