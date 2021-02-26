package me.Asylx.Commands.Misc;

import me.Asylx.Utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Store extends Command {

    public Store() {
        super("store", "", "webstore");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        String msg = "&7Click here to view our &eStore&7!";
        TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', msg));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://store.deniable.net"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));

        Utils.Send(p, "&c ");
        p.sendMessage(message);
        Utils.Send(p, "&a ");

    }

}
