package com.codeinbp.telegrambot;

import com.codeinbp.telegrambot.Messages.Sending;
import com.codeinbp.telegrambot.bot.NovaBot;
import com.codeinbp.telegrambot.devices.DeviceId;
import com.codeinbp.telegrambot.utils.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

public class Driver {

    private static final Logger logger = LoggerFactory.getLogger(NovaBot.class);

    public static void runApp(ConfigurableApplicationContext context) throws TelegramApiException {
        //ConfigurableApplicationContext context = SpringApplication.run(TelegrambotApplication.class, args);
        NovaBot novabot= context.getBean(NovaBot.class);
        DeviceId device = context.getBean(DeviceId.class);
        String token = novabot.getBotToken();
        String username = novabot.getBotUsername();
        logger.info("Token = " + token);
        logger.info("Username = " + username);

        Sending ss = new Sending();
        Scheduler sc = new Scheduler();

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
            ss.sendTextMessageToUser(myBot, dd, "refactored code");

        }

    }
}
