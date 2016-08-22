package com.camadeusa;

import java.util.LinkedList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import com.camadeusa.entities.Holder;

public class Commands implements CommandExecutor {
	public static LinkedList<Holder> bases = new LinkedList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("pikachu")) {
				Holder ai = new Holder();
				ai.setEntity(player);
				ai.setVisible(false);
				ai.setLoc(player.getLocation());
				ai.setNumberOfNegativeSlimes(1);
				ai.setSmall(true);
				ai.spawn();
				bases.add(ai);
				
				Holder h1 = new Holder();
				h1.setVisible(false);
				h1.setLoc(player.getLocation());
				h1.setNumberOfNegativeSlimes(1);
				h1.setSmall(true);
				h1.spawn();
				((ArmorStand) h1.getEntity()).setHelmet(MCModelMain.getHead("Pikachu"));
				//bases.add(h1);
				//h1.getEntity().setCustomName("[LVL 1] Pikachu");
				//h1.getEntity().setCustomNameVisible(true);
				
				Holder h2 = new Holder();
				h2.setVisible(false);
				h2.setLoc(player.getLocation());
				h2.setNumberOfNegativeSlimes(0);
				h2.setSmall(true);
				h2.spawn();
				((ArmorStand) h2.getEntity()).setHelmet(new ItemStack(Material.GOLD_BLOCK, 1));
				((ArmorStand) h2.getEntity()).setHeadPose(new EulerAngle(0f, 0f, 0f));
				((ArmorStand) h2.getEntity()).getLocation().setYaw(((ArmorStand) h1.getEntity()).getLocation().getYaw());
				ai.getTopSlime().setPassenger(h1.getEntity());
				h1.getTopSlime().setPassenger(h2.getEntity());
				
			}
			if (cmd.getName().equalsIgnoreCase("Charmander")) {
				Holder ai = new Holder();
				ai.setEntity(player);
				ai.setVisible(false);
				ai.setLoc(player.getLocation());
				ai.setNumberOfNegativeSlimes(1);
				ai.setSmall(true);
				ai.spawn();
				bases.add(ai);
				
				Holder h1 = new Holder();
				h1.setVisible(false);
				h1.setLoc(player.getLocation());
				h1.setNumberOfNegativeSlimes(1);
				h1.setSmall(true);
				h1.spawn();
				((ArmorStand) h1.getEntity()).setHelmet(MCModelMain.getHead("Charmander"));
				//h1.getEntity().setCustomName("[LVL 1] Charmander");
				//h1.getEntity().setCustomNameVisible(true);
								
				bases.add(h1);
				
				Holder h2 = new Holder();
				h2.setVisible(false);
				h2.setLoc(player.getLocation());
				h2.setNumberOfNegativeSlimes(0);
				h2.setSmall(true);
				h2.spawn();
				((ArmorStand) h2.getEntity()).setHelmet(new ItemStack(Material.RED_SANDSTONE, 1));
				((ArmorStand) h2.getEntity()).setHeadPose(new EulerAngle(0f, 0f, 0f));
				((ArmorStand) h2.getEntity()).getLocation().setYaw(((ArmorStand) h1.getEntity()).getLocation().getYaw());
				ai.getTopSlime().setPassenger(h1.getEntity());
				h1.getTopSlime().setPassenger(h2.getEntity());
				
			}
			if (cmd.getName().equalsIgnoreCase("Bulbasaur")) {
				Holder ai = new Holder();
				ai.setEntity(player);
				ai.setVisible(false);
				ai.setLoc(player.getLocation());
				ai.setNumberOfNegativeSlimes(1);
				ai.setSmall(true);
				ai.spawn();
				bases.add(ai);
				
				Holder h1 = new Holder();
				h1.setVisible(false);
				h1.setLoc(player.getLocation());
				h1.setNumberOfNegativeSlimes(1);
				h1.setSmall(true);
				h1.spawn();
				((ArmorStand) h1.getEntity()).setHelmet(new ItemStack(Material.LEAVES, 1));
				((ArmorStand) h1.getEntity()).setHeadPose(new EulerAngle(30f, ((ArmorStand) h1.getEntity()).getHeadPose().getY(), 0));
				bases.add(h1);
				//h1.getEntity().setCustomName("[LVL 1] Bulbasaur");
				//h1.getEntity().setCustomNameVisible(true);
				
				Holder h2 = new Holder();
				h2.setVisible(false);
				h2.setLoc(player.getLocation());
				h2.setNumberOfNegativeSlimes(0);
				h2.setSmall(true);
				h2.spawn();
				((ArmorStand) h2.getEntity()).setHelmet(MCModelMain.getHead("RenaRooRoo14"));
				((ArmorStand) h2.getEntity()).setHeadPose(new EulerAngle(0f, 0f, 0f));
				((ArmorStand) h2.getEntity()).getLocation().setYaw(((ArmorStand) h1.getEntity()).getLocation().getYaw());
				ai.getTopSlime().setPassenger(h1.getEntity());
				h1.getTopSlime().setPassenger(h2.getEntity());
				
			}
			if (cmd.getName().equalsIgnoreCase("Squirtle")) {
				Holder ai = new Holder();
				ai.setEntity(player);
				ai.setVisible(false);
				ai.setLoc(player.getLocation());
				ai.setNumberOfNegativeSlimes(1);
				ai.setSmall(true);
				ai.spawn();
				bases.add(ai);
				
				Holder h1 = new Holder();
				h1.setVisible(false);
				h1.setLoc(player.getLocation());
				h1.setNumberOfNegativeSlimes(1);
				h1.setSmall(true);
				h1.spawn();
				((ArmorStand) h1.getEntity()).setHelmet(MCModelMain.getHead("Xrays"));
				bases.add(h1);
				//h1.getEntity().setCustomName("[LVL 1] Squirtle");
				//h1.getEntity().setCustomNameVisible(true);

				
				Holder h2 = new Holder();
				h2.setVisible(false);
				h2.setLoc(player.getLocation());
				h2.setNumberOfNegativeSlimes(0);
				h2.setSmall(true);
				h2.spawn();
				((ArmorStand) h2.getEntity()).setHelmet(new ItemStack(Material.DIAMOND_BLOCK, 1));
				((ArmorStand) h2.getEntity()).setHeadPose(new EulerAngle(0f, 0f, 0f));
				((ArmorStand) h2.getEntity()).getLocation().setYaw(((ArmorStand) h1.getEntity()).getLocation().getYaw());
				ai.getTopSlime().setPassenger(h1.getEntity());
				h1.getTopSlime().setPassenger(h2.getEntity());
				
			}
			if (cmd.getName().equalsIgnoreCase("Stitch")) {
				Holder ai = new Holder();
				ai.setEntity(player);
				ai.setVisible(false);
				ai.setLoc(player.getLocation());
				ai.setNumberOfNegativeSlimes(1);
				ai.setSmall(true);
				ai.spawn();
				bases.add(ai);
				
				Holder h1 = new Holder();
				h1.setVisible(false);
				h1.setLoc(player.getLocation());
				h1.setNumberOfNegativeSlimes(1);
				h1.setSmall(true);
				h1.spawn();
				((ArmorStand) h1.getEntity()).setHelmet(MCModelMain.getHead("iiMatt52"));
				bases.add(h1);
				//h1.getEntity().setCustomName("[LVL 1] Squirtle");
				//h1.getEntity().setCustomNameVisible(true);

				
				Holder h2 = new Holder();
				h2.setVisible(false);
				h2.setLoc(player.getLocation());
				h2.setNumberOfNegativeSlimes(0);
				h2.setSmall(true);
				h2.spawn();
				((ArmorStand) h2.getEntity()).setHelmet(new ItemStack(Material.SEA_LANTERN, 1));
				((ArmorStand) h2.getEntity()).setHeadPose(new EulerAngle(0f, 0f, 0f));
				((ArmorStand) h2.getEntity()).getLocation().setYaw(((ArmorStand) h1.getEntity()).getLocation().getYaw());
				ai.getTopSlime().setPassenger(h1.getEntity());
				h1.getTopSlime().setPassenger(h2.getEntity());
				
			}
			
		}
		
		return false;
	}

}
