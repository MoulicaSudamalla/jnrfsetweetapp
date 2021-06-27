package com.tweet.app.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamoDBDocument
public class Reply {

    private String replyText;
    private String userLoginId;
    private String tweetId;
    private String dateOfReply;




}
