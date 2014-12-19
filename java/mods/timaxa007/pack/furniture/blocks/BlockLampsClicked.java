package mods.timaxa007.pack.furniture.blocks;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLampsClicked extends Block{
	@SideOnly(Side.CLIENT) private IIcon[] iconArray;
	private final String light;

	public BlockLampsClicked(boolean par2) {
		super(Material.rock);
		setStepSound(soundTypeGlass);
		setHardness(0.3F);
		setResistance(1.0F);
		setLightOpacity(5);
		if (par2) {
			light="on";
			setLightLevel(1.0F);
		} else {
			light="off";
			setLightLevel(0.0F);
			setCreativeTab(PackFurniture.tab_furniture);
		}
		setBlockTextureName("planks_oak");
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		PlayerInteractEvent event = new PlayerInteractEvent(player, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, x, y, z, side, world);
		if (MinecraftForge.EVENT_BUS.post(event)) {return false;}

		Block block;
		if (this == PackFurniture.proxy.block_lamps_click_on) {
			block = PackFurniture.proxy.block_lamps_click_off;
		} else {
			block = PackFurniture.proxy.block_lamps_click_on;
		}

		if (!world.isRemote && event.getResult() == Result.ALLOW) {
			world.setBlock(x, y, z, block, world.getBlockMetadata(x, y, z), 3);
			return true;
		}
		return false;
	}
	/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_lamps_click_off, 1, metadata));
return ret;
}
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(new ItemStack(id, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		iconArray = new IIcon[16];
		for (int i=0; i < iconArray.length; ++i) {
			iconArray[i] = ir.registerIcon("timaxa007:" + "lamps/lamp_" + GetColors.getNameColors[i] + "_" + light);
		}
	}

}
