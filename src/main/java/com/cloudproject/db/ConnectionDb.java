package com.cloudproject.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.cloudproject.constants.Constants;

public class ConnectionDb {
	
	public  static final String CREDENTIALS_STRING = "jdbc:mysql://google/"+Constants.getDatabaseName()+"?cloudSqlInstance="+Constants.getInstanceConnectionName()+"&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user="+Constants.getMySQLUserName()+"&password="+Constants.getMySQLUserPassword();
	static Connection connection = null;
	
	public static Connection getConnection() {
		try {
			Class.forName(Constants.getDriverName());
			connection = DriverManager.getConnection(CREDENTIALS_STRING);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}	
}
