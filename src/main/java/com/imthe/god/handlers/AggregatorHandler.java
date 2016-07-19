package com.imthe.god.handlers;


import com.imthe.god.base.APIConfig;
import com.imthe.god.base.Configurations;
import com.imthe.god.base.DBConfig;
import com.imthe.god.interfaces.data.IAggregator;
import com.imthe.god.util.ConfigReader;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mavilla on 18/07/16.
 */
public class AggregatorHandler implements IAggregator {

    public Map<String, String> getData(String key) {

        Map<String, String> data = new HashMap<String, String>();

        Configurations configurations = (Configurations) ConfigReader.configs.get(key);

        List<APIConfig> apiConfigs = configurations.getApiConfigs();

        List<DBConfig> dbConfigs = configurations.getDbConfigs();


        for (APIConfig apiConfig : apiConfigs) {
            try {
                data.putAll(APIHandler.getDataFromAPI(apiConfig, new HashMap<String, String>()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        for (DBConfig dbConfig : dbConfigs) {
            data.putAll(DBHandler.getDatafromDB(dbConfig));
        }


        return data;
    }
}
