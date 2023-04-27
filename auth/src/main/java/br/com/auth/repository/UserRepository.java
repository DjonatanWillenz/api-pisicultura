package br.com.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.auth.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    
}
