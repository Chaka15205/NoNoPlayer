package com.chaka15205.nonoplayer.listeners;

import com.chaka15205.nonoplayer.NoNoPlayer;
import com.chaka15205.nonoplayer.util.ChatPrefix;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
    public BlockListener(NoNoPlayer pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (e.getBlock().getType() == Material.TNT) {
            if (!player.hasPermission("nonoplayer.canplace.tnt")) {
                player.sendMessage(ChatPrefix.NO_PERMS + e.getBlock().getType().toString());
                e.setCancelled(true);
            }
        }
    }
}
