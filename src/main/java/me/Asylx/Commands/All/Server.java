package me.Asylx.Commands.All;

import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Server extends Command {


    public Server() {
        super("Server");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;



        if (args.length == 1) {
            ServerInfo server = ProxyServer.getInstance().getServerInfo(args[0]);
            if (server == null) {
                Utils.Send(p, "&cServer not found: "+args[0]);
                return;
            }

            p.connect(server);
            Utils.Send(p, "&7Connecting you to &e"+server.getName().toUpperCase());

        } else {
            Utils.Send(p, "&cIncorrect Usage: /server (server)");
        }

    }
}
