package com.tweet.app.dao;

import com.tweet.app.model.Tweet;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@EnableScan
public interface TweetRepository extends CrudRepository<Tweet,String>  {
    List<Tweet> findByUserLoginId(String loginId);


//    @Autowired
//    private DynamoDBMapper dynamoDBMapper;
//
//    public Tweet save(Tweet tweet){
//        dynamoDBMapper.save(tweet);
//        return tweet;
//    }
//
//    public List<Tweet> getAllTweets() {
//        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
//        List<Tweet> iList = dynamoDBMapper.scan(Tweet.class, scanExpression);
//        return iList;
//    }
//
//    public Tweet findById(String loginId){
//
//
//
//        return dynamoDBMapper.load(Tweet.class, loginId);
//    }
//    public void deleteByTweetId(String tweetId) {
//        Tweet tweet = dynamoDBMapper.load(Tweet.class, tweetId);
//        dynamoDBMapper.delete(tweet);
//    }
//    public List<Tweet> findByUserLoginId(String userLoginId){
//        HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//        eav.put(":v1", new AttributeValue().withS(userLoginId));
//
//        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
//                .withFilterExpression("begins_with(userLoginId,:v1)")
//                .withExpressionAttributeValues(eav);
//        List<Tweet> users = dynamoDBMapper.scan(Tweet.class,scanExpression);
//
//        return users;
//
//    }
}
