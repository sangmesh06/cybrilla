package com.doodleblue.cybrilla.Bank.model;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class Debit {
    private long accountNum;
    private Double amount;
    private int accountType;
    private long toAccountNo;
    private String note;
    private String toIfscCode;
    @CreatedDate
    private Date debitedAt;

    public Debit() {
    }

    public Debit(long accountNum, Double amount, int accountType, long toAccountNo, String note, String toIfscCode, Date debitedAt) {
        this.accountNum = accountNum;
        this.amount = amount;
        this.accountType = accountType;
        this.toAccountNo = toAccountNo;
        this.note = note;
        this.toIfscCode = toIfscCode;
        this.debitedAt = debitedAt;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public long getToAccountNo() {
        return toAccountNo;
    }

    public void setToAccountNo(long toAccountNo) {
        this.toAccountNo = toAccountNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getToIfscCode() {
        return toIfscCode;
    }

    public void setToIfscCode(String toIfscCode) {
        this.toIfscCode = toIfscCode;
    }

    public Date getDebitedAt() {
        return debitedAt;
    }

    public void setDebitedAt(Date debitedAt) {
        this.debitedAt = debitedAt;
    }
}
