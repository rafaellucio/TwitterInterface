package br.com.app.utils;

import java.util.Scanner;

import br.com.app.twitter.TwitterQueries;
import br.com.app.twitter.TwitterSortBy;
import br.com.app.twitter.TwitterType;

public class CommandMenu {
	
	public static void commandMenu(TwitterQueries tq){
		
		printHelp();
		
		boolean exit = true;
		do {
			System.out.print("digite comando > ");
			Scanner keyboard = new Scanner(System.in);
			switch(keyboard.nextLine()){
			case "all":
				PrintQueryTwitterResult.printQuery(tq.getQueryResult(TwitterType.ALL));
				break;
			case "retweet":
				PrintQueryTwitterResult.printQuery(tq.getQueryResult(TwitterType.RETWEET));
				break;
			case "retweeted":
				PrintQueryTwitterResult.printQuery(tq.getQueryResult(TwitterType.RETWEETED));
				break;
			case "favorited":
				PrintQueryTwitterResult.printQuery(tq.getQueryResult(TwitterType.FAVORITED));
				break;
			case "retweetedbyme":
				PrintQueryTwitterResult.printQuery(tq.getQueryResult(TwitterType.RETWEETEDBYME));
				break;
			case "sortdateup":
				tq.sortTweets(TwitterSortBy.DATE_NEW_TO_OLD);
				break;
			case "sortdatedown":
				tq.sortTweets(TwitterSortBy.DATE_OLD_TO_NEW);
				break;
			case "sortnameup":
				tq.sortTweets(TwitterSortBy.NAME_A_TO_Z);
				break;
			case "sortnamedown":
				tq.sortTweets(TwitterSortBy.NAME_Z_TO_A);
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
}
