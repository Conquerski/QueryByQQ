package com.xzavier0722.mc.spigot.minersvillagesbot;

import com.xzavier0722.mc.spigot.minersvillagesbot.handlers.FindPlayerLocHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.handlers.PlayerListHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.handlers.QueryPlayerDeathCountHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.handlers.QueryPlayerUnderpantsHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.listener.QqMsgListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MinersVillagesBot extends JavaPlugin {

    @Override
    public void onEnable() {
        registerHandlers();
        Bukkit.getPluginManager().registerEvents(new QqMsgListener(), this);
    }

    private void registerHandlers() {
        new PlayerListHandler();
        new FindPlayerLocHandler();
        new QueryPlayerUnderpantsHandler();
        new QueryPlayerDeathCountHandler();
    }

}
