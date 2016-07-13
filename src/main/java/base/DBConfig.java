package base;

/**
 * Created by pardhamavilla on 13/7/16.
 */
public class DBConfig {

    private String url;

    private String username;

    private String password;

    private String parserClass;

    private String parserMethod;

    public DBConfig() {
    }

    public DBConfig(String url, String username, String password, String parserClass, String parserMethod) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.parserClass = parserClass;
        this.parserMethod = parserMethod;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DBConfig{");
        sb.append("url='").append(url).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", parserClass='").append(parserClass).append('\'');
        sb.append(", parserMethod='").append(parserMethod).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
