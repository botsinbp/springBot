package com.codeinbp.telegrambot.handlers;

import com.codeinbp.telegrambot.bot.NovaBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class NovaBotCommandHandler extends NovaBot{

    public void handleNovaCommand(Long id, Message msg){
        if(msg.isCommand()){
            if(msg.getText().equals("/nova")){

                //If the command was /scream, we switch gears
                String nova = "The character was created in 1966 by writer Marv Wolfman in issue #3 of his fanzine Super Adventures. Then known as the Star, he was an alien doctor named Denteen who found a spaceship containing pills which gave him a different superhuman power every five minutes. ";

                sendText(id, nova);
            }




        }
    }
}
