package mods.timaxa007.pack.techno.item;

import java.util.List;

import mods.timaxa007.lib.Option;
import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.tms.util.ItemActionKeyPrimary;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolElectricDrills extends ItemActionKeyPrimary {

	private static String[] modes = new String[] {
		"Normal", 	//0
		"Hard", 	//1
		"Low"		//2
	};

	public ToolElectricDrills() {
		super();
		setCreativeTab(PackTechno.tab_techno);
		setMaxDamage(1000);
		setMaxStackSize(1);
		setNoRepair();
		setTextureName("electric.drills");
		setUnlocalizedName("tool_electric_drills");
	}

	public float getDigSpeed(ItemStack is, Block block, int metadata) {
		NBTTagCompound tag = is.getTagCompound();
		if (block == Blocks.web) {
			return 15.0F;
		} else if (block == Blocks.stonebrick) {
			return 5.0F;
		} else if (tag != null && tag.hasKey("ModeID") && tag.getInteger("ModeID") == 0) {
			return 5.0F;
		} else if (tag != null && tag.hasKey("ModeID") && tag.getInteger("ModeID") == 1) {
			return 10.0F;
		} else if (tag != null && tag.hasKey("ModeID") && tag.getInteger("ModeID") == 2) {
			return 1.0F;
		} else {
			Material material = block.getMaterial();
			return material != Material.plants && 
					material != Material.vine && 
					material != Material.coral && 
					material != Material.leaves && 
					material != Material.gourd ? 1.0F : 1.5F;
		}
	}

	public boolean hitEntity(ItemStack is, EntityLivingBase entity1, EntityLivingBase entity2) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("ModeID") && tag.getInteger("ModeID") == 0) {
			is.damageItem(5, entity2);
			return true;
		} else if (tag != null && tag.hasKey("ModeID") && tag.getInteger("ModeID") == 1) {
			is.damageItem(10, entity2);
			return true;
		} else if (tag != null && tag.hasKey("ModeID") && tag.getInteger("ModeID") == 2) {
			is.damageItem(1, entity2);
			return true;
		}
		return false;
	}

	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		NBTTagCompound tag = is.getTagCompound();
		if (world.getBlock(x, y, z).getBlockHardness(world, x, y, z) != 0.0F) {
			int es = 10;
			if (tag != null && tag.hasKey("ModeID")) {
				if (tag.getInteger("ModeID") == 0) {es = 10;}
				if (tag.getInteger("ModeID") == 1) {es = 20;}
				if (tag.getInteger("ModeID") == 2) {es = 5;}
			}
			is.damageItem((int)(world.getBlock(x, y, z).getBlockHardness(world, x, y, z) * es), entity);
			return true;
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	public void onMode(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag != null && tag.hasKey("ModeID")) {
			int nbn = tag.getInteger("ModeID");

			if (nbn >= 2) {nbn = 0;} else {nbn = nbn + 1;}

			//if (world.isRemote) {player.addChatMessage("[Drill]: " + modes[nbn] + " ");}
			tag.setInteger("ModeID", nbn);
			is.setTagCompound(tag);
		}

	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		return is;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound tag = is.getTagCompound();
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			if (tag != null) {
				if (tag.hasKey("ModeID")) {
					list.add("ModeID: " + tag.getInteger("ModeID"));
				}
			}
		} else list.add(Option.prshift);

	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addTag());
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag() {
		ItemStack is = new ItemStack(PackTechno.proxy.item.tool_electric_drills, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("ModeID", 0);
		is.setTagCompound(tag);
		return is;
	}

}
