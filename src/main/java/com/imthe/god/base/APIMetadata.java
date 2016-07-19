package com.imthe.god.base;


import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class APIMetadata {

    private String API;

    private String userName;

    private String password;

    private String authToken;

    private Integer batchSize;

    private String request;

    private String contentType;

    private String parameterName;

    private Map<String, String> requestParameters = new HashMap();

    private Map<String, String> headerParameters = new HashMap();

    public APIMetadata(String API, String userName, String password, String authToken, Integer batchSize, String request,
                       String contentType, String parameterName, Map<String, String> requestParameters, Map<String, String> headerParameters) {
        this.API = API;
        this.userName = userName;
        this.password = password;
        this.authToken = authToken;
        this.batchSize = batchSize;
        this.request = request;
        this.contentType = contentType;
        this.parameterName = parameterName;
        this.requestParameters = requestParameters;
        this.headerParameters = headerParameters;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Map<String, String> getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(Map<String, String> requestParameters) {
        this.requestParameters = requestParameters;
    }

    public Map<String, String> getHeaderParameters() {
        return headerParameters;
    }

    public void setHeaderParameters(Map<String, String> headerParameters) {
        this.headerParameters = headerParameters;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "APIMetadata{" +
                "API='" + API + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", authToken='" + authToken + '\'' +
                ", batchSize=" + batchSize +
                ", request='" + request + '\'' +
                ", contentType='" + contentType + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", requestParameters=" + requestParameters +
                ", headerParameters=" + headerParameters +
                '}';
    }
}

