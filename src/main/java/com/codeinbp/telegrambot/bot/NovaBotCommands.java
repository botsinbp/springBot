package com.codeinbp.telegrambot.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NovaBotCommands {

    List<String> commands = new ArrayList<>();

    public List<String> listOfCommands(){
        commands.add("/about");
        commands.add("/developer");
        commands.add("/now");
        commands.add("/deviceid");
        commands.add("/nova");

        return commands;

    }
}
