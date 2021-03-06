package com.tweet.app.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamoDBTable(tableName = "tweet")
public class Tweet {


    @DynamoDBHashKey(attributeName = "tweetId")
    @DynamoDBAutoGeneratedKey
    private String tweetId;
    @DynamoDBAttribute(attributeName = "userLoginId")
    private String userLoginId;
    @DynamoDBAttribute(attributeName = "tweetMessage")
    private String tweetMessage;
    @DynamoDBAttribute(attributeName = "hashTag")
    private String hashTag;
    @DynamoDBAttribute(attributeName = "dateOfPost")
    private String  dateOfPost;

    @DynamoDBAttribute(attributeName = "likesCount")
    private int likesCount;
    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "replies")
    private List<Reply> replies;

}
