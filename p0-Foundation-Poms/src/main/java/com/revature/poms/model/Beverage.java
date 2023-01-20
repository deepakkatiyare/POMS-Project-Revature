package com.revature.poms.model;


public class Beverage {

	private int beverageid;
	private String beveragename;
	private BeverageType beverageType;
	private int beverageprice;
	public Beverage()
	 {
		 super();
	 }
	public Beverage(String beveragename, BeverageType beverageType, int beverageprice) {
		super();
		this.beveragename = beveragename;
		this.beverageType = beverageType;
		this.beverageprice = beverageprice;
		
	}
	public String getBeveragename() {
		return beveragename;
	}
	public void setBeveragename(String beveragename) {
		this.beveragename = beveragename;
	}
	public BeverageType getBeverageType() {
		return beverageType;
	}
	public void setBeverageType(BeverageType beverageType) {
		this.beverageType = beverageType;
	}
	public int getBeverageprice() {
		return beverageprice;
	}
	public void setBeverageprice(int beverageprice) {
		this.beverageprice = beverageprice;
	}
	@Override
	public String toString() {
		return "Beverage [beveragename=" + beveragename + ", beverageType="
				+ beverageType + ", beverageprice=" + beverageprice + "]";
	}
	
	
}
