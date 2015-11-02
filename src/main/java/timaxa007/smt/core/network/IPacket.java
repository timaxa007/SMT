package timaxa007.smt.core.network;

import cpw.mods.fml.relauncher.Side;
import java.io.Serializable;

/**
 * Packet class, need to be implemented
 * by all available packages
 *
 * Packets are automatically serialize deserialize
 * objects they have. Declared fields MUST implement
 * Serializable or be a primitives
 *
 * @see java.io.Serializable
 * @author Dragon2488
 */
public interface IPacket extends Serializable {

    /**
     * Executes packet on given side
     * If side is invalid, packet should't be executed
     *
     * @param side side, which is processed
     * @see cpw.mods.fml.relauncher.Side
     */
    public void execute(Side side);

}
