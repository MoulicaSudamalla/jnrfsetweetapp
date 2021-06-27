package com.tweet.app.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.springframework.stereotype.Indexed;


@Data
@DynamoDBTable(tableName = "user")
public class User {

    @DynamoDBHashKey(attributeName = "loginId")
    private String loginId;
    @DynamoDBAttribute(attributeName = "firstName")
    private String firstName;
    @DynamoDBAttribute(attributeName = "lastName")
    private String lastName;
    @DynamoDBAttribute(attributeName = "mailId")
    private  String mailId;
    @DynamoDBAttribute(attributeName = "passWord")
    private String passWord;
    @DynamoDBAttribute(attributeName = "contactNumber")
    private Long contactNumber;




}
