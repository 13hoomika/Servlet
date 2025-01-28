package com.xworkz.amazon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ecom_checkout")
public class CheckoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String address;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "order_notes")
    private String orderNotes;
}
