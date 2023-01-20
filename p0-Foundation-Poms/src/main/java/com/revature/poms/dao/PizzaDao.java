package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.model.Pizza;

public interface PizzaDao {
	public void insertPizzaDetails(Pizza pizza) throws SQLException;
	public void updatePizzaDetails(int id, Scanner input) throws SQLException;
	public void getPizzaDetails() throws SQLException;
	public void deletePizzaDetails(int id) throws SQLException;
}
