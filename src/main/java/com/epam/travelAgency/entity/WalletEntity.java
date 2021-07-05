package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class WalletEntity implements Serializable {
    private int id;
    private double balance;
    private int userId;

    public WalletEntity() {
    }

    public WalletEntity(double balance, int userId) {
        this.balance = balance;
        this.userId = userId;
    }

    public WalletEntity(int id, double balance, int userId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
    }

    public WalletEntity(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity that = (WalletEntity) o;
        return id == that.id && Double.compare(that.balance, balance) == 0 && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, userId);
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "id=" + id +
                ", balance=" + balance +
                ", userId=" + userId +
                '}';
    }
}
