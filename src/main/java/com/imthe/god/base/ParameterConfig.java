package com.imthe.god.base;

import java.util.Map;

/**
 * Created by pardhamavilla on 13/7/16.
 */
public class ParameterConfig {

    private String key;

    private Map parameterMapping;

    public ParameterConfig() {
    }

    public ParameterConfig(String key, Map parameterMapping) {
        this.key = key;
        this.parameterMapping = parameterMapping;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map getParameterMapping() {
        return parameterMapping;
    }

    public void setParameterMapping(Map parameterMapping) {
        this.parameterMapping = parameterMapping;
    }

    @Override
    public String toString() {
        return "ParameterConfig{" +
                "key='" + key + '\'' +
                ", parameterMapping=" + parameterMapping +
                '}';
    }
}
