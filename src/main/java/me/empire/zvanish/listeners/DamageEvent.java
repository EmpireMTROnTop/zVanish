package me.empire.zvanish.listeners;

import me.empire.zvanish.utils.C;
import me.empire.zvanish.zVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onDamageByPlayer(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player a = (Player) e.getDamager();
            if(zVanish.vanished.contains(a)){
                e.setCancelled(true);
                C.customMessage(a, zVanish.getInstance().getConfig().getString("Messages.Anti-Damage"));
            } else {
                return;
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onDamageByNull(EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(zVanish.vanished.contains(p)){
                e.setCancelled(true);
            } else {
                return;
            }
        }
    }
}
