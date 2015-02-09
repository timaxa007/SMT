package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ModifiedItem;
import mods.timaxa007.tms.util.UtilText;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemParticlesGun extends ModifiedItem {

	@SideOnly(Side.CLIENT) private IIcon[] icon_tex;
	@SideOnly(Side.CLIENT) private IIcon[] icon_ovl;

	public ItemParticlesGun(String tag) {
		super(tag);
		setMaxStackSize(1);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:item_weapons");
	}

	public void onUpdate(ItemStack is, World world, Entity par3Entity, int par4, boolean par5) {

	}

	public void onPlayerStoppedUsing(ItemStack is, World world, EntityPlayer player, int par4) {

	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		return is;
	}

	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.none;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilText.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("WeaponID"))
					list.add("WeaponID: " + nbt.getInteger("WeaponID") + ".");
			}
		} else list.add(UtilText.hldshiftinf);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.particles_gun, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("WeaponID", par1);
		//nbt.setInteger("AmmoID", par2);
		//nbt.setInteger("MagazineID", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
