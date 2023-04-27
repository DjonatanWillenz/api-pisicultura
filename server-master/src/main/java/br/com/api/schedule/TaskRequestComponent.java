package br.com.api.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.api.configs.SystemConf;
import br.com.api.services.LogService;
import br.com.api.services.TaskService;
import br.com.api.services.WsService;

@Component
public class TaskRequestComponent {

    @Autowired
    private TaskService taskService;

    @Autowired
    private LogService logService;

    @Autowired
    private WsService wsService;

    /*
     * @apiNote
     * 
     * Realiza processo de requisição dos serviços para os sockets.
     * 
     */
    @Scheduled(initialDelay = SystemConf.TIME_SCHEDULE_INIT, fixedDelay = SystemConf.TIME_TASK_REQUEST)
    public void runRequest() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    taskService
                            .findTaskPendent()
                            .stream()
                            .forEach(task -> wsService.findByUsersInstallation(task)
                                    .forEach(ws -> wsService.sendTask(ws, task)));
                } catch (Exception e) {
                    logService.createLog(e.getMessage(), "", e.getLocalizedMessage(),
                            "Erro ao criar thread de envio de solicitações via!");
                }
            }
        });

        thread.start();
    }
}
