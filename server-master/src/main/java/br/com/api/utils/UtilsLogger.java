package br.com.api.utils;

import org.springframework.stereotype.Component;

@Component
public class UtilsLogger {
    private static UtilsLogger instance;

    public static UtilsLogger getInstance() {
        return instance == null ? new UtilsLogger() : instance;
    }
}
