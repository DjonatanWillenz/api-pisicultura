package br.com.notification.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.notification.dtos.NotificationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("notification")
public class Notification implements Serializable {

    @Id
    private String id;

    private String idinstallation;

    private String title;

    private String description;

    private String logs;

    public NotificationDTO  toDTO(){
        return NotificationDTO.builder()
        .id(id)
        .idinstallation(idinstallation)
        .title(title)
        .description(description)
        .logs(logs)
        .build();
    }
}
