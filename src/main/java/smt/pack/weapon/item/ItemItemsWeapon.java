package smt.pack.weapon.item;

import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.common.util.UtilString;
import smt.pack.weapon.entity.EntityWeapon;
import smt.pack.weapon.registry.Bullet;
import smt.pack.weapon.registry.Magazine;
import smt.pack.weapon.registry.Reg;

public class ItemItemsWeapon extends Item {

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		System.out.println(side);
		EntityWeapon bullet = new EntityWeapon(world);
		bullet.setPosition((double)x + 0.5D, (double)y + 1.0D, (double)z + 0.5D);
		world.spawnEntityInWorld(bullet);
		return false;
	}
	/*
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		return super.onItemRightClick(is, world, player);
	}
	 */
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("BulletID", NBT.TAG_STRING) && Reg.bullets.containsKey(nbt.getString("BulletID")))
				return Reg.bullets.get(nbt.getString("BulletID")).getName();
			if (nbt.hasKey("MagazineID", NBT.TAG_STRING) && Reg.magazines.containsKey(nbt.getString("MagazineID")))
				return Reg.magazines.get(nbt.getString("MagazineID")).getName();
		}
		return super.getUnlocalizedName(itemStack);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("BulletID", NBT.TAG_STRING) && Reg.bullets.containsKey(nbt.getString("BulletID")))
				return StatCollector.translateToLocal(Reg.bullets.get(nbt.getString("BulletID")).getName());
			if (nbt.hasKey("MagazineID", NBT.TAG_STRING) && Reg.magazines.containsKey(nbt.getString("MagazineID")))
				return StatCollector.translateToLocal(Reg.magazines.get(nbt.getString("MagazineID")).getName());
		}
		return super.getItemStackDisplayName(itemStack);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt != null) {
			if (nbt.hasKey("BulletID", NBT.TAG_STRING)) {
				if (flag) list.add("BulletID: " + nbt.getString("BulletID"));
				Bullet bullet = Reg.bullets.get(nbt.getString("BulletID"));
				if (bullet == null) return;
				list.add("Damage: " + bullet.getDamage());

				if (bullet.getEffects() != null) {
					String effects = "";
					for (String effect : bullet.getEffects()) effects += effect + "  ";
					list.add("Effects: " + effects);
				}

				if (bullet.getDescription().length() > 0) {
					list.add("Description:");
					list.addAll(UtilString.unname2(StatCollector.translateToLocal(bullet.getDescription()), Minecraft.getMinecraft().fontRenderer, 200));
				}
			}
			if (nbt.hasKey("MagazineID", NBT.TAG_STRING)) {
				if (flag) list.add("MagazineID: " + nbt.getString("MagazineID"));
				Magazine mag = Reg.magazines.get(nbt.getString("MagazineID"));
				if (mag == null) return;
				list.add("Amount: " + mag.getAmount());

				if (mag.getBullets() != null) {
					String bullets = "";
					for (String effect : mag.getBullets()) bullets += effect + "  ";
					list.add("Bullets: " + bullets);
				}

				if (nbt.hasKey("Course", NBT.TAG_LIST)) {
					NBTTagList tag_list = nbt.getTagList("Course", NBT.TAG_STRING);
					for (int i = 0; i < tag_list.tagCount(); ++i)
						list.add("Course" + i + ": " + tag_list.getStringTagAt(i));
				}

				if (mag.getDescription().length() > 0) {
					list.add("Description:");
					list.addAll(UtilString.unname2(StatCollector.translateToLocal(mag.getDescription()), Minecraft.getMinecraft().fontRenderer, 200));
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item id, CreativeTabs table, List list) {
		//list.add(new ItemStack(id, 1, 0));
		for (Map.Entry<String, Bullet> entry : Reg.bullets.entrySet())
			list.add(addNBT(new ItemStack(id, 1, 0), "BulletID", entry.getKey()));
		for (Map.Entry<String, Magazine> entry : Reg.magazines.entrySet())
			list.add(addNBT(new ItemStack(id, 1, 0), "MagazineID", entry.getKey()));
	}

	public static ItemStack addNBT(ItemStack itemStack, String key, String value) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString(key, value);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

	public static ItemStack addNBT(ItemStack itemStack, String magazineID, Bullet[] course, int number_course) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("MagazineID", magazineID);
		NBTTagList tag_list = new NBTTagList();
		for (int i = 0; i <= number_course; ++i) {
			String id = Reg.getBulletID(course[i]);
			if (id != null) tag_list.appendTag(new NBTTagString(id));
		}
		nbt.setTag("Course", tag_list);
		itemStack.setTagCompound(nbt);
		return itemStack;
	}

}
