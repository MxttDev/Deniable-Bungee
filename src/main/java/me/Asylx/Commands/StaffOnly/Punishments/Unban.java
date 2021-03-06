package me.Asylx.Commands.StaffOnly.Punishments;

import me.Asylx.Utils.MongoPunishment;
import me.Asylx.Utils.Permissions;
import me.Asylx.Utils.Punishments;
import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class Unban extends Command {
    public Unban() {
        super("Unban");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (p.hasPermission(Permissions.StaffKickPermissions)) {
            if (args.length == 1) {
               String uuid = Utils.getUuid(args[0]);
               String value = uuid.replace("-", "");
               System.out.println(value);

               if (MongoPunishment.getDataFromUUID(value) == null) {
                   Utils.Send(p, "&cPlayer not found: "+args[0]);
                   return;
               } else {
                   MongoPunishment.clearDatafromUUID(value);
                   Punishments.sendStaffUnbanMessage(p,args[0]);

               }



            } else {
                Utils.Send(p, "&cIncorrect Usage: /unban (player)");
            }
        } else {
            Utils.Send(p, Permissions.NoPermsision);
        }
    }
}