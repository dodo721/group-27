package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;

import java.util.List;

public class DistrictBuilder extends DataObjectBuilder {
    public DistrictBuilder(DatabaseManager database) {
        super(database);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public int getPopulation() {
        return 0;
    }

    @Override
    public String getParentName() {
        return null;
    }

    @Override
    public List<DataObject> build() {
        return null;
    }
}
