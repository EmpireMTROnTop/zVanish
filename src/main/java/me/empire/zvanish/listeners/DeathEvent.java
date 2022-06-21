package me.empire.zvanish.listeners;

import me.empire.zvanish.zVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent e){
        Player p = e.getEntity().getPlayer();
        if(zVanish.vanished.contains(p)){
            e.setDeathMessage(null);
        } else {
            return;
        }
    }
}
