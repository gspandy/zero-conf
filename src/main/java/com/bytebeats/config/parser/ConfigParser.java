package com.bytebeats.config.parser;

import com.bytebeats.config.Config;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-15 23:49
 */
public interface ConfigParser {

    Config parse(InputStream in) throws Exception;
}
