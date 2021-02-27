package dev.porkskulls.foodlogs.events;

import dev.porkskulls.foodlogs.FoodlogsPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsumeEvent implements Listener {

    File logs = new File("plugins/Foodlogs/logs.txt");


        @EventHandler
        public void ConsumeShit (PlayerItemConsumeEvent event){

            Player player = event.getPlayer();
            ItemStack foodBeingEaten = player.getItemInHand();
            FoodlogsPlugin.logToFile(logs, "Info | " + player.getName() + " | " + foodBeingEaten.getType() + " | " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS" + " | ")));
        }
    }