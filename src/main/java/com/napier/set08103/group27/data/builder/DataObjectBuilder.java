package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;

import java.sql.SQLException;
import java.util.List;

// Class for building a single DataObject from the SQL database, before parenting
public abstract class DataObjectBuilder {

    protected DatabaseManager database;

    public DataObjectBuilder(DatabaseManager database) {
        this.database = database;
    }

    // Abstract methods to be populated with SQL queries to fetch needed data,
    // which can be specified to each object type within each implementation

    /**
     * Builds a list of data objects for the appropriate type using SQL data
     * to be used by the DataTreeBuilder and eventually stored internally
     * @return List of data objects
     * @throws SQLException from database
     */
    public abstract List<DataObject> build() throws SQLException;

}
