package mods.timaxa007.pack.weapon.block;

import mods.timaxa007.lib.ActionModel;
import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.pack.weapon.tile.TileEntityClaymore;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockClaymore extends Block implements ITileEntityProvider {

	public BlockClaymore() {
		super(Material.circuits);
		setCreativeTab(PackWeapons.tab_weapons);
		setHardness(0.5F);
		setResistance(1.0F);
		setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.5F, 0.8125F);
		setBlockName("claymore");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityClaymore();
	}

	public int getRenderType() {
		return PackWeapons.proxy.render.block_claymore_modelID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			world.createExplosion(entity, x, y, z, 5, true);
		}
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explos) {
		if (!world.isRemote);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		if (!world.isRemote && entity instanceof EntityPlayer) {
			int l = ActionModel.rotation_model_8sides_invert(entity.rotationYaw);
			world.setBlockMetadataWithNotify(x, y, z, l, 3);
		}
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

}
