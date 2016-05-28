package app.twitter;

import java.util.Date;

/**
 * 20160519-AtividadeFinal-Twitter / Tweet.java
 * FIAP / RM30222 - Vagner Panarello
 * FIAP / RM30318 - Rafael Antonio Lucio
 */
public class Twitter implements Comparable<Twitter> {
	
	private Date createdAt;
	private String screenName;
	private String bodyText;
	private String userName;
	
	private boolean retweet;
	private boolean retweeted;
	private boolean retweetedByMe;
	private boolean favorited;
	
	public Twitter(Date createdAt, 
			String screenName, 
			String userName, 
			String bodyText, 
			boolean retweet, 
			boolean retweeted,
			boolean retweetedByMe, 
			boolean favorited) {
		super();
		this.createdAt = createdAt;
		this.screenName = screenName;
		this.userName = userName;
		this.bodyText = bodyText;
		this.retweet = retweet;
		this.retweeted = retweeted;
		this.retweetedByMe = retweetedByMe;
		this.favorited = favorited;
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
		return retweeted;
	}

	public boolean isRetweetedByMe() {
		return retweetedByMe;
	}

	public boolean isFavorited() {
		return favorited;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Twitter o) {
		
		return TwitterComparators.NAME_A_TO_Z.compare(this, o);

	}
}
