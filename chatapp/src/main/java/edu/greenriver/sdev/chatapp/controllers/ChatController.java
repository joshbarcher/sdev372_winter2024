package edu.greenriver.sdev.chatapp.controllers;

import edu.greenriver.sdev.chatapp.models.Chat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController
{
    private Chat[] chats = {
        new Chat("Friend 1", "Hey! How's it going?", false, null),
        new Chat("Friend 2","Not bad! Just finished a workout. You?",false,null),
        new Chat("Friend 1","Nice! I'm binge-watching a new series. Wanna join later?",false,null)
    };

    @GetMapping("chats/all")
    public Chat[] chats()
    {
        return chats;
    }
}
