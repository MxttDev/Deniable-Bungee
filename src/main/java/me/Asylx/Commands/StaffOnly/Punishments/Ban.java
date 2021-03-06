package me.Asylx.Commands.StaffOnly.Punishments;

import com.mongodb.client.MongoDatabase;
import me.Asylx.Utils.MongoPunishment;
import me.Asylx.Utils.Permissions;
import me.Asylx.Utils.Punishments;
import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ban extends Command {

    public Ban() {
        super("Ban");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;

        if (p.hasPermission(Permissions.StaffBanPermissions)) {

            if (args.length >= 3) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

                if (target == null) {
                    Utils.Send(p, "&cCannot found player: "+args[0]);
                    return;
                }

                if (MongoPunishment.getData(target) != null) {
                    Utils.Send(p, "&3This player is already banned!");
                    return;
                }

                StringBuilder str = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    str.append(args[i]+ " ");
                }
                String msg = str.toString();

                String time;
                String timePlural;
                long current;
                long end;
                int arg;


                if (args[1].toLowerCase().equalsIgnoreCase("forever")) {
                    current = System.currentTimeMillis();
                    time = "PERMANENT";
                    end = Punishments.Convert(current, 1,"PERM");
                    Punishments.BanPlayer(p,target,msg,time, end);
                    Punishments.sendStaffBanMessage(p,target,msg,time);

                } else if (args[1].toLowerCase().contains("y")) {
                    timePlural = args[1].replace("y", "");
                    current = System.currentTimeMillis();
                    arg = Integer.parseInt(timePlural);
                    if (timePlural.equals("1")) {
                        time = timePlural+" YEAR";
                        end = Punishments.Convert(current, arg,"YEAR");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    } else {
                        time = timePlural+" YEARS";
                        end = Punishments.Convert(current, arg,"YEAR");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    }
                } else if (args[1].toLowerCase().contains("mo")) {
                    timePlural = args[1].replace("mo", "");
                    current = System.currentTimeMillis();
                    arg = Integer.parseInt(timePlural);
                    if (timePlural.equals("1")) {
                        time = timePlural+" MONTH";
                        end = Punishments.Convert(current, arg,"MONTH");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    } else {
                        time = timePlural+" MONTHS";
                        end = Punishments.Convert(current, arg,"MONTH");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    }
                } else if (args[1].toLowerCase().contains("w")) {
                    current = System.currentTimeMillis();
                    timePlural = args[1].replace("w", "");
                    arg = Integer.parseInt(timePlural);
                    if (timePlural.equals("1")) {
                        time = timePlural+" WEEK";
                        end = Punishments.Convert(current, arg,"WEEK");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    } else {
                        time = timePlural+" WEEKS";
                        end = Punishments.Convert(current, arg,"WEEK");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    }
                } else if (args[1].toLowerCase().contains("d")) {
                    current = System.currentTimeMillis();
                    timePlural = args[1].replace("d", "");
                    arg = Integer.parseInt(timePlural);
                    if (timePlural.equals("1")) {
                        time = timePlural+" DAY";
                        end = Punishments.Convert(current, arg,"DAY");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    } else {
                        time = timePlural+" DAYS";
                        end = Punishments.Convert(current, arg,"DAY");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    }
                } else if (args[1].toLowerCase().contains("h")) {
                    current = System.currentTimeMillis();
                    timePlural = args[1].replace("h", "");
                    arg = Integer.parseInt(timePlural);
                    if (timePlural.equals("1")) {
                        time = timePlural+" HOUR";
                        end = Punishments.Convert(current, arg,"HOUR");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    } else {
                        time = timePlural+" HOURS";
                        end = Punishments.Convert(current, arg,"HOUR");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    }
                } else if (args[1].toLowerCase().contains("m")) {
                    current = System.currentTimeMillis();
                    timePlural = args[1].replace("m", "");
                    arg = Integer.parseInt(timePlural);
                    if (timePlural.equals("1")) {
                        time = timePlural+" MINUTE";
                        end = Punishments.Convert(current, arg,"MINUTE");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    } else {
                        time = timePlural+" MINUTES";
                        end = Punishments.Convert(current, arg,"MINUTE");
                        Punishments.BanPlayer(p,target,msg,time, end);
                        Punishments.sendStaffBanMessage(p,target,msg,time);
                    }
                }



            } else {
                Utils.Send(p, "&cIncorrect Usage: /ban (player) (length) (reason)");
            }


        } else {
            Utils.Send(p, Permissions.NoPermsision);
        }




    }
}
