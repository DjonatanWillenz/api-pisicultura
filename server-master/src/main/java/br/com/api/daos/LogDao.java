package br.com.api.daos;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.Log;

@Repository
public interface LogDao extends JpaRepositoryImplementation<Log, Long> {

}
