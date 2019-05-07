package com.example.athunter.model;

import com.example.athunter.config.AppConfig;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

public class Tweet {

    private String id;
    private String text;
    private String name;
    private String imageUrl;
    private Long time;

    public Tweet() {

    }

    public Tweet(String text, String name, String imageUrl, Long time) {
        this.text = text;
        this.name = name;
        this.imageUrl = imageUrl;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static Action getViewTweetAction(Tweet tweet) {
        return new Action.Builder(Action.Builder.VIEW_ACTION)
                .setObject(tweet.getName(), AppConfig.TWEET_URL.concat(tweet.getId()))
                .setMetadata(new Action.Metadata.Builder().setUpload(false))
                .build();
    }

    public static Indexable getTweetPageable(Tweet tweet) {
        return Indexables.messageBuilder()
                .setName(tweet.getText())
                .setUrl(AppConfig.TWEET_URL.concat(tweet.getId()))
                .build();
    }
}