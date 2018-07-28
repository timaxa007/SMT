package smt.pack.clan;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StringUtils;
import net.minecraftforge.common.util.Constants.NBT;

import com.google.common.io.Files;
import com.mojang.authlib.GameProfile;

public class Clan extends smt.pack.common.util.FileNBT {

	@Nonnull public static final Clan INSTANCE = new Clan();
	public static final String TAG = "clan";

	final ArrayList<ClanGroup> groups = new ArrayList<ClanGroup>();

	public Clan() {
		super(getDir(), TAG);
	}

	public void load() {
		System.out.println("\"" + TAG + "\" Loading.");
		loadData();
		System.out.println("\"" + TAG + "\" Loaded.");
	}

	public void save() {
		System.out.println("\"" + TAG + "\" Saving.");
		saveData();
		System.out.println("\"" + TAG + "\" Saved.");
	}

	public void reload() {
		System.out.println("\"" + TAG + "\" Reloading.");
		saveData();
		loadData();
		System.out.println("\"" + TAG + "\" Reloaded.");
	}

	public boolean createClan(@Nonnull String clan_name, EntityPlayer player) {
		for (ClanGroup clan_group : groups) {
			if (clan_group.getClanName().equals(clan_name))
				return false;
		}
		ClanGroup clan_group = new ClanGroup(clan_name);
		if (player != null) {
			clan_group.setCommander(player.getGameProfile());
			clan_group.getMembers().add(player.getGameProfile());
		}
		groups.add(clan_group);
		return true;
	}

	public boolean removeClan(@Nonnull String clan_name, EntityPlayer player) {
		if (groups != null && !groups.isEmpty())
			for (int i = 0; i < groups.size(); ++i) {
				ClanGroup clan_group = groups.get(i);
				if (clan_group.getClanName().equals(clan_name)) {
					if (player.getGameProfile().equals(clan_group.getCommander())) {
						groups.remove(clan_group);
						return true;
					} else {
						return false;
					}
				}
			}
		return false;
	}

	public boolean setCommanderToClan(@Nonnull String clan_name, EntityPlayer player) {
		for (ClanGroup clan_group : groups) {
			if (clan_group.getClanName().equals(clan_name)) {
				clan_group.setCommander(player.getGameProfile());
				return true;
			}
		}
		return false;
	}

	public boolean addMemberToClan(@Nonnull String clan_name, EntityPlayer player) {
		for (ClanGroup clan_group : groups) {
			if (clan_group.getClanName().equals(clan_name)) {
				for (GameProfile game_prodile : clan_group.getMembers()) {
					if (game_prodile.equals(player.getGameProfile()))
						return false;
				}
				clan_group.getMembers().add(player.getGameProfile());
				return true;
			}
		}
		return false;
	}

	public ClanGroup getClanGroup(@Nonnull String clan_name) {
		for (ClanGroup clan_group : groups) {
			if (clan_group.getClanName().equals(clan_name))
				return clan_group;
		}
		return null;
	}

	public ArrayList<ClanGroup> getClans() {
		return groups;
	}

