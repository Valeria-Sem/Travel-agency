package com.epam.travelAgency.dao.pool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static final DBResourceManager instance = new DBResourceManager();
    private static final String database = "database";

    private ResourceBundle bundle = ResourceBundle.getBundle(database);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
