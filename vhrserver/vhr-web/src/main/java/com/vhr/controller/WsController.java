package com.vhr.controller;

import com.vhr.model.bean.ChatMsg;
import com.vhr.model.bean.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg msg){
        Hr hr = (Hr) authentication.getPrincipal();
        msg.setFrom(hr.getUsername());
        msg.setFromNickname(hr.getName());
        msg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(msg.getTo(),"/queue",msg);
    }
}
