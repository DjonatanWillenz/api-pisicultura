package br.com.api.daos;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.InstallationSettings;

@Repository
public interface InstallationSettingsDao extends JpaRepositoryImplementation<InstallationSettings, Long> {

}
