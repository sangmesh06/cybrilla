package com.doodleblue.cybrilla.Bank.model;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class Credit {
    private long accountNum;
    private Double amount;
    private int accountType;
    private long fromAccountNo;
    private String fromIfscCode;
    private String note;
    @CreatedDate
    private Date creditedAt;

    public Credit() {
    }

    public Credit(long accountNum, Double amount, int accountType, long fromAccountNo, String fromIfscCode, String note, Date creditedAt) {
        this.accountNum = accountNum;
        this.amount = amount;
        this.accountType = accountType;
        this.fromAccountNo = fromAccountNo;
        this.fromIfscCode = fromIfscCode;
        this.note = note;
        this.creditedAt = creditedAt;
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

    public long getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(long fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public String getFromIfscCode() {
        return fromIfscCode;
    }

    public void setFromIfscCode(String fromIfscCode) {
        this.fromIfscCode = fromIfscCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreditedAt() {
        return creditedAt;
    }

    public void setCreditedAt(Date creditedAt) {
        this.creditedAt = creditedAt;
    }
}
