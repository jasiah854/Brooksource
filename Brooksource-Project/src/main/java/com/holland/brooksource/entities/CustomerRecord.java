package com.holland.brooksource.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "customers_records")
public class CustomerRecord {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Integer transactionNumber;
    private Integer accountNumber;
    private String customerName;
    @NonNull
    private Double purchaseAmount;
    private Date dateOfPurchase;

    public CustomerRecord() {super();}
    public CustomerRecord(Integer accountNumber, Double purchaseAmount) {
        super();
        this.accountNumber = accountNumber;
        this.purchaseAmount = purchaseAmount;

    }

    public Integer getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName( String customerName) {
        this.customerName = customerName;
    }
    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(@NonNull Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
