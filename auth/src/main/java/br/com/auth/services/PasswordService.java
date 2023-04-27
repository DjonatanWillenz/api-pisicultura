package br.com.auth.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.auth.models.Password;
import br.com.auth.repository.PasswordRepository;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    @Transactional
    public Password create(String password) {
        Password pass = Password.builder()
                .date(new Date())
                .password(password)
                .build();
        return passwordRepository.save(pass);
    }
}
