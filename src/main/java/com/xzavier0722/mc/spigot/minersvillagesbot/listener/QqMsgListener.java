package com.xzavier0722.mc.spigot.minersvillagesbot.listener;

import com.xzavier0722.mc.spigot.minersvillagesbot.manager.GroupChatManager;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Arrays;

public class QqMsgListener implements Listener {

    @EventHandler
    public void onGroupChatMsgReceived(MiraiGroupMessageEvent e) {
        String[] msg = e.getMessage().split(" ");
        if (msg.length < 1) {
            return;
        }

        GroupChatManager.getInstance().getHandler(msg[0]).ifPresent(h -> {
            boolean isConsumed = false;
            String[] args = Arrays.copyOfRange(msg, 1, msg.length);
            switch (e.getSenderPermission()) {
                case 0:
                    isConsumed = h.onTriggerByMember(e.getGroup(), e.getSenderID(), args);
                    break;
                case 1:
                    isConsumed = h.onTriggerByManager(e.getGroup(), e.getSenderID(), args);
                    break;
                case 2:
                    isConsumed = h.onTriggerByOwner(e.getGroup(), e.getSenderID(), args);
                    break;
                default:
                    break;
            }

            if (!isConsumed) {
                h.onTrigger(e.getGroup(), e.getSenderID(), args);
            }
        });
    }

}
