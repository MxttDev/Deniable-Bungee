package me.Asylx.Events;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Data implements Listener {

    @EventHandler
    public void on(PluginMessageEvent event)
    {
        if ( !event.getTag().equalsIgnoreCase( "Bungeecord" ) )
        {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput( event.getData() );
        String subChannel = in.readUTF();
        if ( subChannel.equalsIgnoreCase( "OtherSubchannel" ) )
        {
            // the receiver is a ProxiedPlayer when a server talks to the proxy
            if ( event.getReceiver() instanceof ProxiedPlayer )
            {
                ProxiedPlayer receiver = (ProxiedPlayer) event.getReceiver();
                // do things
            }
            // the receiver is a server when the proxy talks to a server
            if ( event.getReceiver() instanceof Server )
            {
                Server receiver = (Server) event.getReceiver();
                // do things
            }
        }
    }

}
