/**
 * 
 */
package br.com.app.twitter;

/**
 * 20160519-AtividadeFinal-Twitter / TwetterAuth.java
 * FIAP / RM30222 - Vagner Panarello
 */
public enum TwitterAuth {
	
	/* Insert here your personal "Consumer Key (API Key)" from Twitter */
	API_KEY("FKSv1DWiDqoJYoWNqwWfbUazr"),
	/* Insert here your personal "Consumer Secret (API Secret)" from Twitter */
	API_SECRET("3Syknhy2Poa5xtQEWzT0PytrCgGMK59wHdTMBbIdV3JvzU7Ezw"),
	/* Insert here your personal "Access Token" from Twitter */
	ACCESS_TOKEN("250292496-RLoOlbfBDwnlbFFxpYFMfOS5bXHm2Gm0B1WCXeJg"),
	/* Insert here your personal "Access Token Secret" from Twitter */
	ACCESS_TOKEN_SECRET("jtQ0vppmQB5tDzkMYXSvILXrKg8LOBVM4i1pI28ha0a9a"),
	
	
	/* Insert here your name "Owner"  from Twitter */
	OWNER("RafaelKtbhs"),
	/* Insert here your "Owner ID" from Twitter */
	OWNER_ID("250292496");
	
	private String key;

	/**
	 * @param arg0
	 */
	private TwitterAuth(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
