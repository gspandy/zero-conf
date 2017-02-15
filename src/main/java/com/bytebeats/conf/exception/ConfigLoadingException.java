package com.bytebeats.conf.exception;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 19:34
 */
public class ConfigLoadingException extends RuntimeException {

    private static final long serialVersionUID = 7272618148110977036L;

    public ConfigLoadingException() {
    }

    public ConfigLoadingException(String message) {
        super(message);
    }

    public ConfigLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigLoadingException(Throwable cause) {
        super(cause);
    }
}
