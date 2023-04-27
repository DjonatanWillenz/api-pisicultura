package br.com.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.auth.models.Password;

public interface PasswordRepository extends MongoRepository<Password, String>{
    
}
