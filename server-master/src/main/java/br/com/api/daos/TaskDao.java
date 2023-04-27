package br.com.api.daos;

import br.com.api.models.Task;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepositoryImplementation<Task, Long> {
}
