package com.doodleblue.cybrilla.Bank.dao;

import com.doodleblue.cybrilla.Bank.model.Customer;
import com.doodleblue.cybrilla.Bank.util.UtilMethods;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UtilMethods utilMethods;
    public Customer add(Customer customer){

        return mongoTemplate.save(customer);
    }
    public Customer getAcc(long id){
        Query query = new Query();
        query.addCriteria(Criteria.where("accountNo").is(id).and("status").is(1).and("deleteFlag").is(0));
        Customer customer=mongoTemplate.findOne(query,Customer.class);
        return customer;
    }
    public UpdateResult update(Customer customer){
        Query query = new Query();
        query.addCriteria(Criteria.where("accountNo").is(customer.getAccountNo()).and("deleteFlag").is(0));
        Update update=new Update();
        update.set("customerName",customer.getCustomerName());
        update.set("mobileNo",customer.getMobileNo());
        update.set("address",customer.getAddress());
        update.set("emailId",customer.getEmailId());
        update.set("status",customer.getStatus());
        update.set("zipcode",customer.getZipcode());
        update.set("panNumber",customer.getZipcode());
        return mongoTemplate.updateFirst(query,update,Customer.class);
    }
    public List<Customer> getAll(){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").ne(null).and("status").is(1).and("deleteFlag").is(0));
        return mongoTemplate.find(query,Customer.class);
    }
    public Customer getAccByIfsc(Long id,String ifsc){
        Query query = new Query();
        query.addCriteria(Criteria.where("accountNo").is(id).and("IfscCode").is(ifsc).and("status").is(1).and("deleteFlag").is(0));
        Customer customer=mongoTemplate.findOne(query,Customer.class);
        return customer;
    }
}
