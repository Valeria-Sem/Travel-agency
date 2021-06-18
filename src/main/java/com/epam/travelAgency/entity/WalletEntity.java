package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class WalletEntity implements Serializable {
    private int id;
    private double balance;
    private String bankAccountNumber;

    public WalletEntity() {
    }

    public WalletEntity(int id, double balance, String bankAccountNumber) {
        this.id = id;
        this.balance = balance;
        this.bankAccountNumber = bankAccountNumber;
    }

    public WalletEntity(double balance, String bankAccountNumber) {
        this.balance = balance;
        this.bankAccountNumber = bankAccountNumber;
    }

    public WalletEntity(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity that = (WalletEntity) o;
        return id == that.id && Double.compare(that.balance, balance) == 0 && Objects.equals(bankAccountNumber, that.bankAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, bankAccountNumber);
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "id=" + id +
                ", balance=" + balance +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }
}
