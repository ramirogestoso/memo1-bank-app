package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cbu;
    private String action;
    private Double sum;
    public Transaction() {}
    public static Transaction withdraw(Long cbu, Double sum) {
        Transaction transaction = new Transaction();
        transaction.cbu = cbu;
        transaction.action = "withdraw";
        transaction.sum = sum;
        return transaction;
    }
    public static Transaction deposit(Long cbu, Double sum) {
        Transaction transaction = new Transaction();
        transaction.cbu = cbu;
        transaction.action = "deposit";
        transaction.sum = sum;
        return transaction;
    }

    public Long getId() { return this.id; }
    public Long getCbu() {return this.cbu; }
    public String getAction() { return this.action; }
    public Double getSum() { return this.sum; }
}
