package me.empire.zvanish.listeners;

import me.empire.zvanish.zVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(zVanish.vanished.contains(p)){
            e.setJoinMessage(null);
        } else {
            return;
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(zVanish.vanished.contains(p)){
            e.setQuitMessage(null);
        } else {
            return;
        }
    }
}
