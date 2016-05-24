/**
 * 
 */
package twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 20160519-AtividadeFinal-Twitter / TwitterDef.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class TwitterDef {
	
	private ConfigurationBuilder b;
	private TwitterFactory factory;
	private AccessToken act;
	private Twitter tweet;
	
	

	public TwitterDef() {
		super();
		 b = new ConfigurationBuilder();
		 
		 b.setOAuthConsumerKey(TwetterAuth_vpanarello.API_KEY.getKey());
		 b.setOAuthConsumerSecret(TwetterAuth_vpanarello.API_SECRET.getKey());
		 
		 factory = new TwitterFactory(b.build());
		 act = new AccessToken(TwetterAuth_vpanarello.ACCESS_TOKEN.getKey(), TwetterAuth_vpanarello.ACCESS_TOKEN_SECRET.getKey());
		 
		 tweet = factory.getInstance(act);
		
	}


	public Twitter getTweet() {
		return tweet;
	}
	
	
	
	
	
	
	
	

}
