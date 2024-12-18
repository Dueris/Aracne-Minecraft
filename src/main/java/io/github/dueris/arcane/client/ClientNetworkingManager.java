package io.github.dueris.arcane.client;

import io.github.dueris.arcane.packet.payload.KeybindPressedPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.chat.Component;

public class ClientNetworkingManager {

	public static void init() {
		ClientPlayNetworking.registerGlobalReceiver(KeybindPressedPayload.ID, (payload, context) -> {
			context.client().execute(() -> {
				context.player().displayClientMessage(Component.literal("Received confirm signal from server"), false);
			});
		});
	}
}
