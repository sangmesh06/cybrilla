package com.doodleblue.cybrilla.Bank.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;
    private String customerName;
    private Long accountNo;
    private String IfscCode;
    private String mobileNo;
    private String address;
    private String emailId;
    private String username;
    private String password;
    private int status;
    private int deleteFlag;
    private String zipcode;
    private String panNumber;
    @CreatedDate
    private Date createdAt;
    private Date updatedAt;

    public Customer() {
    }

    public Customer(String id, String customerName, Long accountNo, String ifscCode, String mobileNo, String address, String emailId, String username, String password, int status, int deleteFlag, String zipcode, String panNumber, Date createdAt, Date updatedAt) {
        this.id = id;
        this.customerName = customerName;
        this.accountNo = accountNo;
        IfscCode = ifscCode;
        this.mobileNo = mobileNo;
        this.address = address;
        this.emailId = emailId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.deleteFlag = deleteFlag;
        this.zipcode = zipcode;
        this.panNumber = panNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getIfscCode() {
        return IfscCode;
    }

    public void setIfscCode(String ifscCode) {
        IfscCode = ifscCode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
