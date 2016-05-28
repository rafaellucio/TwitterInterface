package app.utils;

import java.text.SimpleDateFormat;
import java.util.List;

import app.twitter.Twitter;

public class PrintQueryTwitterResult {
	
	public static void printQuery(List<Twitter> queryResult) {
		System.out.printf("%n%n%n=============================================================%n%n%n");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy - hh:mm");
		
		for (Twitter t : queryResult) {
			System.out.printf("@%s | %s | %s |%n%s%n",
					t.getScreenName(),
					t.getUserName(),
					df.format(t.getCreatedAt()),
					t.getBodyText()
					);
			
			String status = "|";
			if(t.isFavorited()) status = status.concat(" Favorited |");
			if(t.isRetweet()) status = status.concat(" Retweet |");
			if(t.isRetweeted()) status = status.concat(" Retweeted |");
			if(t.isRetweetedByMe()) status = status.concat(" RetweetedByMe |");
			
			System.out.printf("%s%n%n%n",status);
		}

		System.out.printf("%n%nNúmero de Tweets: %d postagem(s)%n%n%n", queryResult.size());
	}
}
