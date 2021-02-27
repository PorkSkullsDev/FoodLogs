package dev.porkskulls.foodlogs;

import dev.porkskulls.foodlogs.events.ConsumeEvent;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public final class FoodlogsPlugin extends JavaPlugin {

    File logs = new File(this.getDataFolder(), "logs.txt");

        public void onEnable() {
            getBufferedWriter(logs);
            getServer().getPluginManager().registerEvents(new ConsumeEvent(), this);
        }

        @Override
        public void onDisable () {
            // Plugin shutdown logic
        }

    public static HashMap<File, BufferedWriter> writers = new HashMap<File, BufferedWriter>();
    public static BufferedWriter getBufferedWriter(File f) {
        try {
            if (writers.containsKey(f)) {
                System.out.print("found writer for file " + f.getName());
                return writers.get(f);
            } else {
                System.out.print("Couldn't find writer for file " + f.getName());
                BufferedWriter returns = new BufferedWriter(new FileWriter(f, true));
                writers.put(f, returns);
                return returns;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void logToFile(File f, String message) {
        try {
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            BufferedWriter br = getBufferedWriter(f);
            br.write(message);
            br.newLine();
            br.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
