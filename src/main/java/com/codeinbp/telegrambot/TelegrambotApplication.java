package com.codeinbp.telegrambot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegrambotApplication {


	public static void main(String[] args) throws TelegramApiException {


		ConfigurableApplicationContext context = SpringApplication.run(TelegrambotApplication.class, args);
		NovaBot novabot= context.getBean(NovaBot.class);
		String token = novabot.getBotToken();
		String username = novabot.getBotUsername();
		Long c1 = Long.parseLong(novabot.getClientOne());
		System.out.println(token + " " + username + " " + c1);


		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		NovaBot myBot = new NovaBot(token, username);

		botsApi.registerBot(myBot);


		//myBot.sendText(6017516597L, "Hello Nova Alien Bot!");
		//myBot.sendText(325406611L, "Hello Nova Alien Bot!");
		//myBot.sendText(6017516597L, "server stopped, Nova no longer work :(");
		//myBot.sendText(325406611L, "server stopped, Nova no longer work :(");

		for(int i=0; i<=3; i++){
			myBot.sendText(c1, "Count = " + i );
		}







	}

}
