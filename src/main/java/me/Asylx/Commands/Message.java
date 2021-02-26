package me.Asylx.Commands;

import me.Asylx.Utils.Mongo;
import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Message extends Command {

    public Message() {
        super("msg", "", "message");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        if (args.length >= 2) {
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

            if (target == null) {
                Utils.Send(p, "&cPlayer not found!");
                return;
            }

            StringBuilder str = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                str.append(args[i] + " ");
            }
            String msg = str.toString();
            String formatTo = "&6[TO] "+ Mongo.getData(target).get("Prefix")+target.getName()+"&7: &b"+msg;
            String formatFrom = "&6[FROM] "+ Mongo.getData(p).get("Prefix")+p.getName()+"&7: &b"+msg;

            Utils.Send(target, formatFrom);
            Utils.Send(p, formatTo);

        } else {
            Utils.Send(p, "&cIncorrect Usage: /msg (player) (message)");
        }


    }

}
