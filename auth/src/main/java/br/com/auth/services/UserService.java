package br.com.auth.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.auth.dtos.UserCreateDTO;
import br.com.auth.dtos.UserDTO;
import br.com.auth.models.User;
import br.com.auth.rabbitmq.NotificationPublisher;
import br.com.auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private NotificationPublisher notificationPublisher;

	@Transactional
	public UserDTO save(UserCreateDTO userDTO) throws Exception {

		User user = User.builder().name(userDTO.getName()).email(userDTO.getEmail())
				.password(passwordService.create(userDTO.getPassword())).confirmed(false).dateCreate(new Date())
				.active(true).build();

		UserDTO dto = userRepository.save(user).toDTO();
		notificationPublisher.sendUserCreated(dto);
		return dto;
	}

	public User findByEmail(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
	}
}
