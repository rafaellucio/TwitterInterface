package app;

/**
 * 20160519-AtividadeFinal-Twitter / FrontEnd.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class FrontEnd {
	
	static TwitterQueries fe;
	
	
	public static void main(String[] args) {
		
		fe = new TwitterQueries();
		
//		fe.getTimelineTweets();
		
		fe.getLastWeekTweets("SegaSaturn");
		
		System.out.println("Resultados retornados: " + fe.getQueryResult().size());
		System.out.printf("Pesquisas feitas: %d (máximo: %d) %n%n%n: ", fe.getLimit() - fe.getRemaining(), fe.getLimit());
		
		for (Tweet t : fe.getQueryResult()) {
			System.out.printf("@%s > %s > %s %n",
					t.getCreatedAt(),
					t.getScreenName(),
					t.getBodyText());
					
			System.out.printf("F: %b, R: %b, Rd: %b, RbyMe: %b %n%n%n",
					t.isFavorited(),
					t.isRetweet(),
					t.isRetweeted(),
					t.isRetweetedByMe()
					);
						
		}
	}
}
