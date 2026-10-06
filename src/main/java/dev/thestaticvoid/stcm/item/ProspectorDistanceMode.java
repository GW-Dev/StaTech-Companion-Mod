package dev.thestaticvoid.stcm.item;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum ProspectorDistanceMode implements StringRepresentable {
    XYZ("xyz"),
    XZ("xz");

    private final String id;
    ProspectorDistanceMode(String id){
        this.id = id;
    }

    @Override
    public String getSerializedName() {
        return this.id;
    }
    public static final Codec<ProspectorDistanceMode> CODEC = StringRepresentable.fromEnum(ProspectorDistanceMode::values);

}