package br.com.api.daos;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.UserInstallation;

@Repository
public interface UserInstallationDao extends JpaRepositoryImplementation<UserInstallation, Long> {

}
