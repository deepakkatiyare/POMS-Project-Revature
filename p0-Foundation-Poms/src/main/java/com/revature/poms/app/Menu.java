package com.revature.poms.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.daoImpl.BeverageDaoImpl;
import com.revature.poms.daoImpl.CookieDaoImpl;
import com.revature.poms.daoImpl.PizzaDaoImpl;
import com.revature.poms.model.Beverage;
import com.revature.poms.model.BeverageType;
import com.revature.poms.model.Cookie;
import com.revature.poms.model.Pizza;
import com.revature.poms.model.PizzaSize;

public class Menu {
	private static final Logger log = Logger.getLogger(Menu.class);

	private static void showMenu() {
		log.info(Constant.PIZZA_OPERATION);
		log.info(Constant.BEVERAGE_OPERATION);
		log.info(Constant.COOKIE_OPERATION);
	}

	public static void pizzaMenu() {
		log.info(Constant.PIZZA_MENU);
		log.info(Constant.INSERT_PIZZA_DETAILS);
		log.info(Constant.UPDATE_PIZZA_DETAILS);
		log.info(Constant.DELETE_PIZZA_DETAILS);
		log.info(Constant.SELECT_PIZZA_DETAILS);
		log.info(Constant.PIZZA_EXIT);
	}

	public static void beverageMenu() {
		log.info(Constant.BEVERAGE_MENU);
		log.info(Constant.INSERT_BEVERAGES_DETAILS);
		log.info(Constant.UPDATE_BEVERAGES_DETAILS);
		log.info(Constant.DELETE_BEVERAGES_DETAILS);
		log.info(Constant.SELECT_BEVERAGES_DETAILS);
		log.info(Constant.BEVERAGE_EXIT);

	}

	public static void cookieMenu() {
		log.info(Constant.COOKIE_MENU);
		log.info(Constant.INSERT_COOKIE_DETAILS);
		log.info(Constant.UPDATE_COOKIE_DETAILS);
		log.info(Constant.DELETE_COOKIE_DETAILS);
		log.info(Constant.SELECT_COOKIE_DETAILS);
		log.info(Constant.COOKIE_EXIT);

	}

	public static void itemMenu(Scanner input) {
		int condition = 1;
		showMenu();
		try {
			int value = Integer.parseInt(input.nextLine());
			if (value == 1) {
				do {
					pizzaMenu(input);
					log.info(Constant.TO_CONTINUE_1);
					condition = Integer.parseInt(input.nextLine());
				} while (condition == 1);

			} else if (value == 2) {
				do {
					beverageMenu(input);
					log.info(Constant.TO_CONTINUE_1);
					condition = Integer.parseInt(input.nextLine());
				} while (condition == 1);

			} else if (value == 3) {
				do {
					cookieMenu(input);
					log.info(Constant.TO_CONTINUE_1);
					condition = Integer.parseInt(input.nextLine());
				} while (condition == 1);
			} else {
				log.info(Constant.OUT_OF_RANGE + value);
				itemMenu(input);
			}
		} catch (NumberFormatException e) {
			System.out.println(Constant.WRONG_FORMAT);
		}
		itemMenu(input);
	}

