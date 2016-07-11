package base;


import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Metadata {
    private String API;

    private String userName;

    private String password;

    private String authToken;

    private Integer batchSize;

    private String parameterName;

    private Map<String, String> requestParameters = new HashMap();

    private Map<String, String> headerParameters = new HashMap();

    public Metadata(String API, String userName, String password, String parameterName, int batchSize, String authToken, Map<String, String> requestParameters, Map<String, String> headerParameters) {
        this.API = API;
        this.userName = userName;
        this.password = password;
        this.parameterName = parameterName;
        this.batchSize = batchSize;
        this.authToken = authToken;
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
}

