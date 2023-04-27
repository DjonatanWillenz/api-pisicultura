package br.com.api.dtos;

import java.io.Serializable;
import java.util.Date;

import br.com.api.enums.FoodStateEnum;
import br.com.api.enums.RationEnum;
import br.com.api.enums.RunEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodDto implements Serializable {
    private Long id;
    private Long idinstallation;
    private FoodStateEnum state;
    private Date dateCreate;
    private Date dateConcluded;
    private RationEnum ration; 
    private Date dateRunFeed;
    private RunEnum run;
}
