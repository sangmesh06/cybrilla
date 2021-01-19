package com.doodleblue.cybrilla.Bank.controller;

import com.doodleblue.cybrilla.Bank.dao.CustomerDaoImpl;
import com.doodleblue.cybrilla.Bank.dao.TransactionDaoImpl;
import com.doodleblue.cybrilla.Bank.model.Balance;
import com.doodleblue.cybrilla.Bank.model.Customer;
import com.doodleblue.cybrilla.Bank.model.Transaction;
import com.doodleblue.cybrilla.Bank.response.CybrillaResponse;
import com.doodleblue.cybrilla.Bank.util.Constants;
import com.doodleblue.cybrilla.Bank.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerDaoImpl customerDao;
    @Autowired
    Validation validation;
    @Autowired
    TransactionDaoImpl transactionDao;
    @RequestMapping(value="/transaction", method= RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<CybrillaResponse> transaction(@RequestBody Transaction transaction) {
        Customer customer=customerDao.getAcc(transaction.getAccountNo());
        if(customer!=null){
            String valid= validation.transactionValid(transaction);
            if(valid==null){
                Transaction transaction1=transactionDao.save(transaction);
                CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(transaction1).setMessage(Constants.DATA_ADDED_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
                return ResponseEntity.ok().body(response);
            }
            else {
                CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(valid).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
                return ResponseEntity.badRequest().body(response);
            }
        }
        else{
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.USER_NOT_FOUND).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
            return ResponseEntity.badRequest().body(response);
        }

    }

    @RequestMapping(value="/balance", method= RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<CybrillaResponse> balance(@RequestParam("id") long id) {
        Customer customer=customerDao.getAcc(id);
        if(customer!=null){
            double savings=transactionDao.getSum(id,1);
            double current=transactionDao.getSum(id,2);
            Balance balance=new Balance(savings,current);
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(balance).setMessage(Constants.DATA_FETCH_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
            return ResponseEntity.ok().body(response);
        }
        else{
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.USER_NOT_FOUND).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @RequestMapping(value="/getAll", method= RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<CybrillaResponse> getAll(@RequestParam("id") long id) {
        Customer customer=customerDao.getAcc(id);
        if(customer!=null){
           List<Transaction>transactions=transactionDao.getAll(id);
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(transactions).setMessage(Constants.DATA_FETCH_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
            return ResponseEntity.ok().body(response);
        }
        else {
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.USER_NOT_FOUND).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @RequestMapping(value="/getById", method= RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<CybrillaResponse> getById(@RequestParam("id") String id) {
            Transaction transaction=transactionDao.getById(id);
            if(transaction!=null){
                CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(transaction).setMessage(Constants.DATA_FETCH_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
                return ResponseEntity.ok().body(response);
            }
            else{
                CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.INVALID_DATA).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
                return ResponseEntity.badRequest().body(response);
            }
    }
}
