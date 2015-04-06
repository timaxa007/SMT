package timaxa007.pack.magic.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import timaxa007.module.control_button.trash.ItemPrimaryKey;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.packet.MessageStuff;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffs extends ItemPrimaryKey {

	public ItemStuffs(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setTextureName("timaxa007:stuffs");
		setFull3D();
	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onLeftClickClient(is, world, player, isPress);
		//if (isPress) {
		world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 255.0D);
		PackMagic.network.sendToServer(new MessageStuff(1, isPress));
	}

	public void left(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) is.damageItem(1, player);
	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onRightClickClient(is, world, player, isPress);
		PackMagic.network.sendToServer(new MessageStuff(2, isPress));
	}

	public void right(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {

		ItemStack is1 = new ItemStack(Items.diamond_helmet);
		NBTTagCompound nbt1 = new NBTTagCompound();
		Spells.addSpell(nbt1, Spells.repair_item, 1, -1);
		//Spells.addSpell(nbt1, Spells.armor_head, 0, 120);
		Spells.addSpell(nbt1, Spells.projectile_protection, 255, -1);
		is1.setTagCompound(nbt1);

		ItemStack is2 = new ItemStack(Items.diamond_chestplate);
		NBTTagCompound nbt2 = new NBTTagCompound();
		Spells.addSpell(nbt2, Spells.repair_item, 1, -1);
		//Spells.addSpell(nbt2, Spells.armor_torso, 0, 120);
		Spells.addSpell(nbt2, Spells.explosion_protection, 255, -1);
		is2.setTagCompound(nbt2);

		ItemStack is3 = new ItemStack(Items.diamond_leggings);
		NBTTagCompound nbt3 = new NBTTagCompound();
		Spells.addSpell(nbt3, Spells.repair_item, 1, -1);
		//Spells.addSpell(nbt3, Spells.armor_legs, 0, 120);
		Spells.addSpell(nbt3, Spells.fire_damage_protection, 255, -1);
		is3.setTagCompound(nbt3);

		ItemStack is4 = new ItemStack(Items.diamond_boots);
		NBTTagCompound nbt4 = new NBTTagCompound();
		Spells.addSpell(nbt4, Spells.repair_item, 1, -1);
		//Spells.addSpell(nbt4, Spells.armor_feet, 0, 120);
		Spells.addSpell(nbt4, Spells.unblockable_protection, 255, -1);
		is4.setTagCompound(nbt4);

		ItemStack[] armorSpell = new ItemStack[] {is1, is2, is3, is4};

		int k = 0;
		for (int j = 0; j < player.inventory.mainInventory.length; j++) {
			if (player.inventory.mainInventory[j] == null) {
				player.inventory.mainInventory[j] = armorSpell[k];
				k++;
				if (k == armorSpell.length) break;
			}
		}

		is.damageItem(1, player);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		/*list.add(StatCollector.translateToLocal("text.line1"));
		list.add(StatCollector.translateToLocal("text.line2"));
		list.add(StatCollector.translateToLocal("text.line3"));*/
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		for (int j1 = 0; j1 < 4; ++j1) {
			for (int j2 = 0; j2 < 4; ++j2) {
				list.add(addNBT(j1, j2));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1, int par2) {
		ItemStack is = new ItemStack(PackMagic.item.stuffs, 1, 512);
		NBTTagCompound nbt = new NBTTagCompound();
		Spells.addSpell(nbt, Spells.efficient_mining, 0, -1);
		Spells.addSpell(nbt, Spells.efficient_digging, 1, 0);
		Spells.addSpell(nbt, Spells.efficient_chopping, 127, 64);
		Spells.addSpell(nbt, Spells.efficient_trimming, 255, 32767);
		nbt.setInteger("Type", par1);
		nbt.setInteger("Cap", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
