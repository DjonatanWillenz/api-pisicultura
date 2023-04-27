package br.com.api.services;

import br.com.api.daos.InstallationDao;
import br.com.api.daos.TaskDao;
import br.com.api.dtos.TaskDto;
import br.com.api.enums.TaskStatusEnum;
import br.com.api.models.Installation;
import br.com.api.models.Task;
import br.com.api.utils.UtilsDate;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private InstallationDao installationDao;

    @Transactional
    public void save(TaskDto taskDto) {
        Installation installation = installationDao.findById(taskDto.getInstallation()).get();
        Task task = new Task();
        task.setDateCreate(UtilsDate.getInstance().getDateCurrent());
        task.setDescription(taskDto.getDescription());
        task.setKey(taskDto.getKey());
        task.setTask(taskDto.getTask());
        task.setStatus(taskDto.getStatus());
        task.setTitle(task.getTitle());
        task.setInstallation(installation);
        taskDao.save(task);
    }

    public Task getById(Long id) {
        Optional<Task> task = taskDao.findById(id);
        return task.isPresent() ? task.get() : null;
    }

    @Transactional
    public void deleteById() {

    }

    public List<Task> findTaskPendent() throws Exception {
        return Optional.ofNullable(
                taskDao.findAll(
                        (root, query, cb) -> cb.and(
                                cb.equal(root.get("status"), TaskStatusEnum.WAITING),
                                cb.equal(root.get("lastttempt"), UtilsDate.getInstance().incMinute(null, 15)))))
                .orElseThrow(() -> new Exception("Nenhuma tarefa foi encontrada para execução"));
    }

    @Transactional
    public void updateStateSend(Task task) {
        task.setStatus(TaskStatusEnum.SEND);
        taskDao.save(task);
    }

    @Transactional
    public void updateTryLastSend(Long id) {
        Task task = getById(id);
        task.setLastAttempt(UtilsDate.getInstance().getDateCurrent());
        taskDao.save(task);
    }

    public List<Task> findByIdInstallation(Long id) {
        return taskDao.findAll((root, qury, cb) -> {
            root.fetch("installation");
            Join<?, ?> installation = root.join("installation");
            return cb.and(cb.equal(installation.get("idinstallation"), id));
        });
    }
}
