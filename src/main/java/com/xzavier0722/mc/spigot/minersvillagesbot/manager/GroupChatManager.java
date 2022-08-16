package com.xzavier0722.mc.spigot.minersvillagesbot.manager;

import com.xzavier0722.mc.spigot.minersvillagesbot.api.AGroupMsgHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GroupChatManager {

    private static volatile GroupChatManager instance;

    private final Map<String, AGroupMsgHandler> handlers;

    public static GroupChatManager getInstance() {
        if (null == instance) {
            synchronized (GroupChatManager.class) {
                if (null == instance) {
                    instance = new GroupChatManager();
                }
            }
        }
        return instance;
    }

    private GroupChatManager() {
        handlers = new HashMap<>();
    }

    public void registerHandler(AGroupMsgHandler handler) {
        handlers.put(handler.getKeyword(), handler);
    }

    public Optional<AGroupMsgHandler> getHandler(String key) {
        return Optional.ofNullable(handlers.get(key));
    }

}
