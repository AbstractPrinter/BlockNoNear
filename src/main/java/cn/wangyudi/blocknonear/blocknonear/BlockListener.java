package cn.wangyudi.blocknonear.blocknonear;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        String blockId = String.valueOf(e.getBlock().getTypeId());
        String blockSonId = String.valueOf((short) e.getBlock().getData());
        boolean flag = false;
        for (String item : BlockNoNear.getItems()) {
            if (item.equals(blockId + ":" + blockSonId)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            Block selfBlock = e.getBlock(); //本身
            Block northBlock = e.getBlock().getRelative(BlockFace.NORTH); //北面方块
            Block southBlock = e.getBlock().getRelative(BlockFace.SOUTH); //南面方块
            Block eastBlock = e.getBlock().getRelative(BlockFace.EAST); //东面方块
            Block westBlock = e.getBlock().getRelative(BlockFace.WEST); //西面方块
            if (!selfBlock.getChunk().equals(northBlock.getChunk())//比较区块
                    && blockId.equals(String.valueOf(northBlock.getTypeId())) // 比较Id
                    && blockSonId.equals(String.valueOf((short) northBlock.getData()))//比较子Id
            ) {
                e.getPlayer().sendMessage("§c禁止跨区块相邻。");
                e.setCancelled(true);
                return;
            }
            if (!selfBlock.getChunk().equals(southBlock.getChunk())//比较区块
                    && blockId.equals(String.valueOf(southBlock.getTypeId())) // 比较Id
                    && blockSonId.equals(String.valueOf((short) southBlock.getData()))//比较子Id
            ) {
                e.getPlayer().sendMessage("§c禁止跨区块相邻。");
                e.setCancelled(true);
                return;
            }
            if (!selfBlock.getChunk().equals(eastBlock.getChunk())//比较区块
                    && blockId.equals(String.valueOf(eastBlock.getTypeId())) // 比较Id
                    && blockSonId.equals(String.valueOf((short) eastBlock.getData()))//比较子Id
            ) {
                e.getPlayer().sendMessage("§c禁止跨区块相邻。");
                e.setCancelled(true);
                return;
            }
            if (!selfBlock.getChunk().equals(westBlock.getChunk())//比较区块
                    && blockId.equals(String.valueOf(westBlock.getTypeId())) // 比较Id
                    && blockSonId.equals(String.valueOf((short) westBlock.getData()))//比较子Id
            ) {
                e.getPlayer().sendMessage("§c禁止跨区块相邻。");
                e.setCancelled(true);
                return;
            }
        }
    }
}
