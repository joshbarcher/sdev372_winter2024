package edu.greenriver.sdev.chatapp;

import edu.greenriver.sdev.chatapp.models.Chat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatappApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ChatappApplication.class, args);

		System.out.println("Hello");
	}
}
