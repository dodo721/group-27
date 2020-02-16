package com.napier.set08103.group27;

import java.sql.*;

/**
    DatabaseManager is used to manage the connection between the program and the database
    and to carry out queries on the database.
 */
public class DatabaseManager {

    /**
     * Variable used to provide connection to database.
     */
    private Connection connection = null;

    /**
     * Method to connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            //Loading the SQL driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Can't load SQL driver");
            System.exit(-1);
        }

        int retries = 5;    //Number of times connection will be attempted before providing an error
        for(int i = 1; i <= retries; i++)
        {
            System.out.println("Connecting to database...");
            try
            {
                //Giving time for database to get set up
                Thread.sleep(10000);

                //Getting connection to the database
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "password");
                System.out.println("Successfully connected.");
                break;
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interruption");
            }
            catch (SQLException e)
            {
                System.out.println("Failed after " + i + " retries.");
            }
        }
    }

    /**
     * Method to disconnect from the MySQL database.
     */
    public void disconnect()
    {
        //If there is a connection then try and close the connection
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
               System.out.println("Error closing database");
            }
        }
    }

    /**
    Method to carry out an SQL query on the database and return results of the query.
    @param str : The SQL query for the database
    @return resultSet : The results from the query
     */
    public ResultSet query(String str)
    {
        try
        {
            Statement statement = connection.createStatement();

            //The SQL statement that is passed in
            String strSelect = str;

            //Executing query
            ResultSet resultSet = statement.executeQuery(strSelect);

            return resultSet;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get employee details.");
            return null;
        }
    }
    
}
