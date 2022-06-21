package me.empire.zvanish.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class C {

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void customMessage(Player to, String message){
       to.sendMessage(color(message));
    }
}
