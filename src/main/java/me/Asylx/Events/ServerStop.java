package me.Asylx.Events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ServerStop implements Listener {

    @EventHandler
    public void onServerKick(ServerKickEvent e) {


        ProxiedPlayer p = e.getPlayer();
        ServerInfo lobby = ProxyServer.getInstance().getServerInfo("Lobby");

        if (e.getPlayer().getServer() !=null) {

        }
        e.setCancelled(true);
        p.connect(lobby);

    }
}
