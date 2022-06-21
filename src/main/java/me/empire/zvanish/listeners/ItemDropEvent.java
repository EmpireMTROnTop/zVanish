package me.empire.zvanish.listeners;

import me.empire.zvanish.utils.C;
import me.empire.zvanish.zVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropEvent implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(zVanish.vanished.contains(p)){
            e.setCancelled(true);
            C.customMessage(p, zVanish.getInstance().getConfig().getString("Messages.Anti-Items-Drop"));
        } else {
            return;
        }
    }
}
