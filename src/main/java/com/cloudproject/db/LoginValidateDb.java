package com.cloudproject.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginValidateDb {

	static Connection connection = null;	
	public static boolean validate(String userId, String password) {
		try {
			connection = ConnectionDb.getConnection();
			String sql = "select * from user_details where user_id = ? and user_password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet res = preparedStatement.executeQuery();
			return res.next();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
