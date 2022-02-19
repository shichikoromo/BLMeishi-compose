package com.ayasakinui.twitterservice.controller;

import com.ayasakinui.twitterservice.dataAccess.entity.Member;
import com.ayasakinui.twitterservice.dataAccess.repository.MemberRepository;
import com.ayasakinui.twitterservice.service.TwitterOath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    //private static final Logger log = LoggerFactory.getLogger(TwitterController.class);

    private static String ACCES_TOKEN = null;
    private static String ACCES_SECRET = null;

    private final MemberRepository memberRepository;

    private Twitter twitter = TwitterFactory.getSingleton();;
    private RequestToken requestToken;

    private TwitterOath twitterOath = new TwitterOath();

    public TwitterController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    private void ctor() {
        this.twitter = new TwitterFactory().getInstance();
    }

    /*
    @RequestMapping("user")
    public String auth() throws Exception {

        String out =
                "<b>twitter: </b><br>" + String.valueOf(twitter) + "<br><br>" +
                "<b>twitter.getOAuthRequestToken(): </b><br>" + String.valueOf(twitter.getOAuthRequestToken());// +
        //"<b>twitter.getOAuthAccessToken(): </b><br>" + String.valueOf(twitter.getOAuthAccessToken());

        return out;
    }*/

    @RequestMapping(value = "oauth")
    public String oauth() throws Exception {
        //twitterOath.oauth();
        /*
        String callbackURL = "http://localhost:8080/twitter/success";
        requestToken = twitter.getOAuthRequestToken(callbackURL);

        return new RedirectView(requestToken.getAuthenticationURL());

         */
        return "oauth";
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
                //.setOAuthConsumerKey(CONSUMER_KEY)
                //.setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCES_TOKEN)
                .setOAuthAccessTokenSecret(ACCES_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();


        User user = twitter.verifyCredentials();

        String memberStatus = createUser(user.getName(),user.getScreenName(),accessToken.getToken(),accessToken.getTokenSecret());

        String success =
                memberStatus+
                "<br><br>---------------------------------------------------------------------------------------------<br><br>"+
                "success!!<br><br>" +
                "<b>twitter: </b><br>" + twitter + "<br><br>" +
                //"<b>TwitterFactory: </b><br>" + String.valueOf(tf) + "<br><br>" +
                "<b>accesToken: </b><br>" + accessToken + "<br><br>" +
                "<b>accesToken.getToken(): </b><br>" + accessToken.getToken() + "<br><br>" +
                "<b>accesToken.getTokenSecret(): </b><br>" + accessToken.getTokenSecret() + "<br><br>" +
                "<b>user: </b><br>" + user + "<br><br>" +
                "<b>user name: </b>" + user.getName() + "<br><br>" +
                "<b>user id: </b>" + user.getScreenName() + "<br><br>" +
                "<b>user icon: </b><img src=\"" + user.get400x400ProfileImageURL() + "\"><br><br>" +
                "<b>user follower: </b>" + user.getFollowersCount() + "<br><br>" +
                "<b>user fav: </b>" + user.getFavouritesCount() + "<br><br>" +
                "<b>oauth_token:</b>  " + oauth_token + "<br><br>" +
                "<b>oauth_verifier: </b> " + oauth_verifier + "<br><br>";
        //"<b>Screen Name: </b> " + twitter.getScreenName();
        return success;
    }

    public String createUser(String name, String twitterId, String accesToken, String accessSecret) {
        Member member = new Member();
        member.setName(name);
        member.setTwitterId(twitterId);
        member.setAccessToken(accesToken);
        member.setAccessSecret(accessSecret);
        memberRepository.save(member);
        return "createUser(): success!!<br>"+member;
    }
}
