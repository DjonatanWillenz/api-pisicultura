package br.com.api.daos;

import br.com.api.models.UserSystem;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemDao extends JpaRepositoryImplementation<UserSystem, Long> {
    Optional<UserSystem> findByUsername(String username);
}
