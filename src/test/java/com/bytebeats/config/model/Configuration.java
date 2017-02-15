package com.bytebeats.config.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:40
 */
public class Configuration {
    private Date released;
    private String version;
    private Connection connection;
    private List<String> protocols;
    private Map<String, String> developers;

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<String> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<String> protocols) {
        this.protocols = protocols;
    }

    public Map<String, String> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Map<String, String> developers) {
        this.developers = developers;
    }
}
