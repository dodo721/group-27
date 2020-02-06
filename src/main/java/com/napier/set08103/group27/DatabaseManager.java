package com.napier.set08103.group27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class to manage the connection between the program and the database
public class DatabaseManager {

    private Connection connection = null;

    //Method to connect to the MySQL database
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
                //Getting some errors with connection - most likely due to the URL
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

    //Method to disconnect from the MySQL database
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
    
}
