package app;

import twitter.TwitterDef;
import twitter4j.*;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEnd.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class FrontEnd {
	
	
	public static void main(String[] args) {
		
		TwitterDef t = new TwitterDef();
		
		try {
			
			t.getTweet().updateStatus("Olá Twitter! ");
			
			
			
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		System.out.println("Test Main");
		
		
		
	}

}
