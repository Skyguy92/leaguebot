package com.skyguy92.bot.leaguebot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.Embed;
import discord4j.core.spec.EmbedCreateSpec;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScore;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScores;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;


import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

public class Mastery {
    public static Consumer<EmbedCreateSpec> getMastery(MessageCreateEvent event) {

        String input = event.getMessage().getContent().get(); // Get String Input
        String[] splitInput = input.split(" "); // Split words to find argument
        Summoner summoner = Orianna.summonerNamed(splitInput[1]).get(); // Find the summoner name.

        Consumer<EmbedCreateSpec> output = null;

        if (!summoner.exists()) {
            output = spec -> {
                spec.setTitle("Mastery");
                spec.setDescription(String.format("User %s does not exist on the NA Region.", splitInput[1]));
            };
        }

        String championIdentifier = splitInput[2];

        List<Champion> champions = com.skyguy92.bot.leaguebot.util.Champions.getChampionByName(championIdentifier);

        ChampionMastery mastery = ChampionMastery.forSummoner(summoner).withChampion(champions.get(0)).get();
        System.out.println("Building Output.");

        return output = spec -> {
            spec.setTitle("Mastery");
            spec.setDescription(String.format("Mastery for %s on %s.",splitInput[1], championIdentifier));
            spec.setColor(new Color(255, 0,0));
            spec.addField("Level", Integer.toString(mastery.getLevel()), true);
            spec.addField("Points", Integer.toString(mastery.getPoints()), true);
            spec.addField("Chest Granted", String.valueOf(mastery.isChestGranted()), false);
            spec.addField("Tokens", String.valueOf(mastery.getTokens()), true);
//            spec.addField("Last Played", String.valueOf(mastery.getLastPlayed()), true);

        };

    }
}
