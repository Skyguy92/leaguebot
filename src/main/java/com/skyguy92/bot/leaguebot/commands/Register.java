package com.skyguy92.bot.leaguebot.commands;

import com.skyguy92.bot.leaguebot.Main;

public class Register {
    static {
        Main.commands.put("ping", event -> event.getMessage().getChannel()
                .flatMap(messageChannel -> messageChannel.createMessage("Pong!"))
                .then()
        );

        Main.commands.put("pong", event -> event.getMessage().getChannel()
                .flatMap(messageChannel -> messageChannel.createMessage("Ping!"))
                .then()
        );
    }

}
