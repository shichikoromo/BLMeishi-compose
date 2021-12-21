package com.ayasakinui.twitterservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    private static final Logger log = LoggerFactory.getLogger(TwitterController.class);

    private Twitter twitter;

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
        RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL);
        return new RedirectView(requestToken.getAuthorizationURL());
    }

    @RequestMapping("success")
    public String success(@RequestParam String oauth_token, @RequestParam String oauth_verifier) throws Exception{
        twitter.setOAuthAccessToken(new AccessToken(oauth_token,oauth_verifier));

        String success = "success!!<br><br>"+
                "<b>twitter: </b><br>" + String.valueOf(twitter) + "<br><br>" +
                "<b>twitter: </b><br>" + String.valueOf(twitter) + "<br><br>" +
                "<b>oauth_token:</b>  " + oauth_token +  "<br><br>" +
                "<b>oauth_verifier: </b> " + oauth_verifier + "<br><br>"; // +
                //"<b>Screen Name: </b> " +twitter.verifyCredentials().getScreenName();
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
