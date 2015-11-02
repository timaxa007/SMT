package timaxa007.smt.durability;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import timaxa007.smt.core.network.IPacket;

/**
 * Simple client-side packet, plays block break effects on client-side
 * Used for playing break effects when durability expires
 * @author Dragon2488
 */
public class PacketBlockBreakEffects implements IPacket {

    /**
     * Info fields, since network system automatically
     * serialize and deserialize packet, there should be
     * only serializable objects and primitives
     */
    private int blockX, blockY, blockZ, id, meta;

    /**
     * Constructs new packet with given params
     * @param blockX destroyed block x position
     * @param blockY destroyed block y position
     * @param blockZ destroyed block z position
     * @param block destroyed block type
     * @param meta destroyed block metadata
     */
    public PacketBlockBreakEffects(int blockX, int blockY, int blockZ, Block block, int meta) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.blockZ = blockZ;
        this.id = Block.getIdFromBlock(block);
        this.meta = meta;
    }

    /**
     * Executes effects on client-side only
     * @param side side, which is processed
     */
    @Override
    public void execute(Side side) {
        if(side.isClient()) {
            Block block = Block.getBlockById(id);
            Minecraft.getMinecraft().effectRenderer.addBlockDestroyEffects(blockX, blockY, blockZ, block, meta);
            Minecraft.getMinecraft().theWorld.playSound(blockX + 0.5, blockY + 0.5, blockZ + 0.5, block.stepSound.getBreakSound(), 1F, 1F, false);
        }
    }

}
