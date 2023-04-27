package br.com.api.daos;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.RequestPassword;

@Repository
public interface RequestPasswordDao extends JpaRepositoryImplementation<RequestPassword, Long> {

}
