package de.pretooo.gamma.main;

import de.pretooo.gamma.commands.CMD_CountPlayers;
import de.pretooo.gamma.commands.GetDeads;
import de.pretooo.gamma.events.EVENT_onPlayerDeath;
import de.pretooo.gamma.events.EVENT_onPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    public ArrayList<String> dead = new ArrayList<String>();
    public ArrayList<String> alive = new ArrayList<String>();

    private static Main i;
    public static Main getInstance(){
        return i;

    }

    @Override
    public void onEnable(){
        i = this;
        registerEvents();

        getCommand("debug").setExecutor(new GetDeads());
        getCommand("spielerleben").setExecutor(new CMD_CountPlayers());

    }

    @Override
    public void onDisable(){


    }


    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new EVENT_onPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new EVENT_onPlayerDeath(), this);

    }

}
