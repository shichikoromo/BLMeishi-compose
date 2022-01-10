package com.ayasakinui.twitterservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    private static final Logger log = LoggerFactory.getLogger(TwitterController.class);
    private static final String CONSUMER_KEY = "consumer key";
    private static final String CONSUMER_SECRET = "consumer secret";

    private static String ACCES_TOKEN = null;
    private static String ACCES_SECRET = null;


    private Twitter twitter;
    private RequestToken requestToken;

    @PostConstruct
    private void ctor() {
        this.twitter = new TwitterFactory().getInstance();
    }

    @RequestMapping("user")
    public String auth() throws Exception {

        String out =
                "<b>twitter: </b><br>" + String.valueOf(twitter) + "<br><br>" +
                "<b>twitter.getOAuthRequestToken(): </b><br>" + String.valueOf(twitter.getOAuthRequestToken());// +
        //"<b>twitter.getOAuthAccessToken(): </b><br>" + String.valueOf(twitter.getOAuthAccessToken());

        return out;
    }

    @RequestMapping(value = "oauth")
    public RedirectView oauth() throws Exception {
        String callbackURL = "http://localhost:8080/twitter/success";
        requestToken = twitter.getOAuthRequestToken(callbackURL);

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(CONSUMER_KEY);
        configurationBuilder.setOAuthConsumerSecret(CONSUMER_SECRET);
        Configuration configuration = configurationBuilder.build();
        twitter = new TwitterFactory(configuration).getInstance();

        return new RedirectView(requestToken.getAuthenticationURL());
    }

    @RequestMapping("success")
    public String success(@RequestParam String oauth_token, @RequestParam String oauth_verifier) throws Exception {

        //アクセストークンを取得
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauth_verifier);

        ACCES_TOKEN = accessToken.getToken();
        ACCES_SECRET = accessToken.getTokenSecret();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setApplicationOnlyAuthEnabled(false);
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCES_TOKEN)
                .setOAuthAccessTokenSecret(ACCES_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();


        User user = twitter.verifyCredentials();


        String success = "success!!<br><br>" +
                "<b>twitter: </b><br>" + twitter + "<br><br>" +
                //"<b>TwitterFactory: </b><br>" + String.valueOf(tf) + "<br><br>" +
                "<b>accesToken: </b><br>" + accessToken + "<br><br>" +
                "<b>accesToken.getToken(): </b><br>" + accessToken.getToken() + "<br><br>" +
                "<b>accesToken.getTokenSecret(): </b><br>" + accessToken.getTokenSecret() + "<br><br>" +
                "<b>user: </b><br>" + user + "<br><br>" +
                "<b>user id: </b>" + user.getName() + "<br><br>" +
                "<b>user name: </b>" + user.getScreenName() + "<br><br>" +
                "<b>user icon: </b><img src=\"" + user.get400x400ProfileImageURL() + "\"><br><br>" +
                "<b>user follower: </b>" + user.getFollowersCount() + "<br><br>" +
                "<b>user fav: </b>" + user.getFavouritesCount() + "<br><br>" +
                "<b>oauth_token:</b>  " + oauth_token + "<br><br>" +
                "<b>oauth_verifier: </b> " + oauth_verifier + "<br><br>";
        //"<b>Screen Name: </b> " + twitter.getScreenName();
        return success;
    }

    /*
    public User user() throws Exception {
        User user = twitter.verifyCredentials();

        String userName = user.getName();
        String displayName = user.getScreenName();
        int fav = user.getFavouritesCount();

        log.info("名前：   {}", userName);
        log.info("表示：   {}", displayName);
        log.info("すき：   {}", fav);

        return user;
    }
     */

}