	public static void cookieMenu(Scanner input) {
		int value;
		CookieDaoImpl service = new CookieDaoImpl();
		Menu.cookieMenu();
		value = Integer.parseInt(input.nextLine());
		switch (value) {
		case 1:
			addCookieDetails(input, service);
			break;
		case 2:
			log.info(Constant.CHOOSE_ID_TO_UPDATED);
			service.getCookieDetails();
			log.info(Constant.BEVERAGE_ID);
			service.updateCookieDetails(Integer.parseInt(input.nextLine()), input);
			break;
		case 3:
			String query = Constant.SELECT_COUNT_COOKIE;
			PreparedStatement statement = null;
			ResultSet rs = null;
			Connection conn = null;
			try {
				conn = DatabaseConnection.getConnection();
				statement = conn.prepareStatement(query);
				rs = statement.executeQuery();
				rs.next();
				if (rs.getInt(1) == 0)
					log.info(Constant.NO_DATA);
				else {
					log.info(Constant.CHOOSE_ID_TO_BE_DELETED);
					service.getCookieDetails();
					log.info(Constant.GET_COOKIE_ID);
					service.deleteCookieDetails(Integer.parseInt(input.nextLine()));
					log.info(Constant.DELETED_SUCESSFULLY);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			service.getCookieDetails();
			break;
		case 5:
			itemMenu(input);
			break;
		default:
			log.info(Constant.VALUE_IS_INCORRECT + value);
			cookieMenu(input);
		}
	}

	private static void addCookieDetails(Scanner input, CookieDaoImpl service) {
		Cookie cookie = new Cookie();
		log.info(Constant.ENTER_COOKIE_NAME);
		cookie.setCookieName(input.nextLine());
		log.info(Constant.ENTER_COOKIE_PRICE);
		cookie.setCookiePrice(Integer.parseInt(input.nextLine()));
		service.insertCookieDetails(cookie);
	}

	public static void beverageMenu(Scanner input) {
		int value;
		BeverageDaoImpl service = new BeverageDaoImpl();
		Menu.beverageMenu();
		value = Integer.parseInt(input.nextLine());
		switch (value) {
		case 1:
			addBeverageDetails(input, service);
			break;
		case 2:
			log.info(Constant.CHOOSE_ID_TO_UPDATED);
			try {
				service.getBeverageDetails();
				log.info(Constant.BEVERAGE_ID);
				service.updateBeverageDetails(Integer.parseInt(input.nextLine()), input);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			String query = Constant.SELECT_COUNT_BEVERAGE;
			PreparedStatement statement = null;
			ResultSet rs = null;
			Connection conn = null;
			try {
				conn = DatabaseConnection.getConnection();
				statement = conn.prepareStatement(query);
				rs = statement.executeQuery();
				rs.next();
				if (rs.getInt(1) == 0)
					log.info(Constant.NO_DATA);
				else {
					log.info(Constant.CHOOSE_ID_TO_BE_DELETED);
					service.getBeverageDetails();
					log.info(Constant.GET_BEVERAGE_ID);
					service.deleteBeverageDetails(Integer.parseInt(input.nextLine()));
					log.info(Constant.DELETED_SUCESSFULLY);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				service.getBeverageDetails();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			itemMenu(input);
			break;
		default:
			log.info(Constant.VALUE_IS_INCORRECT + value);
			beverageMenu(input);
		}
	}

	private static void addBeverageDetails(Scanner input, BeverageDaoImpl service) {
		Beverage beverage = new Beverage();
		log.info(Constant.BEVERAGE_NAME);
		beverage.setBeveragename(input.nextLine());
		log.info(Constant.BEVERAGE_TYPE);
		beverage.setBeverageType(BeverageType.valueOf(input.nextLine().toUpperCase()));
		log.info(Constant.BEVERAGE_PRICE);
		beverage.setBeverageprice(Integer.parseInt(input.nextLine()));
		try {
			service.insertBeverageDetails(beverage);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void pizzaMenu(Scanner input) {
		int value;
		PizzaDaoImpl service = new PizzaDaoImpl();
		Menu.pizzaMenu();
		value = Integer.parseInt(input.nextLine());
		switch (value) {
		case 1:
			addPizzaDetails(input, service);
			break;
		case 2:
			log.info(Constant.CHOOSE_ID_TO_UPDATED);
			try {
				service.getPizzaDetails();
				log.info(Constant.PIZZA_ID);
				service.getPizzaDetails();
				log.info(Constant.PIZZA_ID);
				service.updatePizzaDetails(Integer.parseInt(input.nextLine()), input);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			String query = Constant.COUNT_PIZZA;
			PreparedStatement statement = null;
			ResultSet rs = null;
			Connection conn = null;
			try {
				conn = DatabaseConnection.getConnection();
				statement = conn.prepareStatement(query);
				rs = statement.executeQuery();
				rs.next();
				if (rs.getInt(1) == 0)
					log.info(Constant.NO_DATA);
				else {
					log.info(Constant.CHOOSE_ID_TO_UPDATED);
					service.getPizzaDetails();
					log.info(Constant.GET_PIZZA_ID);
					service.deletePizzaDetails(Integer.parseInt(input.nextLine()));
					log.info(Constant.DELETED_SUCESSFULLY);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			break;
		case 4:
			try {
				service.getPizzaDetails();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			itemMenu(input);
			break;
		default:
			log.info(Constant.VALUE_IS_INCORRECT + value);
			pizzaMenu(input);
		}
	}

	private static void addPizzaDetails(Scanner input, PizzaDaoImpl service) {
		Pizza pizza = new Pizza();
		log.info(Constant.PIZZA_CATEGORY);
		pizza.setPizzaCategory(input.nextLine());
		log.info(Constant.PIZZA_PRICE);
		pizza.setPizzaPrice(Integer.parseInt(input.nextLine()));
		log.info(Constant.PIZZA_NAME);
		pizza.setPizzaType(input.nextLine());
		log.info(Constant.PIZZA_SIZE);
		pizza.setPizzaSize(PizzaSize.valueOf(input.nextLine().toUpperCase()));
		try {
			service.insertPizzaDetails(pizza);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
