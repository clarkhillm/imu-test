package org.gavincui.imutest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;

@Controller
@ServerEndpoint(value = "/imuws/origin")
public class WSControllerOrigin {

    public static final List<Session> socketList = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        socketList.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        socketList.remove(session);
    }

    @OnMessage
    public void OnMessage(String msg, Session session) {
    }
}
