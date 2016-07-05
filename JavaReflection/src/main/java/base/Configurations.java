package base;

import java.util.List;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class Configurations {

    private List<Config> configs;

    public Configurations() {
    }

    public Configurations(List<Config> configs) {
        this.configs = configs;
    }

    public List<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Config> configs) {
        this.configs = configs;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Parameters{");
        sb.append("parameters=").append(configs);
        sb.append('}');
        return sb.toString();
    }
}

