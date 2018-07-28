package smt.pack.clan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.server.MinecraftServer;

public class Clan2 {

	@Nonnull public static final Clan2 INSTANCE = new Clan2();
	@Nonnull public static final String TAG = "clan2";
	@Nonnull private final ArrayList<ClanGroup> clan_group = new ArrayList<ClanGroup>();

	public void load() {
		clan_group.clear();
		File file = new File(getDirectory(), "clan2.txt");
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String line;
				ClanGroup cg = null;
				while ((line = br.readLine()) != null) {
					if (line.length() > 0) {
						if ("ClanName:".equals(line) || "Members:".equals(line)) continue;
						if (cg == null) {
							cg = new ClanGroup(line);
						} else {
							cg.addMember(line);
						}
					} else {
						if (cg != null) {
							clan_group.add(cg);
							cg = null;
						}
					}
				}
				if (cg != null) clan_group.add(cg);
				br.close();
			}
			catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
		} else {
			try {file.createNewFile();}
			catch (IOException e) {e.printStackTrace();}
		}
	}

	public void save() {
		File file = new File(getDirectory(), "clan2.txt");
		if (file.getParentFile() != null) file.getParentFile().mkdirs();

		try {
			FileWriter writer = new FileWriter(file, false);
			if (!clan_group.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < clan_group.size(); ++j) {
					ClanGroup cg = clan_group.get(j);
					sb.append("ClanName:\n");
					sb.append(cg.getClanName());
					sb.append('\n');
					sb.append("Members:\n");
					if (!cg.getMembers().isEmpty())
						for (int k = 0; k < cg.getMembers().size(); ++k) {
							String member = cg.getMembers().get(k);
							sb.append(member);
							sb.append('\n');
						}
					sb.append('\n');
				}
				writer.write(sb.toString());
			}
			writer.close();
			clan_group.clear();
		}
		catch (IOException e) {e.printStackTrace();}
	}

	public static File getDirectory() {
		return new File(MinecraftServer.getServer().worldServers[0].getSaveHandler().getWorldDirectory(), "clan");
	}

	public static class ClanGroup {

		@Nonnull private final String clan_name;
		@Nonnull private final List<String> members = new ArrayList<String>();

		public ClanGroup(@Nonnull final String clan_name) {
			this.clan_name = clan_name;
		}

		public @Nonnull String getClanName() {
			return clan_name;
		}

		public @Nonnull List<String> getMembers() {
			return members;
		}

		public boolean isMember(@Nonnull final String gp) {
			if (members.isEmpty()) return false;
			else {
				for (String member : members)
					if (member.equals(gp)) return true;
				return false;
			}
		}

		public boolean addMember(@Nonnull final String gp) {
			if (members.isEmpty()) {
				members.add(gp);
				return true;
			} else {
				for (String member : members)
					if (member.equals(gp)) return false;
				members.add(gp);
				return true;
			}
		}

	}

}
