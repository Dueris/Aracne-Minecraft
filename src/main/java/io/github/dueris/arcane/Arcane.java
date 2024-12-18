package io.github.dueris.arcane;

import io.github.dueris.arcane.packet.CommonNetworkingManager;
import net.fabricmc.api.ModInitializer;

public class Arcane implements ModInitializer {

	@Override
	public void onInitialize() {
		CommonNetworkingManager.init();
	}
}
