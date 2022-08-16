package com.xzavier0722.mc.spigot.minersvillagesbot.handlers;

import com.xzavier0722.mc.spigot.minersvillagesbot.api.AGroupMsgHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.manager.GroupChatManager;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FindPlayerLocHandler extends AGroupMsgHandler {
    public FindPlayerLocHandler() {
        super("查询位置");
        GroupChatManager.getInstance().registerHandler(this);
    }

    @Override
    public void onTrigger(MiraiGroup group, long senderId, String[] args) {
        if (args.length != 1) {
            group.sendMessage("用法: " + getKeyword() + " [玩家名]");
            return;
        }
        Player p = Bukkit.getPlayer(args[0]);
        if (null == p) {
            group.sendMessage("该玩家不在线！");
            return;
        }
        Location pl = p.getLocation();
        group.sendMessage("玩家 " + p.getName() + " 当前在 " + getWorldLocalizedName(pl.getWorld().getName()) + " 的 " +
                pl.getBlockX() + "," + pl.getBlockY() + "," + pl.getBlockZ());
    }

    private String getWorldLocalizedName(String worldName){
        switch (worldName){
            case "world":
                return ("主世界");
            case "world/DIM-1":
                return("地狱世界");
            case "world/DIM1":
                return("末地世界");
            default:
                return("未知世界");
        }
    }
}
