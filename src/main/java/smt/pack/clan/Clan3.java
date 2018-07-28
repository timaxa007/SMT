package smt.pack.clan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class Clan3 {

	@Nonnull public static final Clan3 INSTANCE = new Clan3();
	@Nonnull public static final String TAG = "clan3";
	@Nonnull private final ArrayList<ClanGroup> clan_group = new ArrayList<ClanGroup>();

	public void load() {
		clan_group.clear();
		File file = new File(getDirectory(), "clan3.json");
		if (file.exists()) {

			try {
				JsonReader reader = new JsonReader(new FileReader(file));

				reader.beginObject();

				ClanGroup cg = null;
				while (reader.hasNext()) {
					String name = reader.nextName();
					if (name.equals("clan_name")) {
						if (cg != null) clan_group.add(cg);
						cg = new ClanGroup(reader.nextString());
						//} else if (name.equals("age")) {
						//System.out.println(reader.nextInt());
					} else if (name.equals("clan_desk")) {
						cg.setClanDescription(reader.nextString());
					} else if (name.equals("commander")) {
						cg.setCommander(reader.nextString());
					} else if (name.equals("members")) {
						reader.beginArray();
						while (reader.hasNext()) cg.addMember(reader.nextString());
						reader.endArray();
					} else reader.skipValue();
				}
				if (cg != null) clan_group.add(cg);

				reader.endObject();
				reader.close();
			} catch (FileNotFoundException e) {e.printStackTrace();
			} catch (IOException e) {e.printStackTrace();}
		} else {
			try {file.createNewFile();}
			catch (IOException e) {e.printStackTrace();}
		}
	}

	public void save() {
		/*
		clan_group.clear();
		ClanGroup clan2 = new ClanGroup("Test1");
		clan2.addMember("test1");
		clan_group.add(clan2);
		clan2 = new ClanGroup("Test2");
		clan2.addMember("test2");
		clan_group.add(clan2);
		 */
		File file = new File(getDirectory(), "clan3.json");
		if (file.getParentFile() != null) file.getParentFile().mkdirs();

		try {
			JsonWriter writer = new JsonWriter(new FileWriter(file));

			if (!clan_group.isEmpty()) {
				writer.beginObject();
				writer.setIndent("\t");

				for (int j = 0; j < clan_group.size(); ++j) {
					ClanGroup cg = clan_group.get(j);
					writer.name("clan_name").value(cg.getClanName());
					writer.setIndent("\t");

					if (cg.getClanDescription() != null) {
						writer.name("clan_desk").value(cg.getClanDescription());
						writer.setIndent("\t");
					}

					if (cg.getCommander() != null) {
						writer.name("commander").value(cg.getCommander());
						writer.setIndent("\t");
					}

					if (!cg.getMembers().isEmpty()) {
						writer.setIndent("\t");
						writer.name("members");
						writer.beginArray();
						for (String member : cg.getMembers()) {
							writer.value(member);
							writer.setIndent("\t");
						}
						writer.endArray();
					}
				}
				writer.setIndent("\t");
				writer.endObject();
			}

			writer.close();
			clan_group.clear();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	/*
	public void load() {
		clan_group.clear();
		File file = new File(getDirectory(), "clan3.json");
		if (file.exists()) {
			try {
				JsonObject jsonObject = new JsonParser().parse(new FileReader(file)).getAsJsonObject();

				String name = jsonObject.get("clan_name").getAsString();
				ClanGroup cg = new ClanGroup(name);

				JsonArray msg = jsonObject.get("members").getAsJsonArray();
				Iterator<JsonElement> iterator = msg.iterator();
				while (iterator.hasNext()) cg.addMember(iterator.next().getAsString());

				clan_group.add(cg);
			} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {e.printStackTrace();}
		} else {
			try {file.createNewFile();}
			catch (IOException e) {e.printStackTrace();}
		}
	}

	public void save() {
		clan_group.clear();
		ClanGroup clan2 = new ClanGroup("Test");
		clan2.addMember("test");
		clan_group.add(clan2);

		File file = new File(getDirectory(), "clan3.json");
		if (file.getParentFile() != null) file.getParentFile().mkdirs();

		try {
			FileWriter writer = new FileWriter(file, false);
			if (!clan_group.isEmpty()) {

				JsonObject obj = new JsonObject();
				JsonObject clan = new JsonObject();
				obj.add("her", clan);

				for (int j = 0; j < clan_group.size(); ++j) {
					ClanGroup cg = clan_group.get(j);
					obj.add("clan_name", new JsonPrimitive(cg.getClanName()));

					JsonArray members = new JsonArray();
					if (!cg.getMembers().isEmpty()) {
						for (String member : cg.getMembers())
							members.add(new JsonPrimitive(member));
					}
					obj.add("members", members);
				}
				writer.write(obj.toString());
			}
			writer.flush();
			writer.close();
			clan_group.clear();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	 */


	public boolean isMember(@Nonnull ClanGroup cg, @Nonnull final String gp) {
		if (clan_group.isEmpty()) return false;
		return cg.isMember(gp);
	}

	public boolean addMember(@Nonnull ClanGroup cg, @Nonnull final String gp) {
		if (clan_group.isEmpty()) return false;
		return cg.addMember(gp);
	}


	public static File getDirectory() {
		return new File(MinecraftServer.getServer().worldServers[0].getSaveHandler().getWorldDirectory(), "clan");
	}

	public static class ClanGroup {

		@Nonnull private final String clan_name;
		@Nullable private String clan_desk;
		@Nonnull private String commander;
		@Nonnull private final List<String> members = new ArrayList<String>();
		@Nullable private ItemStack symbol;

		public ClanGroup(@Nonnull final String clan_name) {
			this.clan_name = clan_name;
		}

		public @Nonnull String getClanName() {
			return clan_name;
		}

		public ClanGroup setClanDescription(String clan_desk) {
			this.clan_desk = clan_desk;
			return this;
		}

		public String getClanDescription() {
			return clan_desk;
		}

		public @Nonnull List<String> getMembers() {
			return members;
		}

		public ClanGroup setCommander(String commander) {
			this.commander = commander;
			return this;
		}

		public String getCommander() {
			return commander;
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

		public ClanGroup setSymbol(ItemStack symbol) {
			this.symbol = symbol;
			return this;
		}

		public ItemStack getSymbol() {
			return symbol;
		}

	}

}
