package base;

import java.util.List;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class Configurations {

    private List<APIConfig> apiConfigs;

    private List<DBConfig> dbConfigs;

    private List<LogicConfig> logicConfigs;

    private List<ParameterConfig> parameterConfigs;

    public Configurations() {
    }

    public Configurations(List<APIConfig> apiConfigs, List<DBConfig> dbConfigs,
                          List<LogicConfig> logicConfigs, List<ParameterConfig>
                                  parameterConfigs) {
        this.apiConfigs = apiConfigs;
        this.dbConfigs = dbConfigs;
        this.logicConfigs = logicConfigs;
        this.parameterConfigs = parameterConfigs;
    }

    public List<APIConfig> getApiConfigs() {
        return apiConfigs;
    }

    public void setApiConfigs(List<APIConfig> apiConfigs) {
        this.apiConfigs = apiConfigs;
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

    public List<ParameterConfig> getParameterConfigs() {
        return parameterConfigs;
    }

    public void setParameterConfigs(List<ParameterConfig> parameterConfigs) {
        this.parameterConfigs = parameterConfigs;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Configurations{");
        sb.append("apiConfigs=").append(apiConfigs);
        sb.append(", dbConfigs=").append(dbConfigs);
        sb.append(", logicConfigs=").append(logicConfigs);
        sb.append(", parameterConfigs=").append(parameterConfigs);
        sb.append('}');
        return sb.toString();
    }
}

