package com.revature.poms.daoImpl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.PizzaDao;
import com.revature.poms.model.Pizza;

public class PizzaDaoImpl implements PizzaDao {

	private static final Logger log = Logger.getLogger(PizzaDaoImpl.class);
	private static Connection conn = DatabaseConnection.getConnection();
	public void insertPizzaDetails(Pizza pizza) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(Constant.INSERT_INTO_PIZZA_VALUES);
		preparedStatement.setString(1, pizza.getPizzaType());
		preparedStatement.setString(2, pizza.getPizzaSize().toString());
		preparedStatement.setString(3, pizza.getPizzaCategory());
		preparedStatement.setInt(4, pizza.getPizzaPrice());
		preparedStatement.executeUpdate();
		log.info(Constant.INSERTED_SUCCESSFULLY);
	}

	public void updatePizzaDetails(int id, Scanner input) throws SQLException {
		String query;
		try {
			if (checkPizzaId(id)) {
				PreparedStatement preparedStmt = null;
				log.info(Constant.PRESS_1_UPDATE_PIZZA_NAME);
				log.info(Constant.PRESS_2_UPDATE_PIZZA_SIZE);
				log.info(Constant.PRESS_3_UPDATE_PIZZA_CATEGORY);
				log.info(Constant.PRESS_4_UPDATE_PIZZA_PRICE);
				int value = Integer.parseInt(input.nextLine());
				switch (value) {
				case 1:

					log.info(Constant.ENTER_PIZZA_NAME);
					String newInput = input.nextLine();
					query = Constant.UPDATE_PIZZA_TYPE;
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					log.info(Constant.UPDATED_SUCCESSFULLY);
					break;
				case 2:
					log.info(Constant.ENTER_PIZZA_SIZE);
					newInput = input.nextLine().toUpperCase();
					query = Constant.UPDATE_PIZZA_SIZE_;
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();

					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info(Constant.UPDATED_SUCCESSFULLY);
					break;
				case 3:
					log.info(Constant.ENTER_CATEGORY);
					newInput = input.nextLine();
					query = Constant.UPDATE_PIZZA_CATEGORY;
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setString(1, newInput);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info(Constant.UPDATED_SUCCESSFULLY);
					break;
				case 4:
					log.info(Constant.ENTER_PIZZA_PRICE);
					int x = Integer.parseInt(input.nextLine());
					query = Constant.UPDATE_PIZZA_PRICE;
					try {
						preparedStmt = conn.prepareStatement(query);
						preparedStmt.setInt(1, x);
						preparedStmt.setInt(2, id);
						preparedStmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					log.info(Constant.UPDATED_SUCCESSFULLY);
					break;
				default:
					log.info(Constant.INCORRECT_VALUE);
					break;
				}
				preparedStmt.close();
			} else {
				log.info(Constant.PIZZA_ID_DOES_NOT_EXIST);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private boolean checkPizzaId(int id) {
		String query = Constant.SELECT_PARTICULAR_PIZZA;
		PreparedStatement preparedStatement = null;
		ResultSet check = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			check = preparedStatement.executeQuery();
			return check.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deletePizzaDetails(int id) throws SQLException{
		if (checkPizzaId(id)) {
				String query = Constant.DELETE_FROM_PIZZA;
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
			} 
			else {
			log.info(Constant.PIZZA_ID_DOES_NOT_EXIST);
		}
	}

	public void getPizzaDetails() throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Constant.SELECT_ALL_PIZZA);
			while (rs.next()) {
				System.out.format("%5s %25s %25s %25s %25s", rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5));
				System.out.println();
			}
	}

}
