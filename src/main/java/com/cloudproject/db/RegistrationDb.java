package com.cloudproject.db;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class RegistrationDb {
	static Connection connection = null;	
	public static boolean regiser(String userId,String username, String password) {
		try {
			connection = ConnectionDb.getConnection();
			String sql = "INSERT INTO user_details (user_id, user_name, user_password)\n" + 
					"VALUES (?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			int i = preparedStatement.executeUpdate();
			return i>0;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
