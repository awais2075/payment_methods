package com.payment.methods.repository;

import com.payment.methods.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

    @Query("select p from PaymentMethod p where p.name = :name")
    List<PaymentMethod> findPaymentMethodsByName(@Param("name") String name);

    @Query("select p from PaymentMethod p inner join p.paymentPlans paymentPlans where paymentPlans.id = :id")
    List<PaymentMethod> findPaymentMethodsByIdOfPaymentPlan(@Param("id") Integer id);

    @Query("select p from PaymentMethod p " +
            "where p.name = :name and p.displayName = :displayName and p.paymentType = :paymentType")
    Optional<PaymentMethod> findByNameAndDisplayNameAndPaymentType(@Param("name") String name, @Param("displayName") String displayName, @Param("paymentType") String paymentType);


}