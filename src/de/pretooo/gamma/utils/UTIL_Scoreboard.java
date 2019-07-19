package de.pretooo.gamma.utils;

import de.pretooo.gamma.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UTIL_Scoreboard {
    public static void setScoreboard(Player p){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String atime = sdf.format(new Date());

        String adead = "" + Main.getInstance().dead.size();

        String aalive = "" + Main.getInstance().alive.size();


        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = sb.registerNewObjective("gamma", "dummy");

        o.setDisplayName("§7» §2§lGAMMA §7«");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score alive = o.getScore("§7» §bLebende Spieler:");
        Score dead = o.getScore("§7» §bGestorbene Spieler:");
        Score time = o.getScore("§7» §bZeit:");
        Score timeleft = o.getScore("§7» §bZeit bis Server schließt:");

        Score alivea = o.getScore("   §e" + aalive);
        Score deada = o.getScore("   §e" + adead);
        Score timea = o.getScore("   §e" + atime);
        Score timelefta = o.getScore("   §enullll");

        Score spacer0 = o.getScore("§e");
        Score spacer1 = o.getScore("§f");
        Score spacer2 = o.getScore("§g");
        Score spacer3 = o.getScore("§h");

        alive.setScore(12);
        alivea.setScore(11);
        spacer0.setScore(10);
        dead.setScore(9);
        deada.setScore(8);
        spacer1.setScore(7);
        timeleft.setScore(6);
        timelefta.setScore(5);
        spacer2.setScore(4);
        time.setScore(3);
        timea.setScore(2);
        spacer3.setScore(1);

        p.setScoreboard(sb);

        for (Player current : Bukkit.getOnlinePlayers()) {
            current.setScoreboard(sb);
        }

    }

}
