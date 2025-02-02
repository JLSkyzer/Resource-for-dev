/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside fr.eriniumgroup.eriniumroleplay as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package fr.eriniumgroup.eriniumroleplay;

import fr.eriniumgroup.eriniumroleplay.network.BankerCreateAccountButtonMessage;
import fr.eriniumgroup.eriniumroleplay.procedures.BankerCreateAccountBtnProcedure;
import fr.eriniumgroup.eriniumroleplay.procedures.OpenAccountManageProcedure;
import fr.eriniumgroup.eriniumroleplay.procedures.ReturnAccountListOfPlayerProcedure;
import fr.eriniumgroup.eriniumroleplay.procedures.TempProcedure;
import fr.eriniumgroup.eriniumroleplay.world.inventory.BankerAccountManagerMenu;
import fr.eriniumgroup.eriniumroleplay.world.inventory.BankerCreateAccountMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BankerAccountManagerMessage {
	private final int buttonID, x, y, z;
	private String accountID;

	public BankerAccountManagerMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.accountID = buffer.readUtf();
	}

	public BankerAccountManagerMessage(int buttonID, int x, int y, int z, String accountID) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.accountID = accountID;
	}

	public static void buffer(BankerAccountManagerMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeUtf(message.accountID);
	}

	public static void handler(BankerAccountManagerMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			String accountID = message.accountID;
			handleButtonAction(entity, buttonID, x, y, z, accountID);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, String accountID) {
		Level world = entity.level;
		HashMap guistate = BankerAccountManagerMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenAccountManageProcedure.execute(world, x, y, z, entity, accountID);
			//BankerCreateAccountBtnProcedure.execute(world, entity, guistate);
		} else if (buttonID == 1) {
			System.out.println("Chargement de la Map");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EriniumRoleplayMod.addNetworkMessage(BankerAccountManagerMessage.class, BankerAccountManagerMessage::buffer, BankerAccountManagerMessage::new, BankerAccountManagerMessage::handler);
	}

	public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
		int size = buffer.readInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			String key = buffer.readUtf();
			String value = buffer.readUtf();
			map.put(key, value);
		}
		return map;
	}
}
