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
import org.w3c.dom.Text;

public class Discord extends Command {

    public Discord() {
        super("discord");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        String msg = "&7Click here to join our &eDiscord&7!";
        TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', msg));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://discord.phasemc.net/"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));

        Utils.Send(p, "&c ");
        p.sendMessage(message);
        Utils.Send(p, "&a ");

    }
}
