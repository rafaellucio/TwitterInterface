package br.com.app.twitter;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEnd.java
 * FIAP / RM30318 - Rafael Antonio Lucio
 */

import javax.swing.JOptionPane;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterSendTweet {
	
	public static void sendMessage(String message) {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		
		configurationBuilder
			.setOAuthConsumerKey(TwitterAuth.API_KEY.getKey())
			.setOAuthConsumerSecret(TwitterAuth.API_SECRET.getKey());
		
		Configuration configuration = configurationBuilder.build();
		
		TwitterFactory twitterFactory = new TwitterFactory(configuration);
		Twitter twitter = twitterFactory.getInstance();
		
		AccessToken accessToken = accessToken();
		
		twitter.setOAuthAccessToken(accessToken);
		Status status;
		
		try {
			status = twitter.updateStatus(message);
			JOptionPane.showMessageDialog(null, "Tweet postado com sucesso! [" + status.getText() + "]");
		} catch (TwitterException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível enviar o tweet");
			e.printStackTrace();
		}
	}
	
	public static AccessToken accessToken() {
		return new AccessToken(TwitterAuth.ACCESS_TOKEN.getKey(), TwitterAuth.ACCESS_TOKEN_SECRET.getKey());
	}
}
