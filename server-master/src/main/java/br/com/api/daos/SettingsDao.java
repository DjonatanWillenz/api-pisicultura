package br.com.api.daos;

import br.com.api.models.Settings;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsDao extends JpaRepositoryImplementation<Settings, Long> {
}
