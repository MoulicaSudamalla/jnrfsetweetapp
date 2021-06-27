package com.tweet.app.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.Data;


import java.util.List;

@Data
public class DestinationModel {

    @DynamoDBHashKey
    private Long tweetId;
    private String userLoginId;
    private String tweetMessage;
    private String hashTag;
    private String  dateOfPost;
    private List<Reply> replies;
    private int likesCount;
}
