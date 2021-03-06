package me.Asylx;

import me.Asylx.Commands.Find;
import me.Asylx.Commands.Hub;
import me.Asylx.Commands.Message;
import me.Asylx.Commands.Misc.Discord;
import me.Asylx.Commands.Misc.Help;
import me.Asylx.Commands.Misc.Store;
import me.Asylx.Commands.Server;
import me.Asylx.Commands.StaffOnly.Punishments.Ban;
import me.Asylx.Commands.StaffOnly.Punishments.Kick;
import me.Asylx.Commands.StaffOnly.Punishments.Unban;
import me.Asylx.Commands.StaffOnly.Staffchat;
import me.Asylx.Events.ServerStop;
import me.Asylx.Events.onJoin;
import me.Asylx.Utils.Mongo;
import me.Asylx.Utils.MongoPunishment;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

public class Main extends Plugin {

    private static Main instance;
    public Configuration configuration;

    public Main() throws IOException {
    }

    @Override
    public void onEnable() {
        setInstance(this);
        getLogger().info("DENIABLE PLUGIN LOADED!");
        try {
            Mongo.SetupMongoDB();
            MongoPunishment.SetupMongoDB();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        setupStuff();
    }

    private void setupStuff() {
        getProxy().getPluginManager().registerCommand(this, new Staffchat()); // /S (MESSAGE)
        getProxy().getPluginManager().registerCommand(this, new Message()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Server()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Hub()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Find()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Discord()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Store()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Help()); // /MESSAGE
        getProxy().getPluginManager().registerCommand(this, new Kick()); // KICK MSG
        getProxy().getPluginManager().registerCommand(this, new Ban()); // KICK MSG
        getProxy().getPluginManager().registerCommand(this, new Unban()); // KICK MSG

        getProxy().getPluginManager().registerListener(this, new ServerStop());
        getProxy().getPluginManager().registerListener(this, new onJoin());

    }


    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }
}
