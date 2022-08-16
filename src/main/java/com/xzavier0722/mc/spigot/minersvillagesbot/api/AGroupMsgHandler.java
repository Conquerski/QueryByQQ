package com.xzavier0722.mc.spigot.minersvillagesbot.api;

import me.dreamvoid.miraimc.api.bot.MiraiGroup;

public abstract class AGroupMsgHandler {

    private final String keyword;

    public AGroupMsgHandler(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public abstract void onTrigger(MiraiGroup group, long senderId, String[] args);

    public boolean onTriggerByOwner(MiraiGroup group, long senderId, String[] args) {
        return false;
    }

    public boolean onTriggerByManager(MiraiGroup group, long senderId, String[] args) {
        return false;
    }

    public boolean onTriggerByMember(MiraiGroup group, long senderId, String[] args) {
        return false;
    }

}
