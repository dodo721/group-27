package com.napier.set08103.group27;

import com.napier.set08103.group27.data.City;
import com.napier.set08103.group27.data.Country;
import com.napier.set08103.group27.data.Languages;

import java.sql.*;
import java.util.ArrayList;

/**
    DatabaseManager is used to manage the connection between the program and the database
    and to carry out queries on the database.
 */
public class DatabaseManager {

    /**
     * Variable used to provide connection to database.
     */
    private Connection connection = null;
    private DataStore dataStore = DataStore.getInstance();

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
    Method to carry out an SQL statement to get all the countries in the database
     */

    //Might want to add all the database reads together in 1 method later on
    public void readCountries()
    {
        try
        {
            Statement statement = connection.createStatement();

            //takes in the table to select from
            String query = "SELECT Code, " +
                    "`Name`, " +
                    "Continent, " +
                    "Region, " +
                    "SurfaceArea, " +
                    "IndepYear, " +
                    "Population, " +
                    "LifeExpectancy, " +
                    "GNP, " +
                    "GNPOld, " +
                    "LocalName, " +
                    "GovernmentForm, " +
                    "HeadOfState, " +
                    "Capital, " +
                    "Code2 " +
                    "FROM country";

            //Executing query
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                String code = resultSet.getString("Code");
                String name = resultSet.getString("Name");
                String continent = resultSet.getString("Continent");
                String region = resultSet.getString("Region");
                double surfaceArea = resultSet.getDouble("SurfaceArea");
                int indepYear = resultSet.getInt("IndepYear");
                int population = resultSet.getInt("Population");
                double lifeExpectancy = resultSet.getDouble("LifeExpectancy");
                double gnp = resultSet.getDouble("GNP");
                double gnpOld = resultSet.getDouble("GNPOld");
                String localName = resultSet.getString("LocalName");
                String governmentForm = resultSet.getString("GovernmentForm");
                String headOfState = resultSet.getString("HeadOfState");
                int capital = resultSet.getInt("Capital");
                String code2 = resultSet.getString("Code2");

                //Debug - check if all countries are being added
                System.out.println("Added Country: " + name);

                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                dataStore.addToCountry(country);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get country details.");
        }
    }

    public void readCities()
    {
        try
        {
            Statement statement = connection.createStatement();

            String query = "SELECT ID, " +
                    "`Name`, " +
                    "CountryCode, " +
                    "District, " +
                    "Population " +
                    "FROM city";

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String countryCode = resultSet.getString("CountryCode");
                String district = resultSet.getString("District");
                int population = resultSet.getInt("Population");

                //debug - check if all cities are being added
                System.out.println("Added City: " + name);

                City city = new City(id, name, countryCode, district, population);
                dataStore.addToCity(city);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get city details.");
        }
    }

    public void readLanguages()
    {
        try {

            ArrayList<Languages> languagesList = new ArrayList<Languages>();

            Statement statement = connection.createStatement();

            String query = "SELECT CountryCode, " +
                    "`Language`, " +
                    "IsOfficial, " +
                    "Percentage " +
                    "FROM countrylanguage";

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                String countryCode = resultSet.getString("CountryCode");
                String language = resultSet.getString("Language");
                String isOfficialString = resultSet.getString("IsOfficial");
                double percentage = resultSet.getDouble("Percentage");

                boolean isOfficial = false;
                if(isOfficialString.equals("T"))
                {
                    isOfficial = true;
                }

                Languages languages = new Languages(countryCode, language, isOfficial, percentage);

                //debug - check if all cities are being added
                System.out.println("Added Language: " + language);

                //If the size of list is 0 then add the language to the list
                if(languagesList.size() == 0)
                {
                    languagesList.add(languages);
                }
                //if the country code of the first index is the same as the language to input then add language to list
                else if(languagesList.get(0).getCountryCode().equals(languages.getCountryCode()))
                {
                    languagesList.add(languages);
                    System.out.println("Added (1): " + language + " To: " + languages.getCountryCode());
                } else {
                    //else add the language list to the hashmap, clear the list and then insert language for next country
                    dataStore.addToLanguages(languagesList);
                    languagesList.clear();
                    languagesList.add(languages);
                }
            }
            dataStore.addToLanguages(languagesList);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Couldn't get language details.");
        }
    }
}
