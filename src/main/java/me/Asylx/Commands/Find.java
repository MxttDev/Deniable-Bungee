package me.Asylx.Commands;

import me.Asylx.Utils.Mongo;
import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Find extends Command {

    public Find() {
        super("Find");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;


        if (args.length == 1) {
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (target == null) {
                Utils.Send(p, "&cPlayer not online!");
                return;
            }
            String format = Mongo.getData(target).get("Prefix")+target.getName()+" &7is connected to: &e"+target.getServer().getInfo().getName().toUpperCase();

            Utils.Send(p, format);

        } else {
            Utils.Send(p, "&cIncorrect Usage: /find (player)");
        }

    }
}
