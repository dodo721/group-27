package com.napier.set08103.group27;

public class Main {

    public static void main (String[] args) {
        System.out.println("test");

        DatabaseManager db = new DatabaseManager();

        //Connecting to the database
        db.connect();

        //TODO: put SQL statements/methods to get from the database here

        //Closing the connection to database
        db.disconnect();
    }

}
