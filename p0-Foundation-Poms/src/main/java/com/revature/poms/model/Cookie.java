package com.revature.poms.model;

public class Cookie {
	
		String cookieName;
		int cookiePrice;
		
		public Cookie()
		{
			super();
		}
		public Cookie(int cookieId, String cookieName, int cookiePrice) {
			super();
			this.cookieName = cookieName;
			this.cookiePrice = cookiePrice;
		}
		
		public String getCookieName() {
			return cookieName;
		}
		public void setCookieName(String cookieName) {
			this.cookieName = cookieName;
		}
		public int getCookiePrice() {
			return cookiePrice;
		}
		public void setCookiePrice(int cookiePrice) {
			this.cookiePrice = cookiePrice;
		}
		@Override
		public String toString() {
			return "Cookie [cookieName=" + cookieName + ", cookiePrice=" + cookiePrice + "]";
		}
		
}
