package io.github.dueris.arcane;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.dueris.arcane.client.ClientKeybindingManager;
import io.github.dueris.arcane.client.ClientNetworkingManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArcaneClient implements ClientModInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArcaneClient.class);
	public static ArcaneClient INSTANCE;
	private KeyMapping openMenuKeybind;

	public ArcaneClient() {
		INSTANCE = this;
	}

	@Override
	public void onInitializeClient() {
		openMenuKeybind = new KeyMapping("key.arcane.open_menu", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, "category.arcane");
		KeyBindingHelper.registerKeyBinding(openMenuKeybind);
		ClientKeybindingManager.registerClient();
		ClientNetworkingManager.init();
	}

	public KeyMapping getOpenMenuKeybind() {
		return openMenuKeybind;
	}
}
