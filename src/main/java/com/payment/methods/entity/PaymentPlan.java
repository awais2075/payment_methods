package com.payment.methods.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment_plan")
public class PaymentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "net_amount", nullable = false)
    private BigDecimal netAmount;
    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;
    @Column(name = "gross_amount", nullable = false)
    private BigDecimal grossAmount;
    @Column(name = "currency", nullable = false)
    private String currency;
    @Column(name = "duration", nullable = false)
    private String duration;

    public PaymentPlan() {
    }

    public Integer getId() {
        return id;
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
