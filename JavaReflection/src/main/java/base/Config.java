package base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class Config {

    @JsonProperty("name")
    private List<String> name;

    @JsonProperty("api")
    private String api;


    @JsonProperty("request_class")
    private String requestClass;

    @JsonProperty("Request_Method")
    private String requestMethod;

    @JsonProperty("Parser_Class")
    private String parserClass;

    @JsonProperty("Parser_Method")
    private String parserMethod;

    public Config() {
    }

    public Config(List<String> name, String api, String requestClass, String requestMethod, String parserClass, String parserMethod) {
        this.name = name;
        this.api = api;
        this.requestClass = requestClass;
        this.requestMethod = requestMethod;
        this.parserClass = parserClass;
        this.parserMethod = parserMethod;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Parameter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", api='").append(api).append('\'');
        sb.append(", requestClass='").append(requestClass).append('\'');
        sb.append(", requestMethod='").append(requestMethod).append('\'');
        sb.append(", parserClass='").append(parserClass).append('\'');
        sb.append(", parserMethod='").append(parserMethod).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
