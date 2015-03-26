package timaxa007.pack.stock.block;

import java.util.List;

import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.tile.TileEntityHealing;
import timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHealing extends ModifiedBlock implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] iconArray;

	public static final String[] healingTypes = new String[] {
		"healing1", 
		"healing2", 
		"healing3", 
		"healing4", 
		"healing5", 
		"healing6", 
		"healing7", 
		"healing8", 
		"healing9", 
		"healing10", 
		"healing11", 
		"healing12", 
		"healing13", 
		"healing14", 
		"healing15", 
		"healing16"
	};

	public BlockHealing(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackStock.tab_medical);
		setStepSound(soundTypeWood);
		setHardness(0.1F);
		setResistance(0.01F);
		setBlockTextureName("planks_oak");
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityHealing();
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < healingTypes.length; ++j) {
			list.add(new ItemStack(id, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		iconArray = new IIcon[healingTypes.length];
		for (int i = 0; i < iconArray.length; ++i) {
			iconArray[i] = ir.registerIcon("timaxa007:healing/" + healingTypes);
		}
	}

}