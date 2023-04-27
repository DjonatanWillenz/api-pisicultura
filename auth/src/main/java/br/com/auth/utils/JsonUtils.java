package br.com.auth.utils;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JsonUtils {
    
        private Gson gson;
    
        private static JsonUtils instance;
    
        public Gson getGson() {
            return gson;
        }
    
        //public  fromJson(String json, Type typeClass) {
        //    return gson.fromJson(json, (Type) typeClass);
       // }
    
        public String toJson(Object json) {
            return gson.toJson(json);
        }
    
        private JsonUtils() {
            this.gson = new Gson();
        }
    
        public static JsonUtils getInstance() {
            return instance == null ? new JsonUtils() : instance;
        }
    }
    
