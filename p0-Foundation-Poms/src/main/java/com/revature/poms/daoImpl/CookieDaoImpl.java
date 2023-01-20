package com.revature.poms.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.model.Cookie;

public class CookieDaoImpl {
	
	private static final Logger log = Logger.getLogger(CookieDaoImpl.class);
	
	private static Connection conn=DatabaseConnection.getConnection();
	
	public void insertCookieDetails(Cookie cookie) {
		PreparedStatement ps;
		
		try {
			ps=conn.prepareStatement(Constant.INSERT_COOKIE);
			ps.setString(1,cookie.getCookieName());
			ps.setInt(2, cookie.getCookiePrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(Constant.INSERTION_SUCESSFULL);
	}
	public void updateCookieDetails(int id,Scanner input) {
		String query;
		if (checkCookieId(id)) {
			PreparedStatement preparedStmt = null;
			log.info(Constant.PRESS_1_UPDATE_COOKIE_NAME);
			log.info(Constant.PRESS_2_UPDATE_COOKIE_PRICE);
			int value = Integer.parseInt(input.nextLine());
			switch (value) {	
			case 1:
				log.info(Constant.ENTER_COOKIE_NAME);
				String newInput = input.nextLine();
				query = Constant.UPDATE_COOKIE_NAME;
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
				log.info(Constant.ENTER_COOKIE_PRICE);
				query = Constant.UPDATE_COOKIE_PRICE;
				int x  = Integer.parseInt(input.nextLine());
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
		} else {
			log.info(Constant.COOKIE_ID_DOESNT_EXIST);
		}
	}
	
	public void deleteCookieDetails(int id) {
		if(checkCookieId(id)) {
			try {
				String query = Constant.DELETE_COOKIE_WHERE_COOKIE_ID;
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
			}catch (SQLException e) {
			e.printStackTrace();	
			}
		}
		else {
			log.info(Constant.COOKIE_ID_DOESNT_EXIST);
		}
	}
	
	public void getCookieDetails() {
		Statement s=null; 
		ResultSet rs=null;
		try {
			s=conn.createStatement();
			rs=s.executeQuery(Constant.SELECT_ALL_COOKIE);
			while(rs.next())
			{
				log.info(rs.getInt(1)+"-----"+rs.getString(2)+"-----"+rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
	private boolean checkCookieId(int id) {
		String query = Constant.SELECT_COOKIE_WHERE_COOKIE_ID;
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
