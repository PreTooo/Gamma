package de.pretooo.gamma.commands;

import de.pretooo.gamma.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetDeads implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        if(p.hasPermission("gamma.admin") || p.isOp()){
            if(strings.length == 1){
                if(strings[0].equalsIgnoreCase("alive")){
                    p.sendMessage("" + Main.getInstance().alive.size());

                } else if(strings[0].equalsIgnoreCase("dead")){
                    p.sendMessage("" + Main.getInstance().dead.size());

                }

            }

        }

        return false;
    }
}
