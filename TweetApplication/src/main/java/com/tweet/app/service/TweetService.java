package com.tweet.app.service;


import com.tweet.app.dao.TweetRepository;
import com.tweet.app.dao.UserRepository;
import com.tweet.app.exception.TweetIdNotFoundException;

import com.tweet.app.exception.TweetNotFoundException;
import com.tweet.app.model.Reply;
import com.tweet.app.model.Tweet;
import com.tweet.app.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {



    @Autowired
    TweetRepository repository;
    @Autowired
    UserRepository userRepository;

    public List<Tweet> getTweets(){
        return (List<Tweet>) repository.findAll();
    }

    public List<Tweet> getTweetByUser(String loginId) throws TweetNotFoundException {


        List<Tweet> userTweet = repository.findByUserLoginId(loginId);
        if (userTweet == null)
            throw new TweetNotFoundException();
        else
        return userTweet;



    }

    public Tweet createTweet(String loginId,Tweet tweet) {
        Tweet tweet1 = new Tweet();
        Date date= new Date();
        String value= DateUtil.convertToTime();
//        Long timestamp=Long.parseLong(tweet.getCreatedTs().toString());

        Long timeMilli = date.getTime();
        tweet1.setTweetId(timeMilli.toString());
        tweet1.setUserLoginId(loginId);
        tweet1.setTweetMessage(tweet.getTweetMessage());
        tweet1.setDateOfPost(value);

        tweet1.setHashTag(tweet.getHashTag());

        tweet1.setReplies(tweet.getReplies());
        return  repository.save(tweet1);
    }

    public void deleteById(String tweetId) throws TweetIdNotFoundException {
        try{
            repository.deleteById(tweetId);
        }catch (Exception e){
            throw new TweetIdNotFoundException();
        }

    }


    public void updateLike(String tweetId) throws TweetIdNotFoundException {
        if(repository.findById(tweetId).isPresent()){
            Tweet t1 = repository.findById(tweetId).get();
            int likes= t1.getLikesCount();
            likes++;
            t1.setLikesCount(likes);
            repository.save(t1);
        }
        else
            throw  new TweetIdNotFoundException();
    }

    public void updateDislike(String tweetId, Tweet tweet) {

        Tweet t1 = repository.findById(tweetId).get();
        int likes = t1.getLikesCount();
        likes--;
        t1.setLikesCount(likes);
        repository.save(t1);
    }

    public void replyUserTweet(String tweetId, Reply replyTweet) throws TweetIdNotFoundException {

        Tweet tweet = repository.findById(tweetId).get();
        if (tweet == null)
            throw new TweetIdNotFoundException();
        Date date= new Date();
//        Long timestamp=Long.parseLong(tweet.getDateOfPost().toString());
        String value= DateUtil.convertToTime();
        Long timeMilli = date.getTime();
        Reply tweetReply = new Reply();
        tweetReply.setDateOfReply(value);
        tweetReply.setUserLoginId(replyTweet.getUserLoginId());
        tweetReply.setReplyText(replyTweet.getReplyText());

        if(tweet.getReplies() != null)
            tweet.getReplies().add(tweetReply);
        else{
            List<Reply> reply = new ArrayList<>();
            reply.add(tweetReply);
            tweet.setReplies(reply);
        }
        repository.save(tweet);

    }


}
