package br.com.api.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.Email;

@Repository
public interface EmailDao extends JpaRepositoryImplementation<Email, Long> {
   Optional<Email> findByEmail(String email);
}
