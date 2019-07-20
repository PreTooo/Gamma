package de.pretooo.gamma.utils;

import de.pretooo.gamma.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class UTIL_SaveData {
    public File data = new File("plugins/Gamma", "data.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(data);

    public void saveFile(){
        cfg.addDefault("list", "");
        cfg.set("list.alive", Main.getInstance().alive);
        cfg.set("list.dead", Main.getInstance().dead);

    }

    public void loadCfg(){
        Main.getInstance().alive = cfg.getStringList("list.alive");
        Main.getInstance().dead = cfg.getStringList("list.dead");

    }

    public void saveCfg(){
        try{
            cfg.save(data);
        } catch(IOException e){
            Bukkit.getConsoleSender().sendMessage("§4Beim Speicher der data.yml ist ein Fehler ausgetreten!");
            e.printStackTrace();
        }

    }

}
