package com.bytebeats.config.factory;

import com.bytebeats.config.Format;
import com.bytebeats.config.parser.ConfigParser;
import com.bytebeats.config.parser.JsonParserImpl;
import com.bytebeats.config.parser.PropertiesParserImpl;
import com.bytebeats.config.parser.YAMLParserImpl;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-15 23:58
 */
public class ConfigParserFactory {

    public static ConfigParser createConfigParser(Format format){
        ConfigParser parser = null;
        switch (format) {
            case PROPERTIES:
                parser = new PropertiesParserImpl();
                break;
            case JSON:
                parser = new JsonParserImpl();
                break;
            case YAML:
                parser = new YAMLParserImpl();
                break;
        }
        return parser;
    }

}
