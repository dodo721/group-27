package com.napier.set08103.group27;

public class Main {

    public static void main (String[] args) {

        DatabaseManager db = new DatabaseManager();

        //Connecting to the database
        db.connect();

        //Reading data from SQL database - might be best to merge these into 1 method
        db.readCountries();
        db.readCities();
        db.readLanguages();

        //Need to test if the get methods from the DataStore singleton work and output correct data

        //Closing the connection to database
        db.disconnect();
    }
}
