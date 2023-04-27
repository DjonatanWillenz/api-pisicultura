package br.com.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.api.enums.RunEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhDto implements Serializable {  
    private Long id;
    private BigDecimal value;
    private Date date;
    private Long idinstallation;
    private RunEnum run; 
}
