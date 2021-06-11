package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class WalletEntity implements Serializable {
    private int id;
    private double balance;

    public WalletEntity() {
    }

    public WalletEntity(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public WalletEntity(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity that = (WalletEntity) o;
        return id == that.id && balance == that.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance);
    }
}
