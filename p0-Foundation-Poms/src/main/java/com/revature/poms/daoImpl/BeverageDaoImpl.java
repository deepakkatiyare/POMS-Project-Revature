package com.revature.poms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.poms.app.Application;
import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.BeverageDao;
import com.revature.poms.model.Beverage;

public class BeverageDaoImpl implements BeverageDao {

	private static Connection conn = DatabaseConnection.getConnection();
	private static final Logger log = Logger.getLogger(BeverageDaoImpl.class);

	public void insertBeverageDetails(Beverage beverage) throws SQLException {

		PreparedStatement ps;
		ps = conn.prepareStatement(Constant.INSERT_INTO_BEVERAGE_QUERY);
		ps.setString(1, beverage.getBeveragename());
		ps.setString(2, beverage.getBeverageType().toString());
		ps.setInt(3, beverage.getBeverageprice());
		ps.executeUpdate();
		log.info(Constant.DETAILS_INSERTED);

	}

	public void updateBeverageDetails(int id, Scanner input) throws SQLException {
		String query;
		if (checkBeverageId(id)) {
			PreparedStatement preparedStmt = null;
			log.info(Constant.PRESS_1_UPDATE_BEVERAGE_NAME);
			log.info(Constant.PRESS_2_UPDATE_BEVERAGE_TYPE);
			log.info(Constant.PRESS_3_UPDATE_BEVERAGE_PRICE);
			int value = Integer.parseInt(input.nextLine());
			switch (value) {
			case 1:
				log.info(Constant.ENTER_BEVERAGE_NAME);
				String newInput = input.nextLine();
				query = Constant.UPDATE_BEVERAGE_NAME;
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, newInput);
				preparedStmt.setInt(2, id);
				preparedStmt.executeUpdate();
				log.info(Constant.UPDATED_SUCCESSFULLY);
				break;
			case 2:
				log.info(Constant.ENTER_BEVERAGE_TYPE);
				newInput = input.nextLine().toUpperCase();
				query = Constant.UPDATE_BEVERAGE_TYPE;
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, newInput);
				preparedStmt.setInt(2, id);
				preparedStmt.executeUpdate();
				log.info(Constant.UPDATED_SUCCESSFULLY);
				break;
			case 3:
				log.info(Constant.ENTER_BEVERAGE_PRICE);
				query = Constant.UPDATE_BEVERAGE_PRICE;
				int x = Integer.parseInt(input.nextLine());
				preparedStmt = conn.prepareStatement(query);
				preparedStmt.setInt(1, x);
				preparedStmt.setInt(2, id);
				preparedStmt.executeUpdate();

				log.info(Constant.UPDATED_SUCCESSFULLY);
				break;
			default:
				log.info(Constant.INCORRECT_VALUE);
				break;
			}
		} else {
			log.info(Constant.BEVERAGE_ID_DOES_NOT_EXIST);
		}

	}

	public void deleteBeverageDetails(int id) throws SQLException {
		if (checkBeverageId(id)) {
			String query = Constant.DELETE_BEVERAGE;
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} else {
			log.info(Constant.BEVERAGE_ID_DOES_NOT_EXIST);
		}
	}

	public void getBeverageDetails() throws SQLException {
		Statement s = null;
		ResultSet rs = null;
		s = conn.createStatement();
		rs = s.executeQuery(Constant.SELECT_ALL_BEVERAGE);
		while (rs.next()) {
			log.info(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getString(3) + "--" + rs.getInt(4));
		}
	}

	private boolean checkBeverageId(int id) {
		String query = Constant.SELECT_FROM_BEVERAGE_USING_B_ID;
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
}
