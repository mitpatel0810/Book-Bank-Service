package com.cloudproject.constants;

public class Constants {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DATABASE_NAME = "bookbank_db";
	private static final String INSTANCE_CONNECTION_NAME = "bookbankservice-309415:us-central1:bookbankservicedb";
	private static final String MYSQL_USER_NAME = "root"; 
	private static final String MYSQL_USER_PASSWORD = "root"; 
	private static final String PROJECT_ID = "bookbankservice-309415";
	private static final String BUCKET_NAME = "bookbankbucket";
	
	
	public static String getProjectId() {
		return PROJECT_ID;
	}
	public static String getBucketName() {
		return BUCKET_NAME;
	}
	public static String getDriverName() {
		return DRIVER_NAME;
	}
	public static String getDatabaseName() {
		return DATABASE_NAME;
	}
	public static String getInstanceConnectionName(){
		return INSTANCE_CONNECTION_NAME;
	}
	public static String getMySQLUserName() {
		return MYSQL_USER_NAME;
	}
	public static String getMySQLUserPassword() {
		return MYSQL_USER_PASSWORD;
	}
}
