package de.pretooo.gamma.events;

import de.pretooo.gamma.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EVENT_onPlayerDeath implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        Main.getInstance().dead.add(p.getName());

    }

}
