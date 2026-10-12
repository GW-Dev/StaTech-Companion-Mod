package dev.thestaticvoid.stcm;

import com.mojang.logging.LogUtils;
import dev.thestaticvoid.stcm.block.STCMBlock;
import dev.thestaticvoid.stcm.block.entity.STCMBlockEntity;
import dev.thestaticvoid.stcm.entity.STCMEntity;
import dev.thestaticvoid.stcm.guideme.STCMGuide;
import dev.thestaticvoid.stcm.item.STCMCreativeModeTabs;
import dev.thestaticvoid.stcm.item.STCMItem;
import dev.thestaticvoid.stcm.network.STCMPacket;
import dev.thestaticvoid.stcm.screen.STCMMenuTypes;
import dev.thestaticvoid.stcm.world.STCMWorld;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import top.theillusivec4.curios.api.*;
import top.theillusivec4.curios.api.type.capability.*;
import org.slf4j.Logger;

@Mod(STCM.ID)
public class STCM {
    public static final String ID = "stcm";
    public static final Logger LOGGER = LogUtils.getLogger();

    public STCM(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, STCMConfig.CONFIG_SPEC);

        STCMGuide.init();

        STCMBlock.init(modEventBus);
        STCMBlockEntity.init(modEventBus);
        STCMComponents.init(modEventBus);
        STCMItem.init(modEventBus);
        STCMCreativeModeTabs.init(modEventBus);

        STCMEntity.init(modEventBus);
        STCMMenuTypes.init(modEventBus);
        STCMWorld.init(modEventBus);

        modEventBus.addListener(RegisterPayloadHandlersEvent.class, STCMPacket::init);
        modEventBus.addListener(this::registerCapabilities)
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }

    public void registerCapabilities(final RegisterCapabilitiesEvent evt) {
        evt.registerItem(
            CuriosCapability.ITEM,
            (stack, context) -> new ICurio() {

                @Override
                public ItemStack getStack() {
                  return stack;
                }

                @Override
                public void curioTick(SlotContext slotContext) {
                  // ticking logic here
            },
            STCM.ITEM);
}
