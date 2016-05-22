/**
 * 
 */
package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter.TwitterDef;
import twitter4j.*;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEndFunctions.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class TwitterQueries {
	
	private List<Tweet> queryResult;
	private TwitterDef twitterApi;
	
	private int limit, remaining;

	public TwitterQueries() {
		super();
		twitterApi = new TwitterDef();
		queryResult = new ArrayList<>();
	}
	private void doQuery(Query query){
		
		try {
            QueryResult result;
            do {
                result = twitterApi.getTweet().search(query);
                List<Status> tweets = result.getTweets();
                
                for (Status tweet : tweets) {
                	
                	queryResult.add(new Tweet(
                			tweet.getCreatedAt(),
                			tweet.getUser().getScreenName(),
                			tweet.getText(),
                			tweet.isRetweet(),
                			tweet.isRetweeted(),
                			tweet.isRetweetedByMe(),
                			tweet.isFavorited()
                			));
                	}
   
            } while ((query = result.nextQuery()) != null);
            
            this.limit = result.getRateLimitStatus().getLimit();
            this.remaining = result.getRateLimitStatus().getRemaining();
            
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println("Failed to search tweets: " + e.getMessage());
        }	
	}
	
	public List<Tweet> getQueryResult() {
		return queryResult;
	}
	public int getLimit() {
		return limit;
	}
	public int getRemaining() {
		return remaining;
	}



	/**
	 * Retorna a quantidade de Tweets por dia na última semana
	 * mensionando deteminada Hashtag
	 * Essa chamada pode ser feita somente 15 vezes a cada 15 minutos
	 * <p>
	 * @param  hashTag  Twitter hashTag text without "#" character
	 * @return      void
	 */
	
	public void getLastWeekTweets(String hashTag) {
		doQuery(new Query(hashTag));
		
	}
	

	public void getLastWeekReTweets(String hashTag){
		
		
		
		
	}
	
	public void getLastWeekFavorites(String hashTag){
		
		
		
		
	}
	
	public void sortTweets(String authorName){
		
		
		
		
	}
	
	public void sortTweets(Date beginDate, Date endDate){
		
		
		
		
		
		
	}
	
	
	
	public void getTimelineTweets(){
		
		try {
			List<Status> st = twitterApi.getTweet().getHomeTimeline();
			
			for (Status status : st) {
				System.out.println(status.getUser().getName() + ": " + status.getText());
			}
			
			
		} catch (TwitterException e) {
			System.out.println("Erro com Twitter API: " + e.getMessage());
		}
	}
		
		
		
	
		
		
		
//		public void getQuery(){
//
//			try {	
//
//				Query query = new Query("java");
//				query.setSince("2016-05-08");
//				query.setUntil("2016-05-14");
//				QueryResult result;
//				int contador=0;
//				List<Usuarios> usuarios = new ArrayList<>();
//				result = twitterApi.getTweet().search(query);
//				while (result.hasNext())
//				{
//					query = result.nextQuery();
//					for (Status status : result.getTweets()) {
//						contador++;
//						//System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
//
//						Usuarios usuario =  new Usuarios(status.getUser().getScreenName(), status.getText(), status.getCreatedAt());
//						usuarios.add(usuario);
//						//System.out.println("Número de Favoritos: " + status.getFavoriteCount());
//						//System.out.println("Lugar: " + status.getPlace());
//						//System.out.println("Número de Retweets: " + status.getRetweetCount());
//
//					}
//					result = twitterApi.getTweet().search(query);
//				}
//
//				//						usuarios.sort();
//
//				System.out.println("Tag java:"+contador+" tweets");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
}
