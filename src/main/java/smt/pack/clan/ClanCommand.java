package smt.pack.clan;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import smt.pack.clan.Clan.ClanGroup;
import smt.pack.clan.packet.MessageOpenGuiClan;

public class ClanCommand extends CommandBase {

	public String getCommandName() {
		return "clan";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "";
	}

	public void processCommand(ICommandSender cs, String[] args) {
		//System.out.println("ClanCommand");
		if (args.length < 1) {
			if (cs instanceof EntityPlayerMP)
				SMTClan.network.sendTo(new MessageOpenGuiClan(), (EntityPlayerMP)cs);
		}
		else {
			if (args.length >= 1) {
				if (args[0].toLowerCase().equals("help") || args[0].toLowerCase().equals("?")) {
					cs.addChatMessage((new ChatComponentText("/clan [create|remove|addMember|addCommander|get] [name clan|username]")));
				}
				else if (args[0].toLowerCase().equals("gui")) {
					if (cs instanceof EntityPlayerMP)
						SMTClan.network.sendTo(new MessageOpenGuiClan(), (EntityPlayerMP)cs);
				}
				else if (args[0].toLowerCase().equals("get")) {
					if (args.length >= 2) {
						Clan.ClanGroup cg = Clan.INSTANCE.getClanGroup(args[1]);
						if (cg != null)
							cs.addChatMessage(new ChatComponentText("Clan " + cg.getClanName() + "."));
						else
							cs.addChatMessage(new ChatComponentText("Not find Clan."));
					} else {
						if (Clan.INSTANCE.getClans() != null && !Clan.INSTANCE.getClans().isEmpty()) {
							for (ClanGroup clan_group : Clan.INSTANCE.getClans()) {
								if (clan_group != null) {
									String stg = "Clan \"" + clan_group.getClanName() + "\"";
									if (clan_group.getCommander() != null)
										stg += ", Commander \"" + clan_group.getCommander().getName() + "\"";
									else
										stg += ", No Commander";
									cs.addChatMessage((new ChatComponentText(stg + ".")));
								}
							}
						} else
							cs.addChatMessage((new ChatComponentText("Not find Clans.")));
					}
				}
				else if (args[0].toLowerCase().equals("create") || args[0].toLowerCase().equals("add")) {
					if (args.length >= 2) {
						if (cs instanceof EntityPlayerMP && Clan.INSTANCE.createClan(args[1], (EntityPlayerMP)cs)) {
							cs.addChatMessage((new ChatComponentText("Create Clan \"" + args[1] + "\".")));
						} else
							cs.addChatMessage((new ChatComponentText("Not Create Clan \"" + args[1] + "\".")));
					} else {

					}
				}
				else if (args[0].toLowerCase().equals("remove") || args[0].toLowerCase().equals("delete")) {
					if (args.length >= 2) {
						if (cs instanceof EntityPlayerMP && Clan.INSTANCE.removeClan(args[1], (EntityPlayerMP)cs)) {
							cs.addChatMessage((new ChatComponentText("Remove Clan \"" + args[1] + "\".")));
						} else {
							cs.addChatMessage((new ChatComponentText("Not Remove Clan \"" + args[1] + "\".")));
						}
					} else {

					}
				}
				else if (args[0].toLowerCase().equals("save")) {
					Clan.INSTANCE.save();
				}
				else if (args[0].toLowerCase().equals("reload") || args[0].toLowerCase().equals("restart")) {
					Clan.INSTANCE.reload();
				}
				else if (args[0].toLowerCase().equals("load")) {
					Clan.INSTANCE.load();
				}

			}
		}
		/*
		if (args.length < 1) {

		} else {
			String username = args[0];

			int id;
			try {
				id = Integer.parseInt(args[1]);
				if (id <= 0 || id >= '\ua7f8' || Item.getItemById(id) == null) {
					throw new Exception();
				}
			} catch (Exception var12) {
				cs.addChatMessage((new ChatComponentText("Неверный id!")));
				return;
			}

			int count = 1;
			int metadata = 0;
			if (args.length >= 3) {
				try {
					count = Integer.parseInt(args[2]);
					if (count < 1 || count > 64) {
						throw new Exception();
					}
				} catch (Exception var11) {
					cs.addChatMessage((new ChatComponentText("Неверное количество!")));
					return;
				}
			}

			if (args.length >= 4) {
				try {
					metadata = Integer.parseInt(args[3]);
				} catch (NumberFormatException var10) {
					cs.addChatMessage((new ChatComponentText("Неверный durability!")));
					return;
				}
			}

			ItemStack stack = new ItemStack(Item.getItemById(id), count, metadata);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("no_drop", 1);
			stack.setTagCompound(tag);
			World world = null;
			//EntityPlayerMP player = (EntityPlayerMP) world.getPlayerEntityByName(username);
			EntityPlayerMP entityplayermp = getPlayer(cs, args[0]);
			//EntityPlayerMP p = super.get(username);
			if (entityplayermp == null) {
				entityplayermp.addChatMessage((new ChatComponentText("Игрок оффлайн!")));
			} else {
			entityplayermp.inventory.addItemStackToInventory(stack);
			//}
		}
		 */
	}

}