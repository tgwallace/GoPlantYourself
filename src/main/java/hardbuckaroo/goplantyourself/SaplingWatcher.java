package hardbuckaroo.goplantyourself;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import java.util.Random;

public class SaplingWatcher implements Listener {
    private final GoPlantYourself plugin;
    public SaplingWatcher(GoPlantYourself plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDespawn(ItemDespawnEvent event){
        Item item = event.getEntity();
        Location location = event.getLocation();
        Block block = location.getBlock();
        Material material = item.getItemStack().getType();
        Random rand = new Random();

        if((block.getRelative(0,-1,0).getType().equals(Material.GRASS_BLOCK) || block.getRelative(0,-1,0).getType().equals(Material.DIRT) || block.getRelative(0,-1,0).getType().equals(Material.FARMLAND) || block.getRelative(0,-1,0).getType().equals(Material.COARSE_DIRT) || block.getRelative(0,-1,0).getType().equals(Material.PODZOL)
                || (block.getRelative(0,-1,0).getType().equals(Material.SAND) && (material.equals(Material.CACTUS) || material.equals(Material.SUGAR_CANE)))
                || ((block.getLightLevel() < 13 || block.getRelative(0,-1,0).getType().equals(Material.PODZOL) || block.getRelative(0,-1,0).getType().equals(Material.MYCELIUM)) && (Material.BROWN_MUSHROOM.equals(material) || Material.RED_MUSHROOM.equals(material)))
                || (block.getRelative(0,-1,0).getType().equals(Material.SOUL_SAND) && Material.NETHER_WART.equals(material)))
                && (plugin.getConfig().contains("Plants."+material))) {
            int chance = rand.nextInt(100);
            int config = plugin.getConfig().getInt("Plants."+material);
            if (config >= chance) {
                if (Material.BAMBOO.equals(material)) {
                    block.setType(Material.BAMBOO_SAPLING);
                } else if (Material.WHEAT_SEEDS.equals(material)) {
                    block.setType(Material.WHEAT, false);
                } else if (Material.POTATO.equals(material)) {
                    block.setType(Material.POTATOES, false);
                } else if (Material.BEETROOT_SEEDS.equals(material)) {
                    block.setType(Material.BEETROOTS, false);
                } else if (Material.CARROT.equals(material)) {
                    block.setType(Material.CARROTS, false);
                } else if (Material.MELON_SEEDS.equals(material)) {
                    block.setType(Material.MELON_STEM, false);
                } else if (Material.PUMPKIN_SEEDS.equals(material)) {
                    block.setType(Material.PUMPKIN_STEM, false);
                } else if (Material.TORCHFLOWER_SEEDS.equals(material)) {
                    block.setType(Material.TORCHFLOWER_CROP, false);
                } else if (Material.PITCHER_POD.equals(material)) {
                    block.setType(Material.PITCHER_CROP, false);
                } else if (Material.SWEET_BERRIES.equals(material)) {
                    block.setType(Material.SWEET_BERRY_BUSH, false);
                } else if (Material.SUGAR_CANE.equals(material) && (block.getRelative(1,-1,0).getType().equals(Material.WATER) || block.getRelative(-1,-1,0).getType().equals(Material.WATER) || block.getRelative(0,-1,1).getType().equals(Material.WATER) || block.getRelative(0,-1,-1).getType().equals(Material.WATER))) {
                    block.setType(Material.SUGAR_CANE, false);
                } else if (Material.CACTUS.equals(material) && block.getRelative(0,-1,0).getType().equals(Material.SAND)) {
                    block.setType(Material.CACTUS, false);
                } else if ((block.getRelative(0,-1,0).getType().equals(Material.SOUL_SAND) && Material.NETHER_WART.equals(material))) {
                    block.setType(Material.NETHER_WART, false);
                } else block.setType(material);
            }
        }
    }
}
