/**
 * 
 */
package app;

import java.util.Date;

/**
 * 20160519-AtividadeFinal-Twitter / Tweet.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Tweet {
	
	private Date createdAt;
	private String screenName;
	private String bodyText;
	
	private boolean retweet;
	private boolean Retweeted;
	private boolean RetweetedByMe;
	private boolean Favorited;
	
	public Tweet(Date createdAt, String screenName, String bodyText, boolean retweet, boolean retweeted,
			boolean retweetedByMe, boolean favorited) {
		super();
		this.createdAt = createdAt;
		this.screenName = screenName;
		this.bodyText = bodyText;
		this.retweet = retweet;
		Retweeted = retweeted;
		RetweetedByMe = retweetedByMe;
		Favorited = favorited;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getScreenName() {
		return screenName;
	}

	public String getBodyText() {
		return bodyText;
	}

	public boolean isRetweet() {
		return retweet;
	}

	public boolean isRetweeted() {
		return Retweeted;
	}

	public boolean isRetweetedByMe() {
		return RetweetedByMe;
	}

	public boolean isFavorited() {
		return Favorited;
	}
}
