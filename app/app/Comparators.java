/**
 * 
 */
package app;

import java.util.Comparator;

/**
 * 20160519-AtividadeFinal-Twitter / Comparators.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Comparators {
	
	public static Comparator<Tweet> NAME_A_TO_Z = new Comparator<Tweet>() {
		
		@Override
		public int compare(Tweet o1, Tweet o2) {
			return o1.getScreenName().compareTo(o2.getScreenName());
		}
	};
	
	public static Comparator<Tweet> NAME_Z_TO_A = new Comparator<Tweet>() {
		
		@Override
		public int compare(Tweet o1, Tweet o2) {
			
			return (-1) * o1.getScreenName().compareTo(o2.getScreenName());
		}
	};
	
	public static Comparator<Tweet> DATE_NEW_TO_OLD = new Comparator<Tweet>() {
		
		@Override
		public int compare(Tweet o1, Tweet o2) {
			
			return o1.getCreatedAt().compareTo(o2.getCreatedAt());
			
		}
	};
	
	public static Comparator<Tweet> DATE_OLD_TO_NEW = new Comparator<Tweet>() {
		
		@Override
		public int compare(Tweet o1, Tweet o2) {
			return (-1) * o1.getCreatedAt().compareTo(o2.getCreatedAt());
		}
	};
	

}
