package me.Asylx.Utils;

import me.Asylx.Main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Punishments {

    private Main plugin = Main.getInstance();
    private Configuration configuration = plugin.configuration;

    public static void BanPlayer(ProxiedPlayer p, ProxiedPlayer target, String reason, String length, long expires)  {
        String mesg = "&6&lYOU HAVE BEEN BANNED!&r\n\n&7Staff member: &e"+p.getName()+"\n&7Reason: &e"+reason+"\n&7Length: &e"+length.toUpperCase()+"\n\n&7Discord: &ediscord.deniable.net\n\n&6&lDENIABLE";
        target.disconnect(new TextComponent(Utils.Colour(mesg)));

        MongoPunishment.createBanProfile(target, reason, expires);

    }

    public static void KickPlayer(ProxiedPlayer p, ProxiedPlayer target, String reason) {
        String message = "&cYou have been disconnected by a member of staff!\n\n&7Reason: &e"+reason+"\n&7Staff member: &e"+p.getName()+"\n\n &7Discord: &ediscord.deniable.net";
        target.disconnect(new TextComponent(Utils.Colour(message)));
    }

    public static void sendStaffKickMessage(ProxiedPlayer p, ProxiedPlayer target, String reason) {
        for (ProxiedPlayer a : ProxyServer.getInstance().getPlayers()) {
            if (a.hasPermission(Permissions.StaffKickListener)) {
                Utils.Send(a, "&a ");
                Utils.Send(a, "&6&lPLAYER KICK");
                Utils.Send(a, "&7Player: &e"+target.getName());
                Utils.Send(a, "&7Staff member: &e"+p.getName());
                Utils.Send(a, "&7Reason: &e"+reason);
                Utils.Send(a, "&7Kicked from: &e"+target.getServer().getInfo().getName());
                Utils.Send(a, "&d ");


            }
        }
    }

    public static void sendStaffBanMessage(ProxiedPlayer p, ProxiedPlayer target, String reason, String length) {
        for (ProxiedPlayer a : ProxyServer.getInstance().getPlayers()) {
            if (a.hasPermission(Permissions.StaffKickListener)) {
                Utils.Send(a, "&a ");
                Utils.Send(a, "&6&lPLAYER BAN");
                Utils.Send(a, "&7Player: &e" + target.getName());
                Utils.Send(a, "&7Staff member: &e" + p.getName());
                Utils.Send(a, "&7Reason: &e" + reason);
                Utils.Send(a, "&7Timeframe: &e" + length.toUpperCase());
                Utils.Send(a, "&7Banned from: &e" + target.getServer().getInfo().getName());
                Utils.Send(a, "&d ");


            }
        }
    }

    public static void sendStaffUnbanMessage(ProxiedPlayer p, String target) {
        for (ProxiedPlayer a : ProxyServer.getInstance().getPlayers()) {
            if (a.hasPermission(Permissions.StaffKickListener)) {
                Utils.Send(a, "&a ");
                Utils.Send(a, "&6&lPLAYER UNBAN");
                Utils.Send(a, "&7Player: &e"+target);
                Utils.Send(a, "&7Staff member: &e"+p.getName());
                Utils.Send(a, "&d ");
            }
        }
    }

    public static long Convert(long current,int arg, String argument) { // CURRENT MS,
        long expires;
        long MSAmount;

        switch (argument) {
            case "PERM":
                MSAmount = 315569520003l;
                expires = current + (MSAmount * 99);
                return expires;
            case "YEAR":
                MSAmount = 31556952000l;
                expires = current + (MSAmount * arg);
                return expires;
            case "MONTH":
                MSAmount = 2629800000l;
                expires = current + (MSAmount * arg);
                return expires;
            case "WEEK":
                MSAmount = 604800016l;
                expires = current + (MSAmount * arg);
                return expires;
            case "DAY":
                MSAmount = 86400000l;
                expires = current + (MSAmount * arg);
                return expires;
            case "HOUR":
                MSAmount = 3600000l;
                expires = current + (MSAmount * arg);
                return expires;
            case "MINUTE":
                MSAmount = 60000l;
                expires = current + (MSAmount * arg);
                return expires;
            default:
                throw new IllegalArgumentException("Idk it broke");
        }
    }

    public static void AlreadyBan(ProxiedPlayer p, String reason, long expires) {
        long Date = expires;

        System.out.println("test");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(expires);

        String mesg = "&6&lYOU HAVE BEEN BANNED!&r\n\n&7Staff member: &e"+p.getName()+"\n&7Reason: &e"+reason+"\n&7Expires: &e"+formatter.format(date)+"\n\n&7Discord: &ediscord.deniable.net\n\n&6&lDENIABLE";
        p.disconnect(new TextComponent(Utils.Colour(mesg)));
    }

}
