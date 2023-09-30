package com.codeinbp.telegrambot.Messages;

import com.codeinbp.telegrambot.bot.NovaBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sending {
    private static final Logger logger = LoggerFactory.getLogger(NovaBot.class);

    public void sendTextMessageToUser(NovaBot bot, Long userId, String textMessage) {
        bot.sendText(userId, textMessage);
        logger.info("Bot Sending: " + textMessage + " to "+userId);
    }

    public void sendJsonMessageToUser(NovaBot bot, Long userId, String jsonMessage){
        //TODO: implement sendJson method
        bot.sendText(userId, jsonMessage);
        logger.info("Bot Sending: " + jsonMessage + " to "+userId);
    }
}
