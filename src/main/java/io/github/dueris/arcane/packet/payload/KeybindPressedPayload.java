package io.github.dueris.arcane.packet.payload;

import io.github.dueris.arcane.packet.NetworkingConstants;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record KeybindPressedPayload(ResourceLocation identifier) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<KeybindPressedPayload> ID = new CustomPacketPayload.Type<>(NetworkingConstants.KEY_PRESSED);
	public static final StreamCodec<RegistryFriendlyByteBuf, KeybindPressedPayload> CODEC = StreamCodec.composite(ResourceLocation.STREAM_CODEC, KeybindPressedPayload::identifier, KeybindPressedPayload::new);

	@Override
	public @NotNull Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
