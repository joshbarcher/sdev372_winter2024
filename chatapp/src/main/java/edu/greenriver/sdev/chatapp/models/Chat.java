package edu.greenriver.sdev.chatapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat
{
    private String sender;
    private String message;
    private boolean isAttachment;
    private String attachmentType;

}
