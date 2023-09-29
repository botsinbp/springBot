package com.codeinbp.telegrambot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class TelegrambotApplication {
	private static final Logger logger = LoggerFactory.getLogger(NovaBot.class);


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

		String reminder = "Enhance Logs";


		try{
			int count = 0;
			while(true){
				System.out.println(new Date());
				sendTextMessageToUser(myBot, c1, "Reminder " + count + ": " + reminder);
				Thread.sleep(20 * 1000);
				count++;
			}

		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	public static void sendTextMessageToUser(NovaBot bot, Long userId, String textMessage) {
		bot.sendText(userId, textMessage);
		logger.info("Bot Sending: " + textMessage);
	}
}