package app;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import app.TwitterQueries.TweetType;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEnd.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class FrontEnd {

	static TwitterQueries tq;

	public static void main(String[] args) {
		
	
		tq = new TwitterQueries();
		
		
		tq.getTweets("Dilma", LocalDate.now().minusWeeks(1));

		System.out.println("Resultados retornados: " + tq.getQueryResult().size());
		System.out.printf("Pesquisas feitas: %d (máximo: %d) %n%n%n: ",
					tq.getLimit() - tq.getRemaining(),
					tq.getLimit()
					);
	
		
		commandMenu();

		}
	
	
	
	public static void commandMenu(){
		
		boolean exit = true;
		do {
			System.out.println("");
			System.out.println("Digite: all, retweet, retweeted, favorited, retweetedbyme ou sair");
			System.out.print("command > ");
			Scanner keyboard = new Scanner(System.in);
			switch(keyboard.nextLine()){
			case "all":
				printQuery(tq.getQueryResult(TweetType.ALL));
				break;
			case "retweet":
				printQuery(tq.getQueryResult(TweetType.RETWEET));
				break;
			case "retweeted":
				printQuery(tq.getQueryResult(TweetType.RETWEETED));
				break;
			case "favorited":
				printQuery(tq.getQueryResult(TweetType.FAVORITED));
				break;
			case "retweetedbyme":
				printQuery(tq.getQueryResult(TweetType.RETWEETEDBYME));
				break;
			case "sair":
				exit = false;
			}
		} while (exit);
		
	}
	

	public static void printQuery(List<Tweet> queryResult){

		for (Tweet t : queryResult) {
			System.out.printf("@%s > %s > %s %n",
					t.getScreenName(),
					t.getCreatedAt(),
					t.getBodyText()
					);

			System.out.printf("F: %b, R: %b, Rd: %b, RbyMe: %b %n%n%n",
					t.isFavorited(),
					t.isRetweet(),
					t.isRetweeted(),
					t.isRetweetedByMe()
					);	
		}
	}
}
