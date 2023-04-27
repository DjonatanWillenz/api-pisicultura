package br.com.api.enums;

import lombok.Getter;

@Getter
public enum RationEnum {
    
     SLIM("Alevinos"),
     AVERAGE("Crescimento"),
     THICK("Engorda");

     private String description;

     RationEnum(String description) {
         this.description = description;
     }
}
