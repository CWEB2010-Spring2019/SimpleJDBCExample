/*********************************************************************
 * 
 * Simple Database Example (can be run entirely from the command line)
 * 
 * Joe Axberg
 * 
 * What It Does:
 * 
 * 1. Connects to a MySQL Database using the stand MySQL jdbc driver
 * 2. Runs a select on a table Textbook in the Textbooks database
 * 
 * Modify the code to run other SQL statements.
 * 
 * A description of the Database Table can be found in the .txt files
 * included with the code.
 * 
 * To Compile this code:
 * javac JDBCExample.java
 * 
 * To Run this code:
 * java --class-path mysql-connector-java-8.0.15.jar:. JDBCExample
 * 
 * The mysql connector must be in the classpath
 * 
 * ******************************************************************/

import java.sql.*;

public class JDBCExample{

    public static void main(String[] args){

        System.out.println("JDBC Example");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Get a db connection from the connection factory (database must be running)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://192.168.203.165:3306/Textbooks?&serverTimezone=UTC", "joeaxberg", "Dunwoody1!");
            //Create a SQL statement using the connection's createStatement method.
            Statement stmt = con.createStatement();
            //Execute the query and assign the result to a "ResultSet".  Database queries return rows of data that
            //can be iterated through (iterator pattern)
            ResultSet rs = stmt.executeQuery("select title, author from Textbook");
            //Loop through the results while there is a "next"
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));  
            //close the db connection
            con.close();

        } catch (Exception ex) {
            // handle the error
            System.out.println(ex);
        }
    }
}