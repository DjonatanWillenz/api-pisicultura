package br.com.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.api.enums.RunEnum;
import br.com.api.enums.TemperatureStateEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TemperatureDto implements Serializable {
    private Long id;
    private TemperatureStateEnum state;
    private RunEnum run;
    private Long idinstallation;
    private Date date;
    private BigDecimal value;
}
