package io.github.dueris.arcane.packet;

import io.github.dueris.arcane.packet.payload.KeybindPressedPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class CommonNetworkingManager {

	/**
	 * Init of the serverside(or common) networking manager
	 */
	public static void init() {
		// Register payloads
		registerPayloads();
		// Keybinding trigger management
		ServerPlayNetworking.registerGlobalReceiver(KeybindPressedPayload.ID, (payload, context) -> {
			System.out.println("Received press packet, resending to client to confirm.");
			ServerPlayNetworking.send(context.player(), payload);
		});
	}

	private static void registerPayloads() {
		PayloadTypeRegistry.playS2C().register(KeybindPressedPayload.ID, KeybindPressedPayload.CODEC);
		PayloadTypeRegistry.playC2S().register(KeybindPressedPayload.ID, KeybindPressedPayload.CODEC);
	}
}
