package com.tweet.app.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.tweet.app.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository  {

    @Autowired
    private DynamoDBMapper dbMapper;

    public User findByLoginId(String name){
        return  dbMapper.load(User.class,name);
    }

    public  void save(User user){
          dbMapper.save(user);
    }

    public List<User> findAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<User> iList = dbMapper.scan(User.class, scanExpression);
        return  iList;
    }
}
