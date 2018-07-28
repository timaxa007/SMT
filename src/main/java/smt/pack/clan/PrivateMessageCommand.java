package smt.pack.clan;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.clan.packet.MessageOpenGuiPrivateMessage;

public class PrivateMessageCommand extends CommandBase {

	public String getCommandName() {
		return "pm";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "";
	}

	public void processCommand(ICommandSender cs, String[] args) {
		//System.out.println("PrivateMessageCommand");
		if (args.length < 1) {
			if (cs instanceof EntityPlayerMP)
				SMTClan.network.sendTo(new MessageOpenGuiPrivateMessage(), (EntityPlayerMP)cs);
		}
	}

}
