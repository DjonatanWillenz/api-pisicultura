package br.com.api.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SendEmailDto implements Serializable { 
    private String tomail;
    private String title;
    private String body;
}
