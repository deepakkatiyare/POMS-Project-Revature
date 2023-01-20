package com.revature.poms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.poms.config.DatabaseConnection;
import com.revature.poms.constant.Constant;
import com.revature.poms.dao.RegisterPage;

public class RegisterPageImpl implements RegisterPage {
	
	private static Connection conn = DatabaseConnection.getConnection();
	Scanner sc= new Scanner(System.in);
	int s;
	public boolean registrationAndLogin()
	{
		boolean check = false;
		System.out.println(Constant.WELCOME_ADMIN);	
		System.out.println(Constant.PRESS_1_TO_REGISTER);
		System.out.println(Constant.PRESS_2_FOR_LOGIN);
		s=Integer.parseInt(sc.nextLine());
		switch(s)
		{
		case 1: 
			System.out.println(Constant.ADMIN_REGISTRATION_PAGE);
			System.out.println(Constant.ENTER_NAME);
			String	Name=sc.nextLine();
			System.out.println(Constant.ENTER_EMAIL);
			String	email=sc.nextLine();
			System.out.println(Constant.ENTER_PHONE_NO);
			int mobile=Integer.parseInt(sc.nextLine());
			System.out.println(Constant.ENTER_DATE_OF_BIRTH);
			String dob=sc.nextLine();
			System.out.println(Constant.ENTER_PASSWORD);
			String psw=sc.nextLine();
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(Constant.INSERT_INTO_ADMIN_VALUES);
				ps.setString(1, Name);
				ps.setString(2, email);
				ps.setInt(3, mobile);
				ps.setString(4, dob);
				ps.setString(5, psw);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Constant.REGISTERED_SUCESSFULLY);
			return registrationAndLogin();
		case 2: 
			System.out.println(Constant.ENTER_NAME);
			String name=sc.nextLine();
			System.out.println(Constant.ENTER_PASSWORD);
			String p=sc.nextLine();
			Statement s=null;
			ResultSet rs= null;
			try {
				s=conn.createStatement();
				rs=s.executeQuery(Constant.SELECT_ALL_ADMIN);
				while(rs.next())
				{
					
					if(rs.getString(1).equals(name)&& rs.getString(5).equals(p)) {
						check = true;
					}
				}
				if(!check)
					System.out.println(Constant.LOGIN_UNSUCCESSFUL);
				else
					System.out.println(Constant.LOGIN_SUCCESSFUL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
			default:{
			System.out.println(Constant.WRONG_ENTRY);
			return registrationAndLogin();	
			}
		}
	}
}
