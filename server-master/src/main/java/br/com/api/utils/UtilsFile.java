package br.com.api.utils;

import org.springframework.stereotype.Component;

@Component
public class UtilsFile {

    private static UtilsFile instance;

    public static UtilsFile getInstance() {
        return instance == null ? new UtilsFile() : instance;
    }

}
