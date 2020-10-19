package com.skyguy92.bot.leaguebot.commands;

import com.merakianalytics.orianna.types.core.champion.ChampionRotation;
import com.merakianalytics.orianna.types.core.searchable.SearchableList;
import com.merakianalytics.orianna.types.core.staticdata.Champion;

import java.util.List;

public class Free {
    public static String rotation() {
        StringBuilder output = new StringBuilder();
        SearchableList<Champion> idList = ChampionRotation.get().getFreeChampions();
        for (Champion champion : idList) {
            output.append(champion.getName()).append("\u0020");
        }
        return output.toString();
    }
}
