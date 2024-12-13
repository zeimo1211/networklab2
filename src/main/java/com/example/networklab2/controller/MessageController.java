package com.example.networklab2.controller;


import com.example.networklab2.bean.Message;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // 允许所有来源
public class MessageController {

    // 存储聊天信息
    private HashMap<String, List<Message>> messageStore;

    public MessageController() {
        this.messageStore = new HashMap<>();
    }

    // 生成唯一键的方法
    private String generateKey(String receiver, String sender) {
        return receiver + ":" + sender;
    }

    @RequestMapping(value = "/api/messages", method = RequestMethod.GET)
    public List<Message> getMessages(String userid, String friendid) {
        System.out.println("调用getMessages方法");
        System.out.println("userid: " + userid + ", friendid: " + friendid);
        String key = generateKey(userid, friendid);

        List<Message> messages = messageStore.get(key);
        if (messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    @RequestMapping(value = "/api/sendMessage", method = RequestMethod.POST)
    public void sendMessage(@RequestBody Map<String, String> request) {
        String sender = request.get("sender");
        String receiver = request.get("receiver");
        String text = request.get("text");
        String key = generateKey(sender, receiver);
        System.out.println("调用sendMessage方法");
        System.out.println("sender: " + sender + ", receiver: " + receiver + ", text: " + text);
        List<Message> messages = messageStore.get(key);
        if (messages == null) {
            messages = new ArrayList<>();
            messageStore.put(key, messages);
        }

        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 格式化为 ISO 8601 格式
        String timestamp = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        Message message = new Message(receiver, sender, text, timestamp);

        messages.add(message);
    }

}
