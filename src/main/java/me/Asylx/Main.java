package me.Asylx;

import me.Asylx.Commands.Find;
import me.Asylx.Commands.Hub;
import me.Asylx.Commands.Message;
import me.Asylx.Commands.Misc.Discord;
import me.Asylx.Commands.Misc.Help;
import me.Asylx.Commands.Misc.Store;
import me.Asylx.Commands.Server;
import me.Asylx.Commands.StaffOnly.Staffchat;
import me.Asylx.Utils.Mongo;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

public class Main extends Plugin {

    private static Main instance;
    public Configuration config;
    private File file;

    public Main() throws IOException {
    }

    @Override
    public void onEnable() {
        setInstance(this);
        getLogger().info("DENIABLE PLUGIN LOADED!");
        try {
            Mongo.SetupMongoDB();
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

    }


    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }
}
