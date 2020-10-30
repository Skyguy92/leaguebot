package com.skyguy92.bot.leaguebot;

import com.merakianalytics.orianna.types.common.Region;
import com.skyguy92.bot.leaguebot.commands.Register;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.merakianalytics.orianna.Orianna;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, Command> commands = new HashMap<>();

    private static final char prefix = '!';

    public static void main(String[] args) {

        Orianna.setRiotAPIKey(args[1]);
        Orianna.setDefaultRegion(Region.NORTH_AMERICA);

        final DiscordClient client = new DiscordClientBuilder(args[0]).build(); // Build a new DiscordClient object
        // Command Registration
        new Register();

        client.getEventDispatcher().on(MessageCreateEvent.class) // On Message
                .flatMap(event -> Mono.justOrEmpty(event.getMessage().getContent())  // Message contents
                    .flatMap(content -> Flux.fromIterable(commands.entrySet()) // Find commands in match
                        .filter(entry -> content.startsWith(prefix + entry.getKey())) // Does something
                        .flatMap(entry -> entry.getValue().execute(event)) // Runs code.
                            .next()))
                .subscribe();

        client.login().block(); // Login and block thread
    }
}
