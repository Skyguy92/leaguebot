package com.skyguy92.bot.leaguebot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class Level {
    public static String getLevel(MessageCreateEvent event) {
        String input = event.getMessage().getContent().get();
        Summoner summoner = Orianna.summonerNamed(input.split(" ")[1]).get();

        return summoner.getName() + " is level " + summoner.getLevel() + " on the " + summoner.getRegion() + " server.";
    }
}

