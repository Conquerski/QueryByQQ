package com.xzavier0722.mc.spigot.minersvillagesbot.handlers;

import com.xzavier0722.mc.spigot.minersvillagesbot.api.AGroupMsgHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.manager.GroupChatManager;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerListHandler extends AGroupMsgHandler {

    public PlayerListHandler() {
        super("在线玩家");
        GroupChatManager.getInstance().registerHandler(this);
    }

    @Override
    public void onTrigger(MiraiGroup group, long senderId, String[] args) {
        StringBuilder sb = new StringBuilder();
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        sb.append("当前共有 ").append(players.size()).append(" 人在线\n").append("玩家列表: ").append("\n");
        players.forEach(p -> sb.append("- ").append(p.getName()).append("\n"));
        group.sendMessage(sb.toString());
    }
}
