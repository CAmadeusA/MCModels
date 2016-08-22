package com.camadeusa;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.EulerAngle;

import com.camadeusa.compatibility.entity.VersionHandler;
import com.camadeusa.compatibility.entity.v1_10.VersionHandler_v1_10_R1;
import com.camadeusa.compatibility.entity.v1_8.VersionHandler_v1_8_R1;
import com.camadeusa.compatibility.entity.v1_8.VersionHandler_v1_8_R3;
import com.camadeusa.compatibility.entity.v1_9.VersionHandler_v1_9_R1;
import com.camadeusa.compatibility.entity.v1_9.VersionHandler_v1_9_R2;

public class MCModelMain extends JavaPlugin {
	public static Plugin plugin;	
	public static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	VersionHandler versionHandler;
	boolean isValid = true;
	
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		plugin = this;

		switch(version) {
		case "v1_8_R1":
			versionHandler = new VersionHandler_v1_8_R1();
			break;
		case "v1_8_R3":
			versionHandler = new VersionHandler_v1_8_R3();
			break;
		case "v1_9_R1":
			versionHandler = new VersionHandler_v1_9_R1();
			break;
		case "v1_9_R2":
			versionHandler = new VersionHandler_v1_9_R2();
			break;
		case "v1_10_R1":
			versionHandler = new VersionHandler_v1_10_R1();
			break;
		default:
			isValid = false;
			
		}
		
		if (!isValid) {
			Bukkit.broadcastMessage("THIS MINECRAFT SERVER VERSION " + version + " IS NOT SUPPORTED!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
		getCommand("Pikachu").setExecutor(new Commands());
		getCommand("Charmander").setExecutor(new Commands());
		getCommand("Squirtle").setExecutor(new Commands());
		getCommand("Bulbasaur").setExecutor(new Commands());
		getCommand("Stitch").setExecutor(new Commands());
		
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(getInstance(), () -> {
			Commands.bases.forEach(b -> {
				float baseYaw = (b.getEntity().getLocation().getYaw() < 0) ? (b.getEntity().getLocation().getYaw() + 360) : (b.getEntity().getLocation().getYaw());	
					//Bukkit.broadcastMessage(b.getEntity().getLocation().getYaw() + "");
					/*b.getSlimes().forEach(s -> {
						if (s.getLocation().getYaw() != baseYaw) {
							versionHandler.setRotation(s, baseYaw, 0);							
						}
					});
					float prevPit = b.getTopSlime().getPassenger().getLocation().getPitch();
					if (b.getTopSlime().getPassenger().getLocation().getYaw() != baseYaw) {
						versionHandler.setRotation(b.getTopSlime().getPassenger(), baseYaw, prevPit);						
					}*/
				shiftEntity(b.getEntity().getPassenger(), baseYaw, b.getEntity().getLocation().getPitch());
				//Bukkit.broadcastMessage("" + b.getEntity().getLocation().getPitch());
				
			});
			
		}, 0, 1);
		
	}
	
	public static Plugin getInstance() {
		return plugin;
	}
	
	public static ItemStack getHead(String s) {
		ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
		head.setDurability((short) 3);
		SkullMeta meta = (SkullMeta) head.getItemMeta();
		meta.setOwner(s);
		head.setItemMeta(meta);
		return head;
	}
	
	public void shiftEntity(Entity e, float yaw, float pitch) {
		versionHandler.setRotation(e, yaw, pitch);
		if (e instanceof ArmorStand && ((ArmorStand) e).getHelmet().getType().equals(Material.SKULL_ITEM)) {
			pitch = (float) Math.toRadians(pitch);
			((ArmorStand) e).setHeadPose(new EulerAngle(pitch, ((ArmorStand) e).getHeadPose().getY(), 0));
		}
		if (e.getPassenger() != null) {
			shiftEntity(e.getPassenger(), yaw, pitch);
		}
	}
}