package com.xzavier0722.mc.spigot.minersvillagesbot.handlers;

import com.xzavier0722.mc.spigot.minersvillagesbot.api.AGroupMsgHandler;
import com.xzavier0722.mc.spigot.minersvillagesbot.manager.GroupChatManager;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

/**
 * @author ConquerSki
 * @create 2022/8/16 23:07
 */
public class QueryPlayerUnderpantsHandler extends AGroupMsgHandler {

    public QueryPlayerUnderpantsHandler() {
        super("查询裤衩");
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
        ItemStack item = p.getInventory().getLeggings();
        if (null == item || item.getType().isAir()){
            group.sendMessage("玩家 " + p.getName() + " 没穿裤衩子！");
            return;
        }
        group.sendMessage("玩家 " + p.getName() + " 穿的是 " + matchUnderpantsType(item));
    }

    private String matchUnderpantsType(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        if (null != meta && meta.hasDisplayName()) {
            return meta.getDisplayName();
        }
        String itemName = item.getType().toString().toLowerCase().replace("_leggings","");
        switch (itemName){
            case "chainmail":
                return("情趣内裤");
            case "iron":
                return("铁内裤");
            case "golden":
                return("土豪金内裤");
            case "diamond":
                return("蓝白胖次");
            case "netherite":
                return("老头内裤");
            case "neptunium":
                return("海王毛刺内裤");
            case "manasteel":
                return("蓝色内裤");
            case "elementium":
                return("骚粉内裤");
            case "terrasteel":
                return("骚绿内裤");
            case "brass":
                return("CuZn内裤");
            case "brass_accelerator":
                return("CuZn动能内裤");
            case "zinc":
                return("尿不湿");
            case "andesite_accelerator":
                return("安山岩动能内裤");
            case "copper_armor":
                return("导电良好大裤衩");
            case "copper_accelerator":
                return("铜制动能内裤");
            case "alfsteel":
                return("大黄蜂裤衩");
            case "leather":
                return("皮革内裤");
            default:
                return("咱也不知道他穿的啥裤衩");
        }
    }
}
