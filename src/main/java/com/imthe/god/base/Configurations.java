package com.imthe.god.base;

import java.util.List;
import java.util.Map;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class Configurations {

    private Map<String, String> details;

    private List<APIConfig> apiConfigs;

    private List<DBConfig> dbConfigs;

    private List<LogicConfig> logicConfigs;

    public Configurations() {
    }

    public Configurations(Map<String, String> details, List<APIConfig> apiConfigs, List<DBConfig> dbConfigs, List<LogicConfig> logicConfigs) {
        this.details = details;
        this.apiConfigs = apiConfigs;
        this.dbConfigs = dbConfigs;
        this.logicConfigs = logicConfigs;
    }

    public List<APIConfig> getApiConfigs() {
        return apiConfigs;
    }

    public void setApiConfigs(List<APIConfig> apiConfigs) {
        this.apiConfigs = apiConfigs;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public List<DBConfig> getDbConfigs() {
        return dbConfigs;
    }

    public void setDbConfigs(List<DBConfig> dbConfigs) {
        this.dbConfigs = dbConfigs;
    }

    public List<LogicConfig> getLogicConfigs() {
        return logicConfigs;
    }

    public void setLogicConfigs(List<LogicConfig> logicConfigs) {
        this.logicConfigs = logicConfigs;
    }

    @Override
    public String toString() {
        return "Configurations{" +
                "details=" + details +
                ", apiConfigs=" + apiConfigs +
                ", dbConfigs=" + dbConfigs +
                ", logicConfigs=" + logicConfigs +
                '}';
    }
}

