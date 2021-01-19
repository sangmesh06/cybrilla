package com.doodleblue.cybrilla.Bank.controller;

import com.doodleblue.cybrilla.Bank.dao.CustomerDaoImpl;
import com.doodleblue.cybrilla.Bank.model.Customer;
import com.doodleblue.cybrilla.Bank.response.CybrillaResponse;
import com.doodleblue.cybrilla.Bank.util.Constants;
import com.doodleblue.cybrilla.Bank.util.UtilMethods;
import com.doodleblue.cybrilla.Bank.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class CustomerController {

    @Autowired
    Validation validation;
    @Autowired
    CustomerDaoImpl customerDao;
    @Autowired
    UtilMethods utilMethods;
    @RequestMapping(value="/addAccount", method= RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<CybrillaResponse> add(@RequestBody Customer customer) {
        customer.setStatus(1);
        customer.setAccountNo(utilMethods.getAccountNo());
        customer.setIfscCode(utilMethods.getIfscCode());
        String valid=validation.customerValid(customer);
        if(valid==null){
            Customer customer1=customerDao.add(customer);
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(customer1).setMessage(Constants.DATA_ADDED_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
            return ResponseEntity.ok().body(response);
        }
        else{
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(valid).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/getAccount")
    public @ResponseBody
    ResponseEntity<CybrillaResponse> getAccountDetails(@RequestParam("accNo") long accNo) {
        System.out.println(accNo);
        if(accNo>0) {
                Customer customer=customerDao.getAcc(accNo);
                if(customer!=null){
                    CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(customer).setMessage(Constants.DATA_FETCH_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
                    return ResponseEntity.ok().body(response);
                }
                else {
                    CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.USER_NOT_FOUND).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
                    return ResponseEntity.badRequest().body(response);
                }
        }
        else{
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.INVALID_DATA).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @PutMapping("/update")
    public @ResponseBody
    ResponseEntity<CybrillaResponse> update(@RequestBody Customer customer) {
        String valid=validation.customerValid(customer);
        if(valid==null) {
            Customer customer1=customerDao.getAcc(customer.getAccountNo());
            if(customer1!=null){
                customerDao.update(customer);
                CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(customer).setMessage(Constants.DATA_UPDATED_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
                return ResponseEntity.ok().body(response);
            }
            else {
                CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(Constants.USER_NOT_FOUND).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
                return ResponseEntity.badRequest().body(response);
            }
        }
        else{
            CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(null).setMessage(valid).setStatus(false).setStatusCode(Constants.BAD_REQUEST_CODE).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/getAll")
    public @ResponseBody ResponseEntity<CybrillaResponse> getAccountDetails() {
        List<Customer> customerList=customerDao.getAll();
        CybrillaResponse response = new CybrillaResponse.CybrillaResponseBuilder().setData(customerList).setMessage(Constants.DATA_UPDATED_MESSAGE).setStatus(true).setStatusCode(Constants.SUCCESS_CODE).build();
        return ResponseEntity.ok().body(response);
    }

}
