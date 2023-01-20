package com.revature.poms.dao;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.model.Beverage;

public interface BeverageDao {
	public void insertBeverageDetails(Beverage beverage) throws SQLException;
	public void updateBeverageDetails(int id, Scanner input) throws SQLException;
	public void getBeverageDetails() throws SQLException;
	public void deleteBeverageDetails(int id) throws SQLException;
}
