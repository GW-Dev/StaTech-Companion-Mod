package dev.thestaticvoid.stcm.item;

import dev.thestaticvoid.stcm.STCM;
import dev.thestaticvoid.stcm.item.curios.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class STCMItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(STCM.ID);

    public static final DeferredItem<Item> ANGEL_RING = ITEMS.registerSimpleItem(
            "angel_ring", new Item.Properties().component(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ItemAttributeModifiers.builder()
                        .add(
                                NeoForgeMod.CREATIVE_FLIGHT,
                                new AttributeModifier(
                                        ResourceLocation.fromNamespaceAndPath(STCM.ID, "creative_flight"),
                                        1.0,
                                        AttributeModifier.Operation.ADD_VALUE
                                ),
                                EquipmentSlotGroup.ANY
                        )
                        .build()
                ).stacksTo(1).rarity(Rarity.EPIC)
    );

    public static final DeferredItem<Item> FIREPROOF_RING = ITEMS.register(
            "fireproof_ring", () -> new FireproofRing(new Item.Properties().rarity(Rarity.EPIC).fireResistant().stacksTo(1))
    );

    public static final DeferredItem<Item> PROSPECTOR_PICK = ITEMS.register(
            "prospector_pick", () -> new ProspectorPick(new Item.Properties().durability(128).stacksTo(1))
    );

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
