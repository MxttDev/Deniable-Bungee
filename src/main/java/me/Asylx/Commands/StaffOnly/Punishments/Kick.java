package me.Asylx.Commands.StaffOnly.Punishments;

import me.Asylx.Utils.Mongo;
import me.Asylx.Utils.Permissions;
import me.Asylx.Utils.Punishments;
import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.awt.*;

public class Kick extends Command {

    public Kick() {
        super("Kick");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (p.hasPermission(Permissions.StaffKickPermissions)) {
            if (args.length >= 2) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

                if (target == null) {
                    Utils.Send(p, "&cCannot found player: "+args[2]);
                    return;
                }
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    str.append(args[i]+ " ");
                }
                String msg = str.toString();

                Punishments.sendStaffKickMessage(p,target,msg);
                Punishments.KickPlayer(p,target,msg);
            } else {
                Utils.Send(p, "&cIncorrect Usage: /kick (player) (reason)");
            }
        } else {
            Utils.Send(p, Permissions.NoPermsision);
        }
    }
}
