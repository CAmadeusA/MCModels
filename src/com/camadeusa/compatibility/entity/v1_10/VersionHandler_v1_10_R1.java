package com.camadeusa.compatibility.entity.v1_10;

import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

import com.camadeusa.compatibility.entity.VersionHandler;

import net.minecraft.server.v1_10_R1.EntityLiving;

public class VersionHandler_v1_10_R1 implements VersionHandler {

	@Override
	public void setRotation(Entity entity, float yaw, float pitch) {
	    EntityLiving nmsEntity = (EntityLiving) ((CraftEntity) entity).getHandle();
	    nmsEntity.pitch = pitch;
	    nmsEntity.lastPitch = pitch;
	    nmsEntity.yaw = yaw;
	    nmsEntity.lastYaw = yaw;
	    nmsEntity.aQ = yaw;
	    nmsEntity.aR = yaw;
	    nmsEntity.aO = yaw;
	    nmsEntity.aP = yaw;
	}

}
