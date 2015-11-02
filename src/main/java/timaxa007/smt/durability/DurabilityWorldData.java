package timaxa007.smt.durability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

import java.util.HashMap;
import java.util.Map;

public class DurabilityWorldData extends WorldSavedData {

    private static final String ID = "DURABILITY";
    private Map<ChunkCoordinates, Integer> durability = new HashMap<>();

    public DurabilityWorldData(String mapName) {
        super(mapName);
    }

    public int getDurability(ChunkCoordinates coordinates) {
        Object durabilityObj = durability.get(coordinates);
        return durabilityObj == null ? 0 : (Integer) durabilityObj;
    }

    public void setDurability(ChunkCoordinates coordinates, Integer durability1) {
        if(durability1 <= 0) durability.remove(coordinates);
        else durability.put(coordinates, durability1);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        if(!tag.hasKey("blocks")) return;
        NBTTagList blocks = tag.getTagList("blocks", 10);
        for(int i = 0; i < blocks.tagCount(); i++) {
            NBTTagCompound block = blocks.getCompoundTagAt(i);
            ChunkCoordinates coordinates = new ChunkCoordinates(
                    block.getInteger("x"), block.getInteger("y"), block.getInteger("z"));
            durability.put(coordinates, block.getInteger("durability"));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        NBTTagList blocks = new NBTTagList();
        for(Map.Entry<ChunkCoordinates, Integer> entry : durability.entrySet()) {
            NBTTagCompound block = new NBTTagCompound();
            ChunkCoordinates coordinates = entry.getKey();
            block.setInteger("x", coordinates.posX);
            block.setInteger("y", coordinates.posY);
            block.setInteger("z", coordinates.posZ);
            block.setInteger("durability", entry.getValue());
            blocks.appendTag(block);
        }
        tag.setTag("blocks", blocks);
    }

    public static DurabilityWorldData createOrLoad(World world) {
        DurabilityWorldData data = (DurabilityWorldData) world.loadItemData(DurabilityWorldData.class, ID);
        if(data == null) world.setItemData(ID, data = new DurabilityWorldData(ID));
        return data;
    }

}
