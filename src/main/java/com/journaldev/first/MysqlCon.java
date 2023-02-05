package com.journaldev.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MySQLConfig {
	 private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/poker";
	 private static final String USER = "root";
	 private static final String PASS = "Minecraft965!";
	 
    public static void addRow(ArrayList<String> colv, ArrayList<String> coln,String table_name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            // Execute a query
            System.out.println("Inserting data into table_name...");
            String sql = "INSERT INTO " + table_name + " ("+coln.get(0)+", "+coln.get(1)+", "+coln.get(2)+", "+coln.get(3)+", "+coln.get(4)+", "+coln.get(5)+", "+coln.get(6)+", "+coln.get(7)+") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            for(int i = 0; i < 8; i++) {
            	stmt.setString(i+1, colv.get(i));
            }
            stmt.executeUpdate();

            System.out.println("Data inserted successfully!");
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    public static void removeRow(String columnValue, String table_name, String column_name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            // Execute a query
            System.out.println("Deleting data from table_name...");
            String sql = "DELETE FROM "+table_name+" WHERE "+column_name+" = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, columnValue);
            stmt.executeUpdate();

            System.out.println("Data deleted successfully!");
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
    
    public static String selectItem(String column_name, String table_name, String IdCol, String value) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            // Execute a query
            System.out.println("Retrieving data from table_name...");
            String sql = "SELECT "+column_name+" FROM "+table_name+" WHERE "+IdCol+" = "+value+"";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            String returnValue = null;
            // Retrieve by column name
            if(rs.next()) {
            	returnValue = rs.getString(column_name);
	            System.out.println("Data retrieved: " + column_name + " = " + returnValue);
            }
            // Clean-up environment
            conn.commit();
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        return null;
    }
    
    public static int getNextGameId() {
    	Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            // Execute a query
            System.out.println("Retrieving data from table_name...");
            String sql = "SELECT game_id FROM game_info ORDER BY game_id DESC LIMIT 1";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            String mostRecentAddition = null;
            if (rs.next()) {
                mostRecentAddition = rs.getString("game_id");
                System.out.println("The most recent addition to the table is: " + mostRecentAddition);
            }

            // Clean-up environment
            conn.commit();
            rs.close();
            stmt.close();
            conn.close();
            return Integer.parseInt(mostRecentAddition);
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        return 0;
    }
    
    public static void updateValue(String table_name, String column_name, String newValue, String columnValue) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            // Execute a query
            System.out.println("Updating value in table_name...");
            String sql = "UPDATE ? SET ? = ? WHERE column_name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, table_name);
            stmt.setString(2, column_name);
            stmt.setString(3, newValue);
            stmt.setString(4, column_name);
            stmt.setString(5, columnValue);
            int rowAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowAffected);
            conn.commit();
            // Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
    
    public static String getCurrentTime() {
        Timestamp a = new java.sql.Timestamp(new java.util.Date().getTime());
    	return a.toString();
    }
}
