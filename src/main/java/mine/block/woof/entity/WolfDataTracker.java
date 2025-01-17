package mine.block.woof.entity;

import mine.block.woof.SkinType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.network.PacketByteBuf;

public class WolfDataTracker implements TrackedDataHandler<SkinType> {
    public static final WolfDataTracker SKIN_TYPE_TRACKER_ENUM = new WolfDataTracker();
    public static TrackedData<SkinType> WOLF_SKIN_TYPE = DataTracker.registerData(WolfEntity.class, SKIN_TYPE_TRACKER_ENUM);

    @Override
    public void write(PacketByteBuf buf, SkinType value) {
        buf.writeEnumConstant(value);
    }

    @Override
    public SkinType read(PacketByteBuf buf) {
        return buf.readEnumConstant(SkinType.class);
    }

    @Override
    public SkinType copy(SkinType value) {
        return SkinType.valueOf(value.name());
    }
}
