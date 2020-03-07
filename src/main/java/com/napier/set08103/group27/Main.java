package com.napier.set08103.group27;

import java.util.Iterator;

public class Main {

    private static DataStore dataStore = DataStore.getInstance();

    public static void main (String[] args) {

        DatabaseManager db = new DatabaseManager();

        //Connecting to the database
        db.connect();

        //Reading data from SQL database - might be best to merge these into 1 method
        db.readCountries();
        db.readCities();
        db.readLanguages();

        for(String s : dataStore.getLanguageHashMap().keySet())
        {
            for(int i = 0; i < dataStore.getLanguageHashMap().get(s).size(); i++)
            {
                System.out.println(s + "=" + dataStore.getLanguageHashMap().get(s).get(i).getLanguage());
            }
        }


        //Need to test if the get methods from the DataStore singleton work and output correct data

        //Closing the connection to database
        db.disconnect();
    }
}
