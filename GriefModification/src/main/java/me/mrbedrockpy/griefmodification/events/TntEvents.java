package me.mrbedrockpy.griefmodification.events;

import me.mrbedrockpy.griefmodification.Plugin;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TntEvents implements Listener {

    private List<Block> superTNTs = new ArrayList<>();
    private List<Block> ultraTNTs = new ArrayList<>();

    @EventHandler
    public void onPlaceTNT(BlockPlaceEvent event) {

        ItemStack item = event.getItemInHand();

        if (Plugin.getInstance().superTnt.isSimilar(item)) {superTNTs.add(event.getBlockPlaced());}

        else if (Plugin.getInstance().ultraTnt.isSimilar(item)) {ultraTNTs.add(event.getBlockPlaced());}
    }

    @EventHandler
    public void onPrimeTNT(TNTPrimeEvent event) {

        if (superTNTs.contains(event.getPrimingBlock())) {

            superTNTs.remove(event.getPrimingBlock());

            Location location = event.getPrimingEntity().getLocation();
            event.getPrimingEntity().remove();
            TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);

            tnt.setInvulnerable(true);

            tnt.setYield(2000);

        }

        else if (ultraTNTs.contains(event.getPrimingBlock())) {

            ultraTNTs.remove(event.getPrimingBlock());

            Location location = event.getPrimingEntity().getLocation();
            event.getPrimingEntity().remove();
            TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);

            tnt.setInvulnerable(true);

            tnt.setYield(5000);

        }
    }
}
