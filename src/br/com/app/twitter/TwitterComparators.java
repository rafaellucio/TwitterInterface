/**
 * 
 */
package br.com.app.twitter;

import java.util.Comparator;

/**
 * 20160519-AtividadeFinal-Twitter / Comparators.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class TwitterComparators {
	
	public static Comparator<Twitter> NAME_A_TO_Z = new Comparator<Twitter>() {
		
		@Override
		public int compare(Twitter o1, Twitter o2) {
			return o1.getScreenName().compareTo(o2.getScreenName());
		}
	};
	
	public static Comparator<Twitter> NAME_Z_TO_A = new Comparator<Twitter>() {
		
		@Override
		public int compare(Twitter o1, Twitter o2) {
			
			return (-1) * o1.getScreenName().compareTo(o2.getScreenName());
		}
	};
	
	public static Comparator<Twitter> DATE_NEW_TO_OLD = new Comparator<Twitter>() {
		
		@Override
		public int compare(Twitter o1, Twitter o2) {
			
			return o1.getCreatedAt().compareTo(o2.getCreatedAt());
		}
	};
	
	public static Comparator<Twitter> DATE_OLD_TO_NEW = new Comparator<Twitter>() {
		
		@Override
		public int compare(Twitter o1, Twitter o2) {
			return (-1) * o1.getCreatedAt().compareTo(o2.getCreatedAt());
		}
	};
}
