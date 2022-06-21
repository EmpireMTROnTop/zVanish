package me.empire.zvanish.commands;

import me.empire.zvanish.utils.C;
import me.empire.zvanish.zVanish;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("vanish")){
            if(!(sender instanceof Player)){
                sender.sendMessage(C.color("&cYou must be a player to perform this command!"));
            } else {
                Player p = (Player) sender;
                if(!p.hasPermission("zvanish.command.vanish")){
                    C.customMessage(p, "&cYou don't have permission to perform this command!");
                } else {
                    if(args.length == 0){
                        if(zVanish.vanished.contains(p)){
                            zVanish.vanished.remove(p);
                            C.customMessage(p, zVanish.getInstance().getConfig().getString("Messages.Unvanished-Message"));
                            for(Player online : Bukkit.getOnlinePlayers()){
                                if(!online.hasPermission("zvanish.staff")){
                                    online.showPlayer(p);
                                } else {
                                    C.customMessage(online, zVanish.getInstance().getConfig().getString("Messages.Unvanished-Broadcast").replaceAll("%player%", p.getName()));
                                }
                            }
                        } else {
                            zVanish.vanished.add(p);
                            C.customMessage(p, zVanish.getInstance().getConfig().getString("Messages.Vanished-Message"));
                            for(Player online : Bukkit.getOnlinePlayers()){
                                if(!online.hasPermission("zvanish.staff")){
                                    online.hidePlayer(p);
                                } else {
                                    C.customMessage(online, zVanish.getInstance().getConfig().getString("Messages.Vanished-Broadcast").replaceAll("%player%", p.getName()));
                                }
                            }
                        }
                    } else if(args.length == 1){
                        Player t = Bukkit.getPlayer(args[0]);
                        if(t == null){
                            C.customMessage(p, "&cThat player is currently offline!");
                        } else {
                            if(zVanish.vanished.contains(t)){
                                zVanish.vanished.remove(t);
                                C.customMessage(t, zVanish.getInstance().getConfig().getString("Messages.Unvanished-Message"));
                                for(Player online : Bukkit.getOnlinePlayers()){
                                    if(!online.hasPermission("zvanish.staff")){
                                        online.showPlayer(t);
                                    } else {
                                        C.customMessage(online, zVanish.getInstance().getConfig().getString("Messages.Player-Unvanished-Other-Broadcast").replaceAll("%player%", p.getName()).replaceAll("%target%", t.getName()));
                                    }
                                }
                            } else {
                                zVanish.vanished.add(t);
                                C.customMessage(t, zVanish.getInstance().getConfig().getString("Messages.Vanished-Message"));
                                for(Player online : Bukkit.getOnlinePlayers()){
                                    if(!online.hasPermission("zvanish.staff")){
                                        online.hidePlayer(t);
                                    } else {
                                        C.customMessage(online, zVanish.getInstance().getConfig().getString("Messages.Player-Vanished-Other-Broadcast").replaceAll("%player%", p.getName()).replaceAll("%target%", t.getName()));
                                    }
                                }
                            }
                        }
                    } else if(args.length >= 1){
                        C.customMessage(p, "&cIncorrect Usage:");
                        C.customMessage(p, "&eUsage: &d/vanish &r(optional<player>)");
                    }
                }
            }
        }
        return true;
    }
}
