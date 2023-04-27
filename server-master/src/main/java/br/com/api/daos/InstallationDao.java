package br.com.api.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.Installation;

@Repository
public interface InstallationDao extends JpaRepositoryImplementation<Installation, Long> {

    @Query(value = "select app.installation.*                                                                  " +
            "  from app.installation                                                                           " +
            "  join app.installationsettings on (app.installationsettings.idinstallation = app.installation.id " +
            "                               and  app.installationsettings.active = true)                       " +
            "  join app.task on (app.task.idinstallation = (                                                   " +
            "                       select tasks.idinstallation                                                " +
            "                         from app.task as tasks                                                   " +
            "                        where tasks.idinstallation = app.installation.id                          " +
            "                          and tasks.task = ?1                                                     " +
            "                         limit 1 ))                                                               " +
            " where app.task.task = ?1                                                                         " +
            "   and app.installationsettings.task = ?1                                                         " +
            "   and app.installation.active = true                                                             ", nativeQuery = true)
    public List<Installation> findByServiceAndActive(Integer task);

}
