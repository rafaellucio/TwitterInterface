package app;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import app.TwitterQueries.*;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEnd.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class FrontEnd {

	static TwitterQueries tq;

	public static void main(String[] args) {
		
		tq = new TwitterQueries();
		
		/* Noma da Hashtag da pesquisa, data definida para uma semana atrás   */
		tq.getTweets("java8", LocalDate.now().minusWeeks(1));
		
		/* Mostra estado do servidor Twitter que permite uma quantidade limitada de Queries a cada 15 minutos   */
		System.out.println("Resultados retornados do servidor Twitter: " + tq.getQueryResult().size());
		System.out.printf("Pesquisas feitas: %d (máximo: %d) %n%n%n",
					tq.getLimit() - tq.getRemaining(),
					tq.getLimit()
					);
		
		
		/* Inicia um menu de comando via console para manipular opções do API  */
		commandMenu();		
		}

	public static void commandMenu(){
				
		printHelp();
		
		boolean exit = true;
		do {
			System.out.print("digite comando > ");
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
			case "sortdateup":
				tq.sortTweets(SortTweetsBy.DATE_NEW_TO_OLD);
				break;
			case "sortdatedown":
				tq.sortTweets(SortTweetsBy.DATE_OLD_TO_NEW);
				break;
			case "sortnameup":
				tq.sortTweets(SortTweetsBy.NAME_A_TO_Z);
				break;
			case "sortnamedown":
				tq.sortTweets(SortTweetsBy.NAME_Z_TO_A);
				break;
			case "help":
				printHelp();
				break;
			case "sair":
				exit = false;
				keyboard.close();
			}
		} while (exit);
		
	}
	
	
	public static void printHelp(){
		
		
		System.out.println("");
		System.out.printf("Digite:%n"
						+ "         help - mostra está ajuda%n"
						+ "          all - mostra todos tweets da pesquisa%n"
						+ "      retweet - filtra e mostra somente os que foram retweet%n"
						+ "   favorited  - filtra e mostra somente os tweets que foram favoritados%n"
						+ "    retweeted - filtra e mostra somente os que foram retweeted%n"
						+ "retweetedbyme - filtra e mostra os que foram retweeted por mim%n"
						+ "%n"
						+ "   sortdateup - ordena por datas crescentes%n"
						+ " sortdatedown - ordena por datas decrescentes%n"
						+ "   sortnameup - ordena por nomes crescentes%n"
						+ " sortnamedown - ordena por nomes decrescentes%n"
						+ "         sair - Sair do sistema%n%n");
		
	}
	
	public static void printQuery(List<Tweet> queryResult){
		
		System.out.printf("%n%n%n=============================================================%n%n%n");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy - hh:mm");
		
		for (Tweet t : queryResult) {
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
