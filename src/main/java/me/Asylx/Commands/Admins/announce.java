package me.Asylx.Commands.Admins;

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

public class announce extends Command {

    private Main plugin = Main.getInstance();

    public announce() {
        super("announce", "", "alert");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            if (args.length >= 1) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    str.append(args[i]+ " ");
                }
                String msg = str.toString();
                String format = "&c[ALERT] &e"+msg;

                for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                    if (player.hasPermission(Permissions.StaffChatPermissions)) {
                        Utils.Send(player, format);
                    }
                }

            } else {
                sender.sendMessage(new TextComponent("Incorrect Usage: /announce (message)"));
            }
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        if (p.hasPermission(Permissions.StaffChatPermissions)) {

            if (args.length >= 1) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    str.append(args[i]+ " ");
                }
                String msg = str.toString();
                String format = "&c[ALERT] &e"+msg;

                for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                    if (player.hasPermission(Permissions.StaffChatPermissions)) {
                        Utils.Send(player, format);
                    }
                }

            } else {
                Utils.Send(p, "&cIncorrect Usage: /announce (message)");
            }

        } else {
            Utils.Send(p, Permissions.NoPermsision);
        }


    }
}