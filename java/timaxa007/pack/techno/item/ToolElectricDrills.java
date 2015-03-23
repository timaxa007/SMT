package timaxa007.pack.techno.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import timaxa007.module.control_button.util.ItemPrimaryKey;
import timaxa007.pack.techno.PackTechno;
import timaxa007.tms.util.UtilString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolElectricDrills extends ItemPrimaryKey {

	private static String[] modes = new String[] {
		"Normal", 	//0
		"Hard", 	//1
		"Low"		//2
	};

	public ToolElectricDrills(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_techno);
		setMaxDamage(1000);
		setMaxStackSize(1);
		setNoRepair();
		setTextureName("timaxa007:tool/electric/drill");
	}

	@SideOnly(Side.CLIENT)
	public boolean onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress && !isLeftClick) {
			NBTTagCompound nbt = is.getTagCompound();
			if (nbt != null && nbt.hasKey("ModeID")) {
				int nbn = nbt.getInteger("ModeID");

				if (nbn >= 2) nbn = 0; else nbn++;

				player.addChatMessage(new ChatComponentText(
						EnumChatFormatting.GOLD + "[Drill]: " + EnumChatFormatting.RESET + modes[nbn] + ".")
						);

				return true;
			}
		}
		return super.onModeClient(is, world, player, isPress);
	}

	public void onMode(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
			NBTTagCompound nbt = is.getTagCompound();
			if (nbt != null && nbt.hasKey("ModeID")) {
				int nbn = nbt.getInteger("ModeID");

				if (nbn >= 2) nbn = 0; else nbn++;

				nbt.setInteger("ModeID", nbn);
				is.setTagCompound(nbt);
			}
		}
	}

	public float getDigSpeed(ItemStack is, Block block, int metadata) {
		NBTTagCompound nbt = is.getTagCompound();
		if (block == Blocks.web) {
			return 15.0F;
		} else if (block == Blocks.stonebrick) {
			return 5.0F;
		} else if (nbt != null && nbt.hasKey("ModeID") && nbt.getInteger("ModeID") == 0) {
			return 5.0F;
		} else if (nbt != null && nbt.hasKey("ModeID") && nbt.getInteger("ModeID") == 1) {
			return 10.0F;
		} else if (nbt != null && nbt.hasKey("ModeID") && nbt.getInteger("ModeID") == 2) {
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
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null && nbt.hasKey("ModeID") && nbt.getInteger("ModeID") == 0) {
			is.damageItem(2, entity2);
			return true;
		} else if (nbt != null && nbt.hasKey("ModeID") && nbt.getInteger("ModeID") == 1) {
			is.damageItem(8, entity2);
			return true;
		} else if (nbt != null && nbt.hasKey("ModeID") && nbt.getInteger("ModeID") == 2) {
			is.damageItem(1, entity2);
			return true;
		}
		return false;
	}

	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		NBTTagCompound nbt = is.getTagCompound();
		if (world.getBlock(x, y, z).getBlockHardness(world, x, y, z) != 0.0F) {
			int es = 10;
			if (nbt != null && nbt.hasKey("ModeID")) {
				if (nbt.getInteger("ModeID") == 0) {es = 10;}
				if (nbt.getInteger("ModeID") == 1) {es = 20;}
				if (nbt.getInteger("ModeID") == 2) {es = 5;}
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
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		return is;
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();
		if (UtilString.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("ModeID")) {
					list.add("ModeID: " + nbt.getInteger("ModeID"));
				}
			}
		} else list.add(UtilString.hldshiftinf);

	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT());
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT() {
		ItemStack is = new ItemStack(PackTechno.proxy.item.tool_electric_drills, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("ModeID", 0);
		is.setTagCompound(nbt);
		return is;
	}

}
