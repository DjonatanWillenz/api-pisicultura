package br.com.auth.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.auth.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String email;
	private Date dateCreate;
	private boolean confirmed;
	private boolean active;

	@DBRef
	private Password password;

	public UserDTO toDTO() {
		return UserDTO.builder().name(name).email(email).confirmed(confirmed).active(active)
				.password(password.getPassword()).build();
	}
}
