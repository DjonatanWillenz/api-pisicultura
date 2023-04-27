package br.com.api.schedule;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import br.com.api.configs.SystemConf;
import br.com.api.services.LogService;
import br.com.api.services.NotificationService;
import br.com.api.utils.UtilsJson;
import br.com.api.websocket.WsSocket;

@Component
public class NotificationComponent {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private LogService logService;

    @Scheduled(initialDelay = SystemConf.TIME_SCHEDULE_INIT, fixedRate = SystemConf.TIME_TASK_NOTIFICATIO)
    public void pushNotification() {
        try {
            notificationService.findPending()
                    .stream()
                    .forEach(notify -> {
                        WsSocket.sessions
                                .stream()
                                .filter(e -> e.getPrincipal().getName().equals(notify.getUser().getName()))
                                .forEach(action -> {
                                    try {
                                        action.sendMessage(
                                                new TextMessage(UtilsJson.getInstance().toJson(notify)));
                                    } catch (IOException e) {
                                        logService.createLog(e.getMessage(), notify.toString(),
                                                e.getLocalizedMessage(),
                                                "Enviar notificação ao usuário via socket!");
                                    }
                                });
                    });
        } catch (Exception e) {
            logService.createLog(e.getMessage(), e.toString(),
                    e.getLocalizedMessage(), "Erro ao cosultar os dados da tabela de notificações");
        }
    }
}
