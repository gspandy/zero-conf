package com.bytebeats.config.exception;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 19:34
 */
public class ConfigException extends RuntimeException {

    private static final long serialVersionUID = 7272618148110977036L;

    public ConfigException() {
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }
}
