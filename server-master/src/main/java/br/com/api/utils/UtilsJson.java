package br.com.api.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

import org.springframework.stereotype.Component;

import br.com.api.dtos.WsMensagemDto;

@Component
public class UtilsJson {

    private Gson gson;

    private static UtilsJson instance;

    public Gson getGson() {
        return gson;
    }

    public WsMensagemDto fromJson(String json, Type clas) {
        return gson.fromJson(json, (Type) clas);
    }

    public String toJson(Object json) {
        return gson.toJson(json);
    }

    private UtilsJson() {
        this.gson = new Gson();
    }

    public static UtilsJson getInstance() {
        return instance == null ? new UtilsJson() : instance;
    }
}
