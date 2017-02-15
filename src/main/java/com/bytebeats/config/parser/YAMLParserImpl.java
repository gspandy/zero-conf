package com.bytebeats.config.parser;

import com.bytebeats.config.Config;
import com.bytebeats.config.impl.YAMLConfig;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-15 23:48
 */
public class YAMLParserImpl implements ConfigParser {

    public Config parse(InputStream in) throws Exception {
        ByteArrayOutputStream result = null;
        try {
            result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return new YAMLConfig(result.toString("UTF-8"));
        } finally {
            result.close();
        }
    }
}
