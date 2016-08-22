package com.camadeusa.entities;

import java.util.LinkedList;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.camadeusa.MCModelMain;

public class Holder {
	Entity e = null;
	Entity top = null;
	int numberOfNegativeSlimes = 0;
	Location loc = null;
	boolean arms = true;
	boolean baseplate = false;
	boolean small = false;
	boolean visible = false;
	boolean ai = false;
	LinkedList<Entity> slimes = new LinkedList<>();
	
	public LinkedList<Entity> getSlimes() {
		return slimes;
	}

	public void setSlimes(LinkedList<Entity> slimes) {
		this.slimes = slimes;
	}

	public Entity getEntity() {
		return e;
	}
	
	public void setEntity(Entity e) {
		this.e = e;
	}
	
	public Entity getTopSlime() {
		return top;
	}
	
	public int getNumberOfNegativeSlimes() {
		return numberOfNegativeSlimes;
	}
	
	public void setNumberOfNegativeSlimes(int i) {
		this.numberOfNegativeSlimes = i;
	}
	
	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public boolean isArms() {
		return arms;
	}

	public void setArms(boolean arms) {
		this.arms = arms;
	}

	public boolean isBaseplate() {
		return baseplate;
	}

	public void setBaseplate(boolean baseplate) {
		this.baseplate = baseplate;
	}

	public boolean isSmall() {
		return small;
	}

	public void setSmall(boolean small) {
		this.small = small;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isAi() {
		return ai;
	}

	public void setAi(boolean ai) {
		this.ai = ai;
	}

	public Entity spawn() {
		Entity entityOne = null;
		Entity lastEntity = null;
		if (e == null) {
		entityOne = (ArmorStand) getLoc().getWorld().spawnEntity(getLoc(), EntityType.ARMOR_STAND);
		((ArmorStand) entityOne).setArms(arms);
		((ArmorStand) entityOne).setBasePlate(baseplate);
		((ArmorStand) entityOne).setSmall(small);
		((ArmorStand) entityOne).setVisible(visible);
		//((ArmorStand) entityOne).setAI(isAi());
		((ArmorStand) entityOne).setMarker(true);
		lastEntity = entityOne;
		} else if (e instanceof Player) {
			entityOne = (Wolf) getLoc().getWorld().spawnEntity(getLoc(), EntityType.WOLF);
			((Wolf) entityOne).setBaby();
			((Wolf) entityOne).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
			//((Wolf) entityOne).setAI(isAi());
			lastEntity = entityOne;
		}
		if (getNumberOfNegativeSlimes() > 0) {
			for (int i = 0; i < getNumberOfNegativeSlimes(); i++) {
				Slime slime = (Slime) getLoc().getWorld().spawnEntity(getLoc(), EntityType.SLIME);
				slime.setSize(-1);
				slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
				//slime.setCollidable(false);
				//slime.setInvulnerable(true);
				//slime.setAI(false);
				
				lastEntity.setPassenger(slime);
				lastEntity = slime;
				this.slimes.add(slime);
			}
			this.top = lastEntity;
		}
		this.e = entityOne;
		return entityOne;
	}

}
