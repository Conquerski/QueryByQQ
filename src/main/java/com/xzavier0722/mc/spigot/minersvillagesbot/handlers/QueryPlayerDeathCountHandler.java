package com.xzavier0722.mc.spigot.minersvillagesbot.handlers;

import com.xzavier0722.mc.spigot.minersvillagesbot.api.AGroupMsgHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.manager.GroupChatManager;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

/**
 * @author ConquerSki
 * @create 2022/8/17 0:35
 */
public class QueryPlayerDeathCountHandler extends AGroupMsgHandler {
    public QueryPlayerDeathCountHandler() {
        super("查询死亡次数");
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
        int deathCount = p.getStatistic(Statistic.DEATHS);
        group.sendMessage("玩家 " + p.getName() + " 一共死亡了： " + deathCount + " 次！");

    }
}
