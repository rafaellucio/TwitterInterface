package app;


import java.util.*;

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
			
			Query query = new Query("java");
			query.setSince("2016-05-08");
			query.setUntil("2016-05-14");
			QueryResult result;
			int contador=0;
			List<Usuarios> usuarios = new ArrayList<>();
			result = t.getTweet().search(query);
			while (result.hasNext())
			{
				query = result.nextQuery();
				for (Status status : result.getTweets()) {
					contador++;
					//System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
					
					Usuarios usuario =  new Usuarios(status.getUser().getScreenName(), status.getText(), status.getCreatedAt());
					usuarios.add(usuario);
					//System.out.println("N�mero de Favoritos: " + status.getFavoriteCount());
					//System.out.println("Lugar: " + status.getPlace());
					//System.out.println("N�mero de Retweets: " + status.getRetweetCount());

				}
				result = t.getTweet().search(query);
			}
			
			usuarios.sort();
			
			System.out.println("Tag java:"+contador+" tweets");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
