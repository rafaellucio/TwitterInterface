/**
 * 
 */
package app;

import java.time.*;
import java.util.*;


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
                			tweet.getUser().getName(),
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
	
	public enum TweetType {
		ALL,
		RETWEET,
		RETWEETED,
		RETWEETEDBYME,
		FAVORITED;
	}
	
	
	public List<Tweet> getQueryResult() {
		return this.getQueryResult(TweetType.ALL);
	}
	
	/* (non-Javadoc)
	 * @see app.Twitter#getQueryResult()
	 */

	public List<Tweet> getQueryResult(TweetType tweetType) {
		
		List<Tweet> queryResult =  new ArrayList<>();
		
		
		switch(tweetType){
		case FAVORITED:
			
			for (Tweet tweet : this.queryResult) {
				if(tweet.isFavorited()) queryResult.add(tweet);
			}
			break;
			
		case RETWEET:
			for (Tweet tweet : this.queryResult) {
				if(tweet.isRetweet()) queryResult.add(tweet);
			}
			break;
			
		case RETWEETED:
			for (Tweet tweet : this.queryResult) {
				if(tweet.isRetweeted()) queryResult.add(tweet);
			}
			break;
			
		case RETWEETEDBYME:
			for (Tweet tweet : this.queryResult) {
				if(tweet.isRetweetedByMe()) queryResult.add(tweet);
			}
			break;
			
		case ALL:
			for (Tweet tweet : this.queryResult) {
				queryResult.add(tweet);
			}
		}
		
		return queryResult;
	}

	
	public void getTweets(String hashTag) {
		doQuery(new Query(hashTag));
	}
	

	public void getTweets(String hashTag, LocalDate since) {
		Query query = new Query(hashTag);
		query.since(since.toString());
		this.doQuery(query);	
	}
	
	
	public enum SortTweetsBy {
		DATE_NEW_TO_OLD,
		DATE_OLD_TO_NEW,
		NAME_A_TO_Z,
		NAME_Z_TO_A;
	}
	
	
	public void sortTweets(SortTweetsBy sortTweetsBy){
		
		switch(sortTweetsBy){
		
		case DATE_NEW_TO_OLD:
			
			Collections.sort(this.queryResult, Comparators.DATE_NEW_TO_OLD);
			
			break;
		case DATE_OLD_TO_NEW:
			
			Collections.sort(this.queryResult, Comparators.DATE_OLD_TO_NEW);
			
			break;
		case NAME_A_TO_Z:
			
			Collections.sort(this.queryResult, Comparators.NAME_A_TO_Z);
			
			break;	
		case NAME_Z_TO_A:
			
			Collections.sort(this.queryResult, Comparators.NAME_Z_TO_A);
		
		
		}
	}
	
	
	public int getLimit() {
		return limit;
	}

	public int getRemaining() {
		return remaining;
	}
		
}
