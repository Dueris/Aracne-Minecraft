package io.github.dueris.arcane.client;

import io.github.dueris.arcane.ArcaneClient;
import io.github.dueris.arcane.packet.payload.KeybindPressedPayload;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class ClientKeybindingManager {

	public static void registerClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (ArcaneClient.INSTANCE.getOpenMenuKeybind().isDown()) {
				client.player.displayClientMessage(Component.literal("I pressed a fucking keybind"), false);
				ClientPlayNetworking.send(new KeybindPressedPayload(ResourceLocation.fromNamespaceAndPath("arcane", "open_menu")));
				ArcaneClient.INSTANCE.getOpenMenuKeybind().setDown(false);
				break;
			}
		});
	}
}
