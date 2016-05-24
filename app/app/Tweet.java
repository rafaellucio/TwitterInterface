/**
 * 
 */
package app;

import java.util.Date;

/**
 * 20160519-AtividadeFinal-Twitter / Tweet.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Tweet implements Comparable<Tweet> {
	
	private Date createdAt;
	private String screenName;
	private String bodyText;
	private String userName;
	
	private boolean retweet;
	private boolean Retweeted;
	private boolean RetweetedByMe;
	private boolean Favorited;
	
	public Tweet(Date createdAt, String screenName, String userName, String bodyText, boolean retweet, boolean retweeted,
			boolean retweetedByMe, boolean favorited) {
		super();
		this.createdAt = createdAt;
		this.screenName = screenName;
		this.userName = userName;
		this.bodyText = bodyText;
		this.retweet = retweet;
		Retweeted = retweeted;
		RetweetedByMe = retweetedByMe;
		Favorited = favorited;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Tweet o) {
		
		return Comparators.NAME_A_TO_Z.compare(this, o);

	}
}
