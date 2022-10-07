package org.gavincui.imutest;

import java.util.ArrayList;
import java.util.List;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@ServerEndpoint(value = "/imuws")
public class WSController {

    private static final Logger log = LoggerFactory.getLogger(WSController.class);

    public static final List<Session> socketList = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        log.debug("open ...");
        socketList.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        socketList.remove(session);
        log.debug("ws closed ...");
    }

    @OnMessage
    public void OnMessage(String msg, Session session) {
    }
}
