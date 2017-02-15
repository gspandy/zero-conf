package com.bytebeats.config.parser;

import com.bytebeats.config.Config;
import com.bytebeats.config.impl.PropertiesConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-15 23:48
 */
public class PropertiesParserImpl implements ConfigParser {

    public Config parse(InputStream in) throws Exception {
        Properties props = new Properties();
        props.load(in);
        return new PropertiesConfig(props);
    }
}
