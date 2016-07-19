package com.imthe.god.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class APIConfig {

    @JsonProperty("name")
    private String name;

    @JsonProperty("api")
    private String api;

    @JsonProperty("Request_Class")
    private String requestClass;

    @JsonProperty("Request_Method")
    private String requestMethod;

    @JsonProperty("Parser_Class")

    private String parserClass;

    @JsonProperty("Parser_Method")
    private String parserMethod;

    @JsonProperty("parameters")
    private List<String> parameters;

    public APIConfig() {
    }

    public APIConfig(String name, String api, String requestClass, String requestMethod, String parserClass,
                     String parserMethod, List<String> parameters) {
        this.name = name;
        this.api = api;
        this.requestClass = requestClass;
        this.requestMethod = requestMethod;
        this.parserClass = parserClass;
        this.parserMethod = parserMethod;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(String requestClass) {
        this.requestClass = requestClass;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getParserClass() {
        return parserClass;
    }

    public void setParserClass(String parserClass) {
        this.parserClass = parserClass;
    }

    public String getParserMethod() {
        return parserMethod;
    }

    public void setParserMethod(String parserMethod) {
        this.parserMethod = parserMethod;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "APIConfig{" +
                "name='" + name + '\'' +
                ", api='" + api + '\'' +
                ", requestClass='" + requestClass + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", parserClass='" + parserClass + '\'' +
                ", parserMethod='" + parserMethod + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
