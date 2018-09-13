package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import adminapp.member.Member;
import adminapp.utils.Utils;

public class JDBCDatabaseEditor {

	private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_CONNECTION = "jdbc:sqlserver://DESKTOP-2OIQ2MF:1433;databaseName=AdminApp";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "sa";



	public static void insertRecordIntoMemberTable(String firstName, String secondName, String DofB, int age) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO Member"
				+ "(FirstName, SecondName, Age, DofB) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, secondName);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, DofB);
			
			//execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into Member table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	public static void insertRecordIntoUserTable(String firstName, String secondName, String password) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO Employee"
				+ "(FirstName, SecondName, Password) VALUES"
				+ "(?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, secondName);
			preparedStatement.setString(3, password);
			
			//execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into User table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	
	public static String getTable(String table) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String data = "";
		String getTableSQL = "";
		
		dbConnection = getDBConnection();
		
	    try {
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery("select * from " + table + ";");
			
			while (resultSet.next()) {  //retrieve data
			     data += resultSet.getString("FirstName");
			     data += " ";
			     data += resultSet.getString("SecondName");
			     data += " ";
			     data += Utils.parseString(resultSet.getInt("Age"));
			     data += " ";
			     data += resultSet.getString("DofB");
			     data += " ";
			     
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(dbConnection != null) {
				dbConnection.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(resultSet != null) {
				resultSet.close();
			}
		}

	    return data;
	}
	
	public static String getUserTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String data = "";
		
		dbConnection = getDBConnection();
		
	    try {
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery("select * from Employee;");
			
			while (resultSet.next()) {  //retrieve data
			     data += resultSet.getString("FirstName");
			     data += " ";
			     data += resultSet.getString("SecondName");
			     data += " ";
			     data += resultSet.getString("Password");
			     data += " ";
			     
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(dbConnection != null) {
				dbConnection.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(resultSet != null) {
				resultSet.close();
			}
		}

	    return data;
	}

	public static void deleteFromTable(String table, String firstName) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "DELETE FROM " + table +
				" WHERE FirstName = (?);";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, firstName);
			
			//execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("Record is deleted from " + table + " table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}


	
	
}