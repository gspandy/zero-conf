package com.bytebeats.config.util;

import com.bytebeats.config.exception.ConfigException;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-17 13:13
 */
public class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static RuntimeException castThrowable(Throwable wrapped) {
        Throwable unwrapped = wrapped;
        if(!(unwrapped instanceof RuntimeException)) {
            return new ConfigException(unwrapped);
        }
        return (RuntimeException) wrapped;
    }
}
