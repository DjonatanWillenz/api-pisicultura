package br.com.api.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import br.com.api.models.Task;
import br.com.api.models.UserInstallation;
import br.com.api.websocket.WsSocket;

@Service
public class WsService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private LogService logService;

    @Autowired
    private UserInstallationService userInstallationService;

    public void sendTask(WebSocketSession ws, Task task) {
        try {
            ws.sendMessage(new TextMessage(task.toString()));
            taskService.updateStateSend(task);
        } catch (IOException e) {
            logService.createLog(e.getMessage(), task.toString(),
                    e.getLocalizedMessage(),
                    "Enviar solicitação via socket!");
        }
    }

    public List<WebSocketSession> findByUsersInstallation(Task task) {
        List<UserInstallation> users = userInstallationService
                .findByIdInstallation(task.getInstallation().getId());
        return WsSocket.sessions
                .stream()
                .filter(tks -> users
                        .stream()
                        .filter(e -> e.getUser().getName()
                                .equals(tks.getPrincipal().getName())) != null)
                .collect(Collectors.toList());
    }
}
