package com.skyguy92.bot.leaguebot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScore;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScores;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.List;

public class Mastery {
    public static String getMastery(MessageCreateEvent event) {

        String input = event.getMessage().getContent().get();
        String[] splitInput = input.split(" ");

        Summoner summoner = Orianna.summonerNamed(splitInput[1]).get();

        List<Champion> champions = Champions.named(splitInput[2]).get();

        ChampionMastery mastery = ChampionMastery.forSummoner(summoner).withChampion(champions.get(0)).get();

        return "User " + summoner.getName() + " has " + mastery;
    }
}
