package com.skyguy92.bot.leaguebot.commands;

import com.skyguy92.bot.leaguebot.Main;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.MessageChannel;

public class Register {
    static {
        Main.commands.put("ping", event -> event.getMessage().getChannel()
                .flatMap(messageChannel -> messageChannel.createMessage("Pong!"))
                .then()
        );

        Main.commands.put("level", event -> event.getMessage().getChannel()
                .flatMap(messageChannel -> messageChannel.createMessage(Level.getLevel(event)))
                .then()
        );

        Main.commands.put("mastery", event -> event.getMessage().getChannel()
                .flatMap(messageChannel -> messageChannel.createEmbed(Mastery.getMastery(event)))
                .then()
        );

        Main.commands.put("free", event -> event.getMessage().getChannel()
                .flatMap(messageChannel -> messageChannel.createMessage(Free.rotation()))
                .then()
        );
    }

}
