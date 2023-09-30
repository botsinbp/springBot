package com.codeinbp.telegrambot.utils;

import com.codeinbp.telegrambot.Messages.Sending;
import com.codeinbp.telegrambot.bot.NovaBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

public class Scheduler {
    private static final Logger logger = LoggerFactory.getLogger(NovaBot.class);

    Sending sendingMsg = new Sending();

    @Lazy
    public void runScheduler(NovaBot myBot, Long userID, String message) {
        try{
            int count = 0;
            while(true){
                System.out.println("Date = " + new Date());
                sendingMsg.sendTextMessageToUser(myBot, userID, "Reminder " + count + ": " + message);
                Thread.sleep(20 * 1000);

                count++;
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
