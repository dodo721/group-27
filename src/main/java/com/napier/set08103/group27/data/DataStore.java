package com.napier.set08103.group27.data;

// Singleton class for keeping the World instance
public class DataStore {

    private World world;
    private static DataStore instance;

    private DataStore () {
        world = new World();
    }

    public World getWorld () {
        return world;
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

}
