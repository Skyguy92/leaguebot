package com.skyguy92.bot.leaguebot.util;

import com.merakianalytics.orianna.types.core.staticdata.Champion;

import java.util.List;

public class Champions {
    public static List<Champion> getChampionById(int id) {
        List<Champion> champions = champions = com.merakianalytics.orianna.types.core.staticdata.Champions.withIds(id).get();
        return champions;
    }

    public static List<Champion> getChampionByName(String name) {
        List<Champion> champions = null;

        switch (name.toLowerCase()) {
            case "lillia":
                champions = com.merakianalytics.orianna.types.core.staticdata.Champions.withIds(876).get();
                break;

            case "yone":
                champions = com.merakianalytics.orianna.types.core.staticdata.Champions.withIds(777).get();
                break;

            default:
                champions = com.merakianalytics.orianna.types.core.staticdata.Champions.named(name).get();
                break;
        }

        return champions;
    }

}
