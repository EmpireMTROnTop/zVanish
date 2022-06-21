package me.empire.zvanish.listeners;

import me.empire.zvanish.zVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickUpEvent implements Listener {

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        if(zVanish.vanished.contains(p)){
            e.setCancelled(true);
        } else {
            return;
        }
    }
}
