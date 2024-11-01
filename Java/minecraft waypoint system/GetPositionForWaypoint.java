/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside fr.eriniumgroup.shopmod as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package fr.eriniumgroup.shopmod;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GetPositionForWaypoint {
	public static ArrayList<Object> GetPositionForWaypoint(int OverlayWidth, int OverlayHeight, double pX, double pY, double pZ, double pYRot, double pXRot, double posX, double posY, double posZ){
		ArrayList<Object> array = new ArrayList<Object>();
		// Camera settings (player position)
		double playerX = pX;
		double playerY = pY;
		double playerZ = pZ;
		double playerYaw = pYRot;  // Yaw en degrés
		double playerPitch = pXRot; // Pitch en degrés

		// Waypoint position
		double waypointX = posX;
		double waypointY = posY;
		double waypointZ = posZ;

		// Calculate direction
		double dx = waypointX - playerX;
		double dy = waypointY - playerY;
		double dz = waypointZ - playerZ;

		// Convert angles to radians
		double yawRad = Math.toRadians(playerYaw);
		double pitchRad = Math.toRadians(playerPitch);

		//Rotation along the Y axis (yaw)
		double cosYaw = Math.cos(yawRad);
		double sinYaw = Math.sin(yawRad);
		double xz = dx * -cosYaw - dz * sinYaw;
		double z1 = dx * -sinYaw + dz * cosYaw;

		// Rotation along the X axis (pitch)
		double cosPitch = Math.cos(pitchRad);
		double sinPitch = Math.sin(pitchRad);
		double y1 = dy * cosPitch + z1 * sinPitch;
		double zScreen = -dy * sinPitch + z1 * cosPitch;

		// Orthographic projection
		double scaleX = OverlayWidth / 2.0;
		double scaleY = OverlayHeight / 2.0;
		double screenX = (xz / zScreen) * scaleX + (OverlayWidth / 2.0);
		double screenY = - (y1 / zScreen) * scaleY + (OverlayHeight / 2.0);

		if (zScreen <= 0) {
			// The waypoint is behind the camera or too close
			// You can choose not to draw the point in this case
			screenX = -100;  // Hors écran
			screenY = -100;  // Hors écran
		}

		// Check if the point is in the midddle (the direction the player go and see)
		boolean isLookingAtWaypoint = (screenX >= scaleX - 20 && screenX <= scaleX + 20) && (screenY >= scaleY - 20 && screenY <= scaleY + 20);

		array.clear();
		array.add(isLookingAtWaypoint);
		array.add((int) screenX);
		array.add((int) screenY);
		return array;
	}

	public static int ARGBToInt(int a, int r, int g, int b){
		return (a << 24) | (r << 16) | (g << 8) | b;
	}
}
