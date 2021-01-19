package com.doodleblue.cybrilla.Bank.util;

import com.doodleblue.cybrilla.Bank.dao.CustomerDaoImpl;
import com.doodleblue.cybrilla.Bank.dao.TransactionDaoImpl;
import com.doodleblue.cybrilla.Bank.model.Credit;
import com.doodleblue.cybrilla.Bank.model.Customer;
import com.doodleblue.cybrilla.Bank.model.Debit;
import com.doodleblue.cybrilla.Bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Validation {
    @Autowired
    CustomerDaoImpl customerDao;
    @Autowired
    UtilMethods utilMethods;
    @Autowired
    TransactionDaoImpl transactionDao;
    public String customerValid(Customer customer){
            if (customer.getCustomerName()==null||customer.getCustomerName().equals("")){
                return "Invalid Customer Name";
            }
            if (customer.getAccountNo()==null||customer.getAccountNo()<=0){
                return "Invalid Account Number";
            }
            if (customer.getMobileNo()==null||customer.getMobileNo().equals("")||!utilMethods.isValidMobileNumber(customer.getMobileNo())){
                return "Invalid Mobile Number";
            }
            if (customer.getAddress()==null||customer.getAddress().equals("")){
                return "Invalid Address";
            }
            if (customer.getEmailId()!=null||!customer.getEmailId().equals("")){
                if(!utilMethods.isValidEmail(customer.getEmailId())){
                    return "Invalid Email Id";
                }
            }
            if(customer.getZipcode()==null||customer.getZipcode().equals("")||!utilMethods.isValidZipCode(customer.getZipcode())){
                return "Invalid Zipcode";
            }
           if (customer.getPanNumber()!=null){
               if(!utilMethods.isValidPan(customer.getPanNumber())){
                   return "Invalid Pan Card Number";
               }
           }
            return null;
    }
    public String transactionValid(Transaction transaction){
        if(transaction.getType()<=0||transaction.getType()>=3){
            return "Invalid Transaction Type";
        }
        if(transaction.getType()==1){
            Credit credit=transaction.getCredit();
            if(credit.getAccountNum()<=0){
                return "Invalid Account Number";
            }
            if(credit.getAccountType()<=0||credit.getAccountType()>=3){
                return "Invalid Account Type";
            }
            Double sum=transactionDao.getSum(transaction.getAccountNo(),credit.getAccountType());
            if(sum<=0){
                return "Low Balance";
            }
            if(credit.getAmount()<=0){
                return "Invalid Amount";
            }
            if (credit.getAmount()>50000){
                return "Invalid Amount";
            }
          if(credit.getFromAccountNo()<=0){
              return "Invalid From Account Number";
          }
        }
        if (transaction.getType()==2){
            Debit debit=transaction.getDebit();
            if(debit.getAccountNum()<=0){
                return "Invalid Account Number";
            }
            if(debit.getAccountType()<=0||debit.getAccountType()>=3){
                return "Invalid Account Type";
            }

            if(debit.getAmount()<=0){
                return "Invalid Amount";
            }
            if (debit.getAmount()>50000){
                return "Invalid Amount";
            }
            Customer customer=customerDao.getAccByIfsc(debit.getToAccountNo(),debit.getToIfscCode());
            if(customer==null){
                return "Invalid Receiver Details";
            }
        }
        return null;
    }
}
