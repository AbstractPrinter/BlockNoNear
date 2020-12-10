package cn.wangyudi.blocknonear.blocknonear;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class BlockNoNear extends JavaPlugin {
    private static BlockNoNear instance;
    private static List<String> items;

    public static List<String> getItems() {
        return items;
    }

    public static BlockNoNear getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // 设置一个单例引用
        instance = this;
        // 注册监听器
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        // 读取配置文件
        saveDefaultConfig();
        items = getConfig().getStringList("items");
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).split("\\:").length == 1) {
                items.set(i, items.get(i) + ":0");
            }
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
