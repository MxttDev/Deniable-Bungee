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

public class Help extends Command {

    public Help() {
        super("help", "", "helpme");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;

        String msg = "&c ▪ &eReport rule breakers";
        String msg2 = "&c ▪ &eReport a server issue / bug";
        String msg3 = "&c ▪ &eTalk to a staff member";
        TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', msg));
        TextComponent message2 = new TextComponent(ChatColor.translateAlternateColorCodes('&', msg2));
        TextComponent message3 = new TextComponent(ChatColor.translateAlternateColorCodes('&', msg3));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/wdbpffuuvf"));
        message2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/wdbpffuuvf"));
        message3.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/wdbpffuuvf"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));
        message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));
        message3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));

        Utils.Send(p, "&c ");
        Utils.Send(p, "&6&lDENIABLE ");
        Utils.Send(p, "&7Click to select a help option..");
        Utils.Send(p, "&d "); //▪ ➥
        p.sendMessage(message);
        p.sendMessage(message2);
        p.sendMessage(message3);
        Utils.Send(p, "&a ");

    }

}