	public void report(String addText) {
		File file = new File(getDirectory(), "report-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + ".txt");
		if (file.getParentFile() != null) file.getParentFile().mkdirs();
		//MinecraftServer.getServer().getCommandManager().executeCommand(p_71556_1_, p_71556_2_)
		//FileWriter filewriter;
		//try {
		//filewriter = new FileWriter(file);
		//filewriter.write(stringbuilder.toString());
		//filewriter.close();
		//} catch (IOException e) {e.printStackTrace();}

		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append("---- Clan Report ----");
		stringbuilder.append("\n\n");
		stringbuilder.append("Time: ");
		stringbuilder.append((new SimpleDateFormat()).format(new Date()));
		stringbuilder.append("\n");
		stringbuilder.append("Description: ");
		stringbuilder.append("Test Report.");
		stringbuilder.append("\n\n");
		if (addText != null) {
			stringbuilder.append(addText);
			stringbuilder.append("\n");

		}

		for (int i = 0; i < 87; ++i) stringbuilder.append("-");

		stringbuilder.append("\n\n");

		try {
			Files.write(stringbuilder.toString(), file, Charset.forName("UTF-8"));
		} catch (IOException e) {e.printStackTrace();}
	}

	public static File getDir() {
		/*
		return cpw.mods.fml.common.FMLCommonHandler.instance().getSide().isClient() ?
				new File(net.minecraft.client.Minecraft.getMinecraft().mcDataDir, "clan") :
					new File(MinecraftServer.getServer().getFolderName(), "clan");
		 */
		//theWorld.getSaveHandler().getWorldDirectory()
		/*
		return cpw.mods.fml.common.FMLCommonHandler.instance().getSide().isClient() ?
				new File(net.minecraft.client.Minecraft.getMinecraft().getIntegratedServer().worldServers[0].getSaveHandler().getWorldDirectory(), "clan1") :
					new File(MinecraftServer.getServer().worldServers[0].getSaveHandler().getWorldDirectory(), "clan1");
		 */
		return new File(MinecraftServer.getServer().worldServers[0].getSaveHandler().getWorldDirectory(), "clan");
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		if (nbt.hasKey("Groups", NBT.TAG_LIST)) {
			groups.clear();
			NBTTagList nbttaglist = nbt.getTagList("Groups", NBT.TAG_COMPOUND);
			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				ClanGroup clan_group = new ClanGroup(nbttagcompound1.getString("ClanName"));
				if (nbttagcompound1.hasKey("ClanDesk", NBT.TAG_STRING))
					clan_group.setClanDescription(nbttagcompound1.getString("ClanDesk"));
				if (nbttagcompound1.hasKey("Access", NBT.TAG_BYTE)) {
					for (Access access : Access.values()) {
						if (access.ordinal() == nbttagcompound1.getByte("Access")) {
							clan_group.setAccess(access);
							break;
						}
					}
				}
				if (nbttagcompound1.hasKey("Commander", NBT.TAG_COMPOUND)) {
					GameProfile game_prodile = NBTUtil.func_152459_a(nbttagcompound1.getCompoundTag("Commander"));
					clan_group.setCommander(game_prodile);
				}
				if (nbttagcompound1.hasKey("DeputyCommander", NBT.TAG_COMPOUND)) {
					GameProfile game_prodile = NBTUtil.func_152459_a(nbttagcompound1.getCompoundTag("DeputyCommander"));
					clan_group.setDeputyCommander(game_prodile);
				}
				if (nbttagcompound1.hasKey("Members", NBT.TAG_LIST)) {
					NBTTagList nbttaglist2 = nbttagcompound1.getTagList("Members", NBT.TAG_COMPOUND);
					for (int i2 = 0; i2 < nbttaglist2.tagCount(); ++i2) {
						NBTTagCompound nbttagcompound2 = nbttaglist2.getCompoundTagAt(i);
						GameProfile game_prodile = NBTUtil.func_152459_a(nbttagcompound2);
						clan_group.getMembers().add(game_prodile);
					}
				}
				if (nbttagcompound1.hasKey("Symbol", NBT.TAG_COMPOUND))
					clan_group.setSymbol(ItemStack.loadItemStackFromNBT(nbttagcompound1.getCompoundTag("Symbol")));
				clan_group.setPoints(nbttagcompound1.getInteger("Points"));
				groups.add(clan_group);
				//System.out.println(clan_group.getClanName());
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		if (groups != null && !groups.isEmpty())
			for (ClanGroup clan_group : groups) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				if (StringUtils.isNullOrEmpty(clan_group.getClanName())) continue;
				nbttagcompound1.setString("ClanName", clan_group.getClanName());
				if (!StringUtils.isNullOrEmpty(clan_group.getClanDescription()))
					nbttagcompound1.setString("ClanDesk", clan_group.getClanDescription());
				nbttagcompound1.setByte("Access", (byte)clan_group.getAccess().ordinal());

				if (clan_group.getCommander() != null) {
					NBTTagCompound nbttagcompound3 = new NBTTagCompound();
					NBTUtil.func_152460_a(nbttagcompound3, clan_group.getCommander());
					nbttagcompound1.setTag("Commander", nbttagcompound3);
				}
				if (clan_group.getDeputyCommander() != null) {
					NBTTagCompound nbttagcompound4 = new NBTTagCompound();
					NBTUtil.func_152460_a(nbttagcompound4, clan_group.getDeputyCommander());
					nbttagcompound1.setTag("DeputyCommander", nbttagcompound4);
				}
				if (clan_group.getMembers() != null && !clan_group.getMembers().isEmpty()) {
					NBTTagList nbttaglist2 = new NBTTagList();
					for (GameProfile game_profile : clan_group.getMembers()) {
						if (game_profile == null) continue;
						NBTTagCompound nbttagcompound2 = new NBTTagCompound();
						NBTUtil.func_152460_a(nbttagcompound2, game_profile);
						nbttaglist2.appendTag(nbttagcompound2);
					}
					nbttagcompound1.setTag("Members", nbttaglist2);
				}
				if (clan_group.getSymbol() != null) {
					NBTTagCompound nbttagcompound5 = new NBTTagCompound();
					clan_group.getSymbol().writeToNBT(nbttagcompound5);
					nbttagcompound1.setTag("Symbol", nbttagcompound5);
				}
				nbttagcompound1.setInteger("Points", clan_group.getPoints());
				nbttaglist.appendTag(nbttagcompound1);
			}
		nbt.setTag("Groups", nbttaglist);
	}

	public static class ClanGroup {

		@Nonnull	private String clan_name;
		@Nullable	private String clan_desk;
		@Nonnull	private Access access;
		@Nonnull	private GameProfile commander;
		@Nullable	private GameProfile deputyCommander;
		@Nonnull	private final ArrayList<GameProfile> members = new ArrayList<GameProfile>();
		@Nullable	private ItemStack symbol;
		private int points;

		//alliance
		//враждебность - hostility
		public ClanGroup(String clan_name) {
			this.clan_name = clan_name;
			access = Access.PUBLIC;
		}

		public ClanGroup setClanName(String clan_name) {
			this.clan_name = clan_name;
			return this;
		}

		public String getClanName() {
			return clan_name;
		}

		public ClanGroup setClanDescription(String clan_desk) {
			this.clan_desk = clan_desk;
			return this;
		}

		public String getClanDescription() {
			return clan_desk;
		}

		public ClanGroup setAccess(Access access) {
			this.access = access;
			return this;
		}

		public Access getAccess() {
			return access;
		}

		public ClanGroup setCommander(GameProfile commander) {
			this.commander = commander;
			return this;
		}

		public GameProfile getCommander() {
			return commander;
		}

		public ClanGroup setDeputyCommander(GameProfile deputyCommander) {
			this.deputyCommander = deputyCommander;
			return this;
		}

		public GameProfile getDeputyCommander() {
			return deputyCommander;
		}

		public ArrayList<GameProfile> getMembers() {
			return members;
		}

		public ClanGroup setSymbol(ItemStack symbol) {
			this.symbol = symbol;
			return this;
		}

		public ItemStack getSymbol() {
			return symbol;
		}

		public ClanGroup setPoints(int points) {
			this.points = points;
			return this;
		}

		public ClanGroup addPoints(int points) {
			this.points += points;
			return this;
		}

		public int getPoints() {
			return points;
		}

	}

	public enum Access {
		PUBLIC,
		PRIVATE;
	}

}
