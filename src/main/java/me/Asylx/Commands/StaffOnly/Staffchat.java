package me.Asylx.Commands.StaffOnly;

import me.Asylx.Main;
import me.Asylx.Utils.Mongo;
import me.Asylx.Utils.Permissions;
import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.io.File;
import java.util.Locale;

public class Staffchat extends Command {

    private Main plugin = Main.getInstance();

    public Staffchat() {
        super("s", "", "staffchat");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        String serverName = p.getServer().getInfo().getName().toUpperCase();

        if (p.hasPermission(Permissions.StaffPermissions)) {

            if (args.length >= 1) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    str.append(args[i]+ " ");
                }
                String msg = str.toString();
                String format = "&C[STAFF] &6["+serverName+"] "+ Mongo.getData(p).get("Prefix")+p.getName()+"&7: &b"+msg;

                for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                    if (player.hasPermission(Permissions.StaffPermissions)) {
                        Utils.Send(player, format);
                    }
                }

            } else {
                Utils.Send(p, "&cIncorrect Usage: /s (message)");
            }

        } else {
            Utils.Send(p, Permissions.NoPermsision);
        }


    }
}
