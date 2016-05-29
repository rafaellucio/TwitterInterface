package br.com.app.twitter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEndFunctions.java
 * FIAP / RM30222 - Vagner Panarello
 * FIAP / RM30318 - Rafael Antonio Lucio
 */
public class TwitterQueries {
	
	private List<Twitter> queryResult;
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
         	
                	queryResult.add(new Twitter(
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
	
	public List<Twitter> getQueryResult() {
		return this.getQueryResult(TwitterType.ALL);
	}
	
	/* (non-Javadoc)
	 * @see app.Twitter#getQueryResult()
	 */
	public List<Twitter> getQueryResult(TwitterType tweetType) {
		
		List<Twitter> queryResult =  new ArrayList<>();		
		
		switch(tweetType){
		case FAVORITED:
			
			for (Twitter tweet : this.queryResult) {
				if(tweet.isFavorited()) queryResult.add(tweet);
			}
			break;
			
		case RETWEET:
			for (Twitter tweet : this.queryResult) {
				if(tweet.isRetweet()) queryResult.add(tweet);
			}
			break;
			
		case RETWEETED:
			for (Twitter tweet : this.queryResult) {
				if(tweet.isRetweeted()) queryResult.add(tweet);
			}
			break;
			
		case RETWEETEDBYME:
			for (Twitter tweet : this.queryResult) {
				if(tweet.isRetweetedByMe()) queryResult.add(tweet);
			}
			break;
			
		case ALL:
			for (Twitter tweet : this.queryResult) {
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
	
	public void sortTweets(TwitterSortBy sortTweetsBy){
		
		switch(sortTweetsBy){
		
		case DATE_NEW_TO_OLD:
			Collections.sort(this.queryResult, TwitterComparators.DATE_NEW_TO_OLD);
			break;
		case DATE_OLD_TO_NEW:
			Collections.sort(this.queryResult, TwitterComparators.DATE_OLD_TO_NEW);
			break;
		case NAME_A_TO_Z:
			Collections.sort(this.queryResult, TwitterComparators.NAME_A_TO_Z);
			break;	
		case NAME_Z_TO_A:
			Collections.sort(this.queryResult, TwitterComparators.NAME_Z_TO_A);
		}
	}
	
	public int getLimit() {
		return limit;
	}

	public int getRemaining() {
		return remaining;
	}		
}
