package com.example.networklab2.bean;

import org.springframework.web.bind.annotation.RequestMapping;


public class Message {

    public String receiver;
    public String sender;
    public String text;
    public String timestamp;



    public Message() {
    }

    public Message(String receiver, String sender, String text, String timestamp) {
        this.receiver = receiver;
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
