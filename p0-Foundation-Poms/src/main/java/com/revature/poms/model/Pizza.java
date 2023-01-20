package com.revature.poms.model;

public class Pizza {

	private String pizzaType;
	 private PizzaSize pizzaSize;
	 private String pizzaCategory;
	 private int pizzaPrice;
	 
	 public Pizza()
	 {
		 super();
	 }
	 
	public Pizza(String pizzaType, PizzaSize pizzaSize, String pizzaCategory, int pizzaPrice) {
		super();
		this.pizzaType = pizzaType;
		this.pizzaSize = pizzaSize;
		this.pizzaCategory = pizzaCategory;
		this.pizzaPrice = pizzaPrice;
	}



	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public PizzaSize getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public String getPizzaCategory() {
		return pizzaCategory;
	}

	public void setPizzaCategory(String pizzaCategory) {
		this.pizzaCategory = pizzaCategory;
	}

	public int getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(int pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaType=" + pizzaType + ", pizzaSize=" + pizzaSize
				+ ", pizzaCategory=" + pizzaCategory + ", pizzaPrice=" + pizzaPrice + "]";
	}
	 
}