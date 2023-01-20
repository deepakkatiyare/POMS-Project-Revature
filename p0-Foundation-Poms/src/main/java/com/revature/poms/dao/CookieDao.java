package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.model.Cookie;

public interface CookieDao {
	public void insertCookieDetails(Cookie cookie) throws SQLException;
	public void updateCookieDetails(int id, Scanner input) throws SQLException;
	public void getCookieDetails() throws SQLException;
	public void deleteCookieDetails(int id) throws SQLException;
}
