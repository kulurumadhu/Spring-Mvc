package com.emp.connection;

public interface DBQueryI {
	
	
	public static final String CREATE_TABLE = "CREATE TABLE EMP_INFO(EMPID INT(10),EMPNAME VARCHAR(20),SALARY INT(10))";
	public static final String INSERT_EMPINFO = "INSERT INTO EMP_INFO (EMPID,EMPNAME,SALARY)VALUES(?,?,?)";
	public static final String UPDATE_EMPINFO_BY_EMPID = "UPDATE EMP_INFO SET SALARY = ? WHERE EMPID= ?";
	public static final String DELETE_EMPiNFO_BY_EMPID = "DELETE FROM EMP_INFO WHERE EMPID=?";
	public static final String READ_EMPINFO_BYID = "SELECT * FROM EMP_INFO WHERE EMPID=?";
	public static final String READ_ALL_EMP_INFO = "SELECT * FROM EMP_INFO";
	public static final String DELETE_ALL_EMP_INFO = "DELETE FROM EMP_INFO";

}
