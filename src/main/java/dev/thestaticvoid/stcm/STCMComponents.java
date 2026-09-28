package dev.thestaticvoid.stcm;

import dev.thestaticvoid.stcm.item.ProspectorDistanceMode;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class STCMComponents {
    private static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, STCM.ID);

    public static final Supplier<DataComponentType<ProspectorDistanceMode>> PROSPECTOR_DISTANCE_MODE =
            COMPONENTS.registerComponentType(
                    "prospector_distance_mode",
                    builder -> builder.persistent(ProspectorDistanceMode.CODEC)
            );
    public static void init(IEventBus modEventBus){
        COMPONENTS.register(modEventBus);
    }
}
