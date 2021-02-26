package me.Asylx.Utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Utils {

        public static void Send(ProxiedPlayer p, String message) {
            p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', message)));
        }






}
