package com.codeinbp.telegrambot;

import com.codeinbp.telegrambot.bot.NovaBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@SpringBootApplication
public class TelegrambotApplication extends Driver{
	private static final Logger logger = LoggerFactory.getLogger(NovaBot.class);


	public static void main(String[] args) throws TelegramApiException {
		//Scheduler sc = new Scheduler();

		/*ConfigurableApplicationContext context = SpringApplication.run(TelegrambotApplication.class, args);
		NovaBot novabot= context.getBean(NovaBot.class);
		DeviceId device = context.getBean(DeviceId.class);
		String token = novabot.getBotToken();
		String username = novabot.getBotUsername();
		long c1 = Long.parseLong(novabot.getClientOne());
		System.out.println(token + " " + username + " " + c1);


		Sending ss = new Sending();


		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		NovaBot myBot = new NovaBot(token, username);

		botsApi.registerBot(myBot);


		List<String> devices = device.getDevices();
		logger.info("Found " + (long) devices.size() + " devices ID.");
		for(String d : devices) {
			logger.info("DeviceId = " + d);
			Long dd = Long.parseLong(d);
			//TODO: scheduler not working to all users
			//sc.runScheduler(myBot, dd, "refactored code");
			//ss.sendTextMessageToUser(myBot, dd, "refactored code");

		}
*/

		runApp(SpringApplication.run(TelegrambotApplication.class, args));



	}


}