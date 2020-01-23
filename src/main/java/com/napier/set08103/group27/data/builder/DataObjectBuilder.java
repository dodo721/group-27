package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;

import java.util.List;

public abstract class DataObjectBuilder {

    protected DatabaseManager database;

    public DataObjectBuilder(DatabaseManager database) {
        this.database = database;
    }

    public abstract String getName();
    public abstract String getId();
    public abstract int getPopulation();
    public abstract String getParentName();
    public abstract List<DataObject> build();

}
