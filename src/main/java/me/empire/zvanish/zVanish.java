package me.empire.zvanish;

import me.empire.zvanish.commands.VanishCommand;
import me.empire.zvanish.listeners.DamageEvent;
import me.empire.zvanish.listeners.DeathEvent;
import me.empire.zvanish.listeners.ItemDropEvent;
import me.empire.zvanish.listeners.PickUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class zVanish extends JavaPlugin {

    public static zVanish INSTANCE;
    public static ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public void onEnable() {
        INSTANCE = this;
        registerCommands();
        registerEvents();
        createConfig();
        startAnnouncements();
    }

    @Override
    public void onDisable() {
        shutdownAnnouncements();
    }

    private void registerCommands(){
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    private void registerEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PickUpEvent(), this);
        pm.registerEvents(new ItemDropEvent(), this);
        pm.registerEvents(new DeathEvent(), this);
        pm.registerEvents(new DamageEvent(), this);
    }

    private void createConfig(){
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getLogger().info("Creating new config.yml file...");
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }

    private void startAnnouncements(){
        System.out.println("Enabling zVanish...");
        System.out.println("zVanish has been successfully enabled!");
    }

    private void shutdownAnnouncements(){
        System.out.println("Disabling zVanish...");
        System.out.println("zVanish has been successfully disabled!");
    }

    public static zVanish getInstance(){ return INSTANCE; }
}
