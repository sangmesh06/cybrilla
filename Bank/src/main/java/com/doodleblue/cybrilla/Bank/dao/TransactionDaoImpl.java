package com.doodleblue.cybrilla.Bank.dao;

import com.doodleblue.cybrilla.Bank.model.Customer;
import com.doodleblue.cybrilla.Bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl {

    @Autowired
    MongoTemplate mongoTemplate;

    public double getSum(long id,int type){
        Query query = new Query();
        if(type==2) {
            query.addCriteria(Criteria.where("debit.accountNum").is(id).and("type").is(type));
        }
        else{
            query.addCriteria(Criteria.where("credit.accountNum").is(id).and("type").is(type));
        }
         List<Transaction> transactions=mongoTemplate.find(query,Transaction.class);
        Double amount=0.0;
        for(Transaction transaction:transactions){
            if(type==1){
                amount=amount+transaction.getCredit().getAmount();
            }
            else {
                amount=amount+transaction.getDebit().getAmount();
            }
        }
return amount;
    }
    public Transaction save(Transaction transaction){
        return mongoTemplate.save(transaction);
    }
    public List<Transaction> getAll(Long id){
        Query query = new Query();
        query.addCriteria(Criteria.where("accountNo").is(id));
        return mongoTemplate.find(query,Transaction.class);
    }
    public Transaction getById(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,Transaction.class);
    }
}
