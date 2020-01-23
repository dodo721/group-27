package com.napier.set08103.group27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection = null;

    //Method to connect to the MySQL database
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Can't load SQL driver");
            System.exit(-1);
        }

        int retries = 5;
        for(int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database");
            try
            {
                Thread.sleep(9000);
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "password");
                System.out.println("Success");
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

    //Procedure to disconnect from the MySQL database
    public void disconnect()
    {
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
