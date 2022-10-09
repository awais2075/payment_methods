package com.payment.methods.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "payment_method", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "display_name", "payment_type"}))
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false/*, unique = true*/)
    private String name;
    @Column(name = "display_name", nullable = false)
    private String displayName;
    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @OneToMany(targetEntity = PaymentPlan.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_method_id")
    private List<PaymentPlan> paymentPlans = new ArrayList<>();

    public PaymentMethod() {
    }

    public Integer getId() {
        return id;
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

    public List<PaymentPlan> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlan> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }
}
