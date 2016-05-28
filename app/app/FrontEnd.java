package app;

import java.time.LocalDate;

import app.twitter.TwitterQueries;
import app.utils.CommandMenu;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEnd.java
 * FIAP / RM30222 - Vagner Panarello.
 * FIAP / RM30318 - Rafael Antonio Lucio
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
		CommandMenu.commandMenu(tq);		
	}
}