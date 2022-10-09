package com.payment.methods.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PaymentPlanDto {

    @NotNull(message = "netAmount should not be null")
    private BigDecimal netAmount;

    @NotNull(message = "taxAmount should not be null")
    private BigDecimal taxAmount;

    @NotNull(message = "grossAmount should not be null")
    private BigDecimal grossAmount;

    @NotNull(message = "currency should not be null")
    @NotBlank(message = "currency should not be blank")
    private String currency;

    @NotNull(message = "duration should not be null")
    @NotBlank(message = "duration should not be blank")
    private String duration;

    public PaymentPlanDto() {
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
