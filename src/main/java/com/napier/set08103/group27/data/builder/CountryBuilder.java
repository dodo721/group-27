package com.napier.set08103.group27.data.builder;

import com.napier.set08103.group27.DatabaseManager;
import com.napier.set08103.group27.data.DataObject;

import java.util.List;

public class CountryBuilder extends DataObjectBuilder {
    public CountryBuilder(DatabaseManager database) {
        super(database);
    }

    @Override
    public List<DataObject> build() {
        return null;
    }
}
