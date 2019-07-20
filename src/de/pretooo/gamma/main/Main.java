package de.pretooo.gamma.main;

import de.pretooo.gamma.commands.CMD_CountPlayers;
import de.pretooo.gamma.commands.GetDeads;
import de.pretooo.gamma.events.EVENT_onPlayerDeath;
import de.pretooo.gamma.events.EVENT_onPlayerJoin;
import de.pretooo.gamma.utils.UTIL_SaveData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public List<String> dead;
    public List<String> alive;

    private UTIL_SaveData savedata = new UTIL_SaveData();
    public UTIL_SaveData SaveData() {
        return this.savedata;
    }

    private static Main i;
    public static Main getInstance(){
        return i;

    }

    @Override
    public void onEnable(){
        i = this;
        registerEvents();
        registerCommands();

        if(savedata.data.exists()){
            savedata.loadCfg();
        } else {
            return;
        }

    }

    @Override
    public void onDisable(){
        savedata.saveFile();
        savedata.saveCfg();

    }


    public void registerCommands(){
        getCommand("debug").setExecutor(new GetDeads());
        getCommand("spielerleben").setExecutor(new CMD_CountPlayers());

    }

    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new EVENT_onPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new EVENT_onPlayerDeath(), this);

    }

}
