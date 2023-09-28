package com.codeinbp.telegrambot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
//TODO: give billnumber and the bot will send you the bill report in pdf or whatever

//@Component
public class ExampleBot extends TelegramLongPollingBot{
    private static final Logger logger = LoggerFactory.getLogger(ExampleBot.class);

    @Value("${bot.token}")
    private  String token;

    @Value("${username}")
    private  String username;

    private boolean screaming = false;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public ExampleBot(){
        System.out.println(token);

    }

    public ExampleBot( String token, String username) {
        this.token = token;
        this.username = username;
    }


    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }



    @Override
    public void onUpdateReceived(Update update) {
       /* if (update.hasMessage()) {
            Message message = update.getMessage();
            SendMessage response = new SendMessage();
            Long chatId = message.getChatId();
            response.setChatId(String.valueOf(chatId));
            String text = message.getText();
            response.setText(text);
            try {
                execute(response);
                logger.info("Sent message \"{}\" to {}", text, chatId);
            } catch (TelegramApiException e) {
                logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
            }
        }*/

        //mm.setViaBot(ssm);
        //mm.setFrom(ssm);
        var msg = update.getMessage();
        var user = msg.getFrom();

        System.out.println(user.getFirstName() + " wrote " + msg.getText());


        var id = user.getId();
        logger.info("userId = " +id);
        String k = "{\"Full Name\":\"Ritu Sharma\",\"Bill Number\":6540, \"Price.\":100}";
        //String grt = "Greeting from Nova bot!";
        //copyMessage(id, msg.getMessageId()); //msg.getText()


        if(screaming) {
            //If we are screaming
            scream(id, update.getMessage());     //Call a custom method
        }
        else
            copyMessage(id, msg.getMessageId()); //Else proceed normally


        if(msg.isCommand()){
            if(msg.getText().equals("/scream")){

                //If the command was /scream, we switch gears

                screaming = true;
                for(int i=0; i<=4; i++){
                    sendText(id, "sending i= " + i);

                }
                sendText(id, "id= "+id);
                sendText(id, k);
            }

            else if (msg.getText().equals("/whisper"))  //Otherwise, we return to normal
                screaming = false;
            else if (msg.getText().equals("/"))

            return;                                     //We don't want to echo commands, so we exit
        }
    }

    //@PostConstruct
    public void start() {
        logger.info("username: {}, token: {}", username, token);
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    public void copyMessage(Long who, Integer msgId){
        CopyMessage cm = CopyMessage.builder()
                .fromChatId(who.toString())  //We copy from the user
                .chatId(who.toString())      //And send it back to him
                .messageId(msgId)            //Specifying what message
                .build();
        try {
            execute(cm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void scream(Long id, Message msg) {
        if(msg.hasText())
            sendText(id, msg.getText().toUpperCase());
        else
            copyMessage(id, msg.getMessageId());  //We can't really scream a sticker
    }

}
