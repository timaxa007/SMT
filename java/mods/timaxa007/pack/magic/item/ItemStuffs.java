package mods.timaxa007.pack.magic.item;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.lib.Spells;
import mods.timaxa007.tms.util.ItemActionMouse;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffs extends ItemActionMouse {

	public ItemStuffs(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setTextureName("timaxa007:stuffs");
		setFull3D();
	}

	@SideOnly(Side.CLIENT)
	public boolean onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
			world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 255.0D);
		}
		return super.onLeftClickClient(is, world, player, isPress);
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

	private static ItemStack addNBT(int par1, int par2) {
		ItemStack is = new ItemStack(PackMagic.proxy.item.stuffs);
		NBTTagCompound nbt = new NBTTagCompound();
		Spells.addSpell(nbt, Spells.efficient_mining, 0, -1);
		Spells.addSpell(nbt, Spells.efficient_digging, 1, 0);
		Spells.addSpell(nbt, Spells.efficient_chopping, 50, 64);
		Spells.addSpell(nbt, Spells.efficient_trimming, 127, 32767);
		nbt.setInteger("Type", par1);
		nbt.setInteger("Cap", par2);
		is.setTagCompound(nbt);
		return is;
	}

}
