package com.camadeusa.compatibility.entity.v1_8;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;

import com.camadeusa.compatibility.entity.VersionHandler;

import net.minecraft.server.v1_8_R3.EntityLiving;

public class VersionHandler_v1_8_R3 implements VersionHandler{

	@Override
	public void setRotation(Entity entity, float yaw, float pitch) {
	    EntityLiving nmsEntity = (EntityLiving) ((CraftEntity) entity).getHandle();
	    nmsEntity.pitch = pitch;
	    nmsEntity.lastPitch = pitch;
	    nmsEntity.yaw = yaw;
	    nmsEntity.lastYaw = yaw;
	    nmsEntity.aI = yaw;
	    nmsEntity.aJ = yaw;
	    nmsEntity.aK = yaw;
	    nmsEntity.aL = yaw;
	}

}
