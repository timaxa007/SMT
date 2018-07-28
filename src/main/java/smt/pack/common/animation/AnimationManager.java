package smt.pack.common.animation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.gson.stream.JsonReader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import smt.pack.common.animation.a3D.Animation3D;
import smt.pack.common.animation.a3D.Animation3DPlay;
import smt.pack.common.animation.a3D.IAnimation3D;
import smt.pack.common.animation.a3D.Animation3D.Key;

public final class AnimationManager {
	//------------------------------------------------------------------------------
	public static float parTick;
	private static final HashMap<String, IAnimation3D> all = new HashMap<String, IAnimation3D>();
	//------------------------------------------------------------------------------
	public static final class Loader {

		@SideOnly(Side.CLIENT)
		public static final boolean loadJsonAnimation3D(HashMap<String, IAnimation3D> map, ResourceLocation rl) {
			try {
				JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(
						net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(rl).getInputStream()
						)));
				handlingJson(map, reader);
				reader.close();
				return true;
			}
			catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
			return false;
		}

		public static final boolean loadJsonAnimation3D(HashMap<String, IAnimation3D> map, File file) {
			try {
				JsonReader reader = new JsonReader(new FileReader(file));
				handlingJson(map, reader);
				reader.close();
				return true;
			}
			catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
			return false;
		}

		public static final HashMap<String, IAnimation3D> handlingJson(HashMap<String, IAnimation3D> map, JsonReader reader) throws IOException {
			String title = null;
			float time_line = 0;
			boolean loop = false;
			List<Animation3D.Key>
			translateX_line = new ArrayList<Animation3D.Key>(),
			translateY_line = new ArrayList<Animation3D.Key>(),
			translateZ_line = new ArrayList<Animation3D.Key>(),
			rotateX_line = new ArrayList<Animation3D.Key>(),
			rotateY_line = new ArrayList<Animation3D.Key>(),
			rotateZ_line = new ArrayList<Animation3D.Key>();

			reader.beginObject();
			while (reader.hasNext()) {
				String name = reader.nextName();
				//-------------------------------------
				if (name.equalsIgnoreCase("Title")) {
					if (title != null) {
						map.put(title, new Animation3D(time_line, loop,
								translateX_line.size() > 0 ? translateX_line.toArray(new Animation3D.Key[]{}) : null,
								translateY_line.size() > 0 ? translateY_line.toArray(new Animation3D.Key[]{}) : null,
								translateZ_line.size() > 0 ? translateZ_line.toArray(new Animation3D.Key[]{}) : null,
								rotateX_line.size() > 0 ? rotateX_line.toArray(new Animation3D.Key[]{}) : null,
								rotateY_line.size() > 0 ? rotateY_line.toArray(new Animation3D.Key[]{}) : null,
								rotateZ_line.size() > 0 ? rotateZ_line.toArray(new Animation3D.Key[]{}) : null
								));
						translateX_line.clear();
						translateY_line.clear();
						translateZ_line.clear();
						rotateX_line.clear();
						rotateY_line.clear();
						rotateZ_line.clear();
						loop = false;
					}
					title = reader.nextString();
					//-------------------------------------
				} else if (name.equalsIgnoreCase("TimeLine")) {
					time_line = reader.nextInt();
					//-------------------------------------
				} else if (name.equalsIgnoreCase("Loop")) {
					loop = reader.nextBoolean();
				}
				//-------------------------------------
				else if (name.equalsIgnoreCase("TranslateX")) {
					reader.beginArray();
					while (reader.hasNext()) {
						String field = reader.nextString().replace(" ", "");
						String[] fields = field.split(",");
						try {
							if (fields.length == 2)
								translateX_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue()));
							if (fields.length == 3)
								translateX_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue(), Easing.getEasing(fields[2])));
						} catch (NumberFormatException nfe) {}
					}
					reader.endArray();
				}
				//-------------------------------------
				else if (name.equalsIgnoreCase("TranslateY")) {
					reader.beginArray();
					while (reader.hasNext()) {
						String field = reader.nextString().replace(" ", "");
						String[] fields = field.split(",");
						try {
							if (fields.length == 2)
								translateY_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue()));
							if (fields.length == 3)
								translateY_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue(), Easing.getEasing(fields[2])));
						} catch (NumberFormatException nfe) {}
					}
					reader.endArray();
				}
				//-------------------------------------
				else if (name.equalsIgnoreCase("TranslateZ")) {
					reader.beginArray();
					while (reader.hasNext()) {
						String field = reader.nextString().replace(" ", "");
						String[] fields = field.split(",");
						try {
							if (fields.length == 2)
								translateZ_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue()));
							if (fields.length == 3)
								translateZ_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue(), Easing.getEasing(fields[2])));
						} catch (NumberFormatException nfe) {}
					}
					reader.endArray();
				}
				//-------------------------------------
				else if (name.equalsIgnoreCase("RotateX")) {
					reader.beginArray();
					while (reader.hasNext()) {
						String field = reader.nextString().replace(" ", "");
						String[] fields = field.split(",");
						try {
							if (fields.length == 2)
								rotateX_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue()));
							if (fields.length == 3)
								rotateX_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue(), Easing.getEasing(fields[2])));
						} catch (NumberFormatException nfe) {}
					}
					reader.endArray();
				}
				//-------------------------------------
				else if (name.equalsIgnoreCase("RotateY")) {
					reader.beginArray();
					while (reader.hasNext()) {
						String field = reader.nextString().replace(" ", "");
						String[] fields = field.split(",");
						try {
							if (fields.length == 2)
								rotateY_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue()));
							if (fields.length == 3)
								rotateY_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue(), Easing.getEasing(fields[2])));
						} catch (NumberFormatException nfe) {}
					}
					reader.endArray();
				}
				//-------------------------------------
				else if (name.equalsIgnoreCase("RotateZ")) {
					reader.beginArray();
					while (reader.hasNext()) {
						String field = reader.nextString().replace(" ", "");
						String[] fields = field.split(",");
						try {
							if (fields.length == 2)
								rotateZ_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue()));
							if (fields.length == 3)
								rotateZ_line.add(new Animation3D.Key(Float.valueOf(fields[0]).floatValue(), Float.valueOf(fields[1]).floatValue(), Easing.getEasing(fields[2])));
						} catch (NumberFormatException nfe) {}
					}
					reader.endArray();
				}
				//-------------------------------------
				else reader.skipValue();
			}
			reader.endObject();

			if (title != null) {
				map.put(title, new Animation3D(time_line, loop,
						translateX_line.isEmpty() ? null : translateX_line.toArray(new Animation3D.Key[]{}),
						translateY_line.isEmpty() ? null : translateY_line.toArray(new Animation3D.Key[]{}),
						translateZ_line.isEmpty() ? null : translateZ_line.toArray(new Animation3D.Key[]{}),
						rotateX_line.isEmpty() ? null : rotateX_line.toArray(new Animation3D.Key[]{}),
						rotateY_line.isEmpty() ? null : rotateY_line.toArray(new Animation3D.Key[]{}),
						rotateZ_line.isEmpty() ? null : rotateZ_line.toArray(new Animation3D.Key[]{})
						));
				translateX_line.clear();
				translateY_line.clear();
				translateZ_line.clear();
				rotateX_line.clear();
				rotateY_line.clear();
				rotateZ_line.clear();
				loop = false;
				title = null;
			}
			return map;
		}

	}
	//------------------------------------------------------------------------------
	static {
		//--------------------------------------------
		addAnimation("test", new Animation3D(350, true,
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(100, 2F),
						new Animation3D.Key(200, 2F),
						new Animation3D.Key(300, 0F)
		}, null,
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(100, 0F),
						new Animation3D.Key(200, 2F)
		},
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(100, 0F),
						new Animation3D.Key(200, 180F),
						new Animation3D.Key(300, 180F)
		}, null, null));
		//--------------------------------------------
		addAnimation("pistol_end", new Animation3D(4, false,
				null, null,
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(2, -0.05F),
						new Animation3D.Key(3, 0F)
		}, null, null, null));
		//--------------------------------------------
		addAnimation("pistol_ammo", new Animation3D(21, false,
				null,
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(7, -0.5F),
						new Animation3D.Key(12, -0.5F),
						new Animation3D.Key(20, 0F)
		},
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(7, -0.2F),
						new Animation3D.Key(12, -0.2F),
						new Animation3D.Key(20, 0F)
		}, null, null, null));
		//--------------------------------------------
		addAnimation("pistol_r_ammo", new Animation3D(21, false,
				null, null, null, null,
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(5, 0F),
						new Animation3D.Key(10, 90F),
						new Animation3D.Key(20, 0)
		}, null));
		//--------------------------------------------
		addAnimation("pistol_aim", new Animation3D(8, false,
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(3, 0.70F),
						//new Animation3D.Key(5, 0.70F),
						new Animation3D.Key(7, 0F)
		}, 
				new Animation3D.Key[]{
						new Animation3D.Key(0, 0F),
						new Animation3D.Key(3, 0.15F),
						//new Animation3D.Key(5, 0.15F),
						new Animation3D.Key(7, 0F)
		},
				null, null, null, null));
		//--------------------------------------------
	}

	public static boolean addAnimation(String name, Animation3D animation) {
		if (all.put(name, animation) != null) return true;
		return false;
	}

	public static boolean removeAnimation(String name, Animation3D animation) {
		if (all.remove(name, animation)) return true;
		return false;
	}

	public static IAnimation3D playAnimation(String name) {
		return all.get(name);
	}

	public static File getDir() {
		return cpw.mods.fml.common.FMLCommonHandler.instance().getSide().isClient() ?
				new File(net.minecraft.client.Minecraft.getMinecraft().mcDataDir, "mods") :
					new File(MinecraftServer.getServer().getFolderName(), "mods");
	}

	public static Animation3DPlay playAnimation(IAnimation3D animation) {
		return new Animation3DPlay(animation);
	}
	//------------------------------------------------------------------------------
}
