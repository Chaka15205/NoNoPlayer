package com.chaka15205.nonoplayer;

import com.chaka15205.nonoplayer.listeners.BlockListener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class NoNoPlayer extends JavaPlugin {

    public Permission nnpPlaceTnt = new Permission("nonoplayer.canplace.tnt");

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(nnpPlaceTnt);
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            getLogger().severe("Failed to submit stats");
        }
        new BlockListener(this);
        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
}
