package com.imthe.god.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pardhamavilla on 13/7/16.
 */
public class DBConfig {

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("Parser_Class")
    private String parserClass;

    @JsonProperty("Parser_Method")
    private String parserMethod;

    @JsonProperty("parameters")
    private List<String> parameters;

    public DBConfig() {
    }

    public DBConfig(String name, String url, String username, String password, String parserClass, String parserMethod,
                    List<String> parameters) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "DBConfig{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", parserClass='" + parserClass + '\'' +
                ", parserMethod='" + parserMethod + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
