package de.pretooo.gamma.events;

import de.pretooo.gamma.main.Main;
import de.pretooo.gamma.utils.UTIL_Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EVENT_onPlayerJoin implements Listener {
    int sched;

    @EventHandler
    public void onEnable(PlayerJoinEvent e){
        UTIL_Scoreboard.setScoreboard(e.getPlayer());

        sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                UTIL_Scoreboard.setScoreboard(e.getPlayer());

            }
        }, 20, 20);

    }

}
