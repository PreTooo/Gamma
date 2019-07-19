package de.pretooo.gamma.commands;

import de.pretooo.gamma.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_CountPlayers implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;

        if(p.hasPermission("gamma.count") || p.isOp()) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                Main.getInstance().alive.add(all.getName());

            }

        }

        return false;
    }
}
