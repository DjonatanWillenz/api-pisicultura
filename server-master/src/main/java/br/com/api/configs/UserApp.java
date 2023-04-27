package br.com.api.configs;

import org.springframework.stereotype.Component;

@Component
public class UserApp {

    private static UserApp instance;

    //private String url = "localhost:8080/";
    private String email = "DjonatanHorus@gmail.com";

    private UserApp() {

    }

    public static UserApp getInstance() {
        return instance != null ? instance : new UserApp();
    }

   // public String getUrl() {
    //    return this.url;
   // }

    public String getEmail() {
        return this.email;
    }
}
