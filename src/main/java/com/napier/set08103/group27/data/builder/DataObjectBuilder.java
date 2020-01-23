package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;

import java.util.List;

// Class for building a single DataObject from the SQL database, before parenting
public abstract class DataObjectBuilder {

    protected DatabaseManager database;

    public DataObjectBuilder(DatabaseManager database) {
        this.database = database;
    }

    // Abstract methods to be populated with SQL queries to fetch needed data,
    // which can be specified to each object type within each implementation
    public abstract String getName();
    public abstract String getId();
    public abstract int getPopulation();
    public abstract String getParentName();
    public abstract List<DataObject> build();

}
