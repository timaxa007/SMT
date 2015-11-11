package smt.core.network;

import cpw.mods.fml.relauncher.Side;
import smt.core.SMTContainer;

/**
 * Simple dump packet, it's only report about network error
 * @see smt.core.network.NetworkManager
 * @author Dragon2488
 */
public class DumpPacket implements IPacket {

	@Override
	public void execute(Side side) {
		SMTContainer.log.error("Executed dump packet! Network error is somewhere here...");
	}

}
