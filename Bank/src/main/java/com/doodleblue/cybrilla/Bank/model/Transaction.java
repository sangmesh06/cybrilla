package com.doodleblue.cybrilla.Bank.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String id;
    private int type;
    private long accountNo;
    private Credit credit;
    private Debit debit;

    public Transaction() {
    }

    public Transaction(String id, int type, long accountNo, Credit credit, Debit debit) {
        this.id = id;
        this.type = type;
        this.accountNo = accountNo;
        this.credit = credit;
        this.debit = debit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }
}
