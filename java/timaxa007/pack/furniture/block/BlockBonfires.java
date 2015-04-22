package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.object.ModifiedBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBonfires extends ModifiedBlock {

	public BlockBonfires(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setResistance(2.5F);
		setLightOpacity(0);
		setStepSound(soundTypeWood);
		setBlockTextureName("timaxa007:block_bonfires");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			//--------------------------------
			if ((current.getItem() == Items.flint_and_steel) && (world.getBlock(x, y, z) == PackFurniture.block.bonfires)) {
				world.setBlock(x, y, z, PackFurniture.block.bonfires_burning);
				current.setItemDamage(current.getItemDamage() + 1);
				return true;
			} else {
				return false;
			}
			//--------------------------------
		} else {
			return false;
		}
	}

}
