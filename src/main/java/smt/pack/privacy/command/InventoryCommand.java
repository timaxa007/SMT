package smt.pack.privacy.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import smt.pack.privacy.inventory.GuiID;
import smt.pack.privacy.SMTPrivacy;
import smt.pack.privacy.registry.InventoryData;
import smt.pack.privacy.registry.InventoryData.InventotyDummy;

public class InventoryCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "smt_inventory";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (args.length > 0) {
			EntityPlayer player = (EntityPlayer)sender;
			if (player != null) {
				InventoryData inventoty_data = InventoryData.createOrLoad(player.worldObj);

				if (args.length > 1) {

				}

				String type = args[0];
				String tag = args[1];

				if (type.equalsIgnoreCase("set") || type.equalsIgnoreCase("create")) {
					inventoty_data.setInventory(tag, new InventotyDummy(tag));
					sender.addChatMessage((new ChatComponentText("create InventotyDummy")));
				} else if (type.equalsIgnoreCase("get") || type.equalsIgnoreCase("give") || type.equalsIgnoreCase("open")) {
					if (inventoty_data.getInventoryMap().containsKey(tag)) {
						inventoty_data.temp = tag;
						//player.openContainer = new ();
						//send.packet to client
						SMTPrivacy.proxy.openGui(GuiID.INVENTORY, player);
					} else
						sender.addChatMessage((new ChatComponentText("not open Gui InventotyDummy")));
				} else if (type.equalsIgnoreCase("remove")) {
					inventoty_data.removeInventory(tag);
					sender.addChatMessage((new ChatComponentText("remove InventotyDummy")));
				} else ;
			}
		} else {
			sender.addChatMessage((new ChatComponentText("Help?")));
		}
	}

}
