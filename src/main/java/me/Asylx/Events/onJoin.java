package me.Asylx.Events;

import me.Asylx.Utils.MongoPunishment;
import me.Asylx.Utils.Punishments;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PostLoginEvent e) {
        ProxiedPlayer p = e.getPlayer();

        if (MongoPunishment.getData(p) != null) {

            if (MongoPunishment.getData(p).getLong("Expires") <= System.currentTimeMillis()) {
                MongoPunishment.clearData(p);
            }

            String reason = MongoPunishment.getData(p).getString("Reason");
            long expires = MongoPunishment.getData(p).getLong("Expires");
            Punishments.AlreadyBan(p, reason, expires);

            System.out.println(System.currentTimeMillis());




        }

    }

}
