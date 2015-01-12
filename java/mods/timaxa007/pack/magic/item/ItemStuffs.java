package mods.timaxa007.pack.magic.item;

import java.util.Iterator;
import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.PacketSpawnParticle;
import mods.timaxa007.tms.util.IActionMouseKey;
import mods.timaxa007.tms.util.ItemActionKeyPrimary;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffs extends ItemActionKeyPrimary implements IActionMouseKey {

	public ItemStuffs() {
		super();
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:stuffs");
		setUnlocalizedName("stuffs");
		setFull3D();
	}

	@Override
	public void onLeftClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
			//MovingObjectPosition obj = Minecraft.getMinecraft().objectMouseOver;
			MovingObjectPosition obj_block = Minecraft.getMinecraft().renderViewEntity.rayTrace(200.0D, 1.0F);
			MovingObjectPosition obj_entity = UtilTMS.LookOBJ.getEntityDistance();

			if (obj_entity != null) {
				Entity entity = obj_entity.entityHit;

				if (entity instanceof EntityItem) {
					ItemStack drop_item = ((EntityItem)entity).getEntityItem();
					for (int i = 0; i < player.inventory.mainInventory.length; i++) {
						if (player.inventory.mainInventory[i] == null || player.inventory.mainInventory[i] == drop_item) {
							player.inventory.addItemStackToInventory(drop_item);
							entity.setDead();
							break;
						}
					}
				}

				if (entity instanceof EntityLivingBase) {
					((EntityLivingBase)entity).onKillEntity((EntityLivingBase)entity);
					world.spawnEntityInWorld(new EntityItem(world, entity.posX, entity.posY, entity.posZ, new ItemStack(Items.slime_ball, (int)((EntityLivingBase)entity).getHealth() / 2, 0)));
					//entity.setDead();
					//entity.posX
					//entity.posY
					//entity.posZ
				}


				if (Core.show_system_info_testing) System.out.println("obj_entity - " + obj_entity.toString());
			} else if (obj_block != null && obj_block.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				int x = obj_block.blockX;
				int y = obj_block.blockY;
				int z = obj_block.blockZ;
				Block block = world.getBlock(x, y, z);

				//if (block.getMaterial() != Material.air) {}

				if (block == Blocks.ice) {
					world.setBlock(x, y, z, Blocks.water);
				}

				if (block.getMaterial() == Material.wood) {
					if (block == Blocks.log) {
						world.spawnEntityInWorld(new EntityItem(world, x, y, z, 
								new ItemStack(Blocks.planks, 4, world.getBlockMetadata(x, y, z))));
						world.func_147480_a(x, y, z, false);
					}
					if (block == Blocks.log2) {
						world.spawnEntityInWorld(new EntityItem(world, x, y, z, 
								new ItemStack(Blocks.planks, 4, 4 + world.getBlockMetadata(x, y, z))));
						world.func_147480_a(x, y, z, false);
					}
				}

				if (block == Blocks.dirt && world.getBlockMetadata(x, y, z) == 0) {
					world.setBlock(x, y, z, Blocks.grass);
				}

				if (Core.show_system_info_testing) System.out.println(block.getLocalizedName() + "obj_block - " + obj_block.toString());
			} else {
				if (Core.show_system_info_testing) System.out.println("Air");
			}

		}
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		if (isPress) {
			MovingObjectPosition obj_block = Minecraft.getMinecraft().renderViewEntity.rayTrace(200.0D, 1.0F);
			MovingObjectPosition obj_entity = UtilTMS.LookOBJ.getEntityDistance();

			if (obj_entity != null) {
				Entity entity = obj_entity.entityHit;

				if (entity instanceof EntityItem) {
					ItemStack drop_item = ((EntityItem)entity).getEntityItem();
					for (int i = 0; i < player.inventory.mainInventory.length; i++) {
						if (player.inventory.mainInventory[i] == null || player.inventory.mainInventory[i] == drop_item) {
							player.inventory.addItemStackToInventory(drop_item);
							entity.setDead();
							break;
						}
					}
				}

				if (entity instanceof EntityLivingBase) {
					((EntityLivingBase)entity).onKillEntity((EntityLivingBase)entity);
					world.spawnEntityInWorld(new EntityItem(world, entity.posX, entity.posY, entity.posZ, new ItemStack(Items.slime_ball, (int)((EntityLivingBase)entity).getHealth() / 2, 0)));
					//entity.setDead();
					//entity.posX
					//entity.posY
					//entity.posZ
				}


				if (Core.show_system_info_testing) System.out.println("obj_entity - " + obj_entity.toString());
			} else if (obj_block != null && obj_block.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				int x = obj_block.blockX;
				int y = obj_block.blockY;
				int z = obj_block.blockZ;
				Block block = world.getBlock(x, y, z);

				//if (block.getMaterial() != Material.air) {}

				if (block.getMaterial() == Material.wood) {
					world.setBlock(x, y + 1, z, Blocks.fire);
				}

				if (block == Blocks.water) {
					block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					world.setBlock(x, y, z, Blocks.ice);
				}

				if (block == Blocks.lava) {
					block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					world.setBlock(x, y, z, Blocks.obsidian);
				}

				if (block == Blocks.dirt && world.getBlockMetadata(x, y, z) == 0) {
					world.setBlock(x, y, z, Blocks.grass);
				}

				if (Core.show_system_info_testing) System.out.println(block.getLocalizedName() + "obj_block - " + obj_block.toString());
			} else {
				if (Core.show_system_info_testing) System.out.println("Air");
			}

			double d0 = (double)(50);

			AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(d0, d0, d0);
			axisalignedbb.maxY = (double)world.getHeight();
			List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			Iterator iterator = list.iterator();
			Entity entity;

			while(iterator.hasNext()) {
				entity = (Entity)iterator.next();
				MovingObjectPosition target = new MovingObjectPosition(entity);
				//System.out.println(target.toString());

				//Minecraft.getMinecraft().effectRenderer.addEffect(new EntityHugeExplodeFX(world, ((double)player.posX), ((double)player.posY), ((double)player.posZ), 0.0D, 0.0D, 0.0D));

				if (entity instanceof EntityPlayer) {
					if (entity == player) player.getFoodStats().addStats(1, 1.0F);
					//if (!world.isRemote) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 20 * 1));
				}

				if (entity instanceof EntityLivingBase) {
					((EntityLivingBase)entity).setFire(10);
					//entity.posX
					//entity.posY
					//entity.posZ
				}

				if (entity instanceof EntityItem) {
					ItemStack drop_item = ((EntityItem)entity).getEntityItem();
					for (int i = 0; i < player.inventory.mainInventory.length; i++) {
						if (player.inventory.mainInventory[i] == null || player.inventory.mainInventory[i] == drop_item) {
							player.inventory.addItemStackToInventory(drop_item);
							entity.setDead();
							break;
						}
					}
				}

				if (entity instanceof EntityArrow) {
					for (int i = 0; i < player.inventory.mainInventory.length; i++) {
						if (player.inventory.mainInventory[i] == null || (player.inventory.mainInventory[i].getItem() == Items.arrow)) {
							player.inventory.addItemStackToInventory(new ItemStack(Items.arrow, 1));
							entity.setDead();
							break;
						}
					}
				}

				if (entity instanceof EntityXPOrb) {
					int xpv = ((EntityXPOrb)entity).getXpValue();
					player.addExperience(xpv);
					entity.setDead();
					world.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F + ((float)xpv * 0.02F));
				}

			}

		}
	}

	@Override
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player) {

		MovingObjectPosition obj_block = Minecraft.getMinecraft().renderViewEntity.rayTrace(200.0D, 1.0F);
		MovingObjectPosition obj_entity = UtilTMS.LookOBJ.getEntityDistance();

		if (obj_entity != null) {
			Entity entity = obj_entity.entityHit;

			if (Core.show_system_info_testing) System.out.println("obj_entity - " + obj_entity.toString());
		} else if (obj_block != null && obj_block.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			int x = obj_block.blockX;
			int y = obj_block.blockY;
			int z = obj_block.blockZ;
			Block block = world.getBlock(x, y, z);

			//if (block.getMaterial() != Material.air) {}

			if (block.getMaterial() == Material.rock) {
				world.func_147480_a(x, y, z, true);
			}

			if (Core.show_system_info_testing) System.out.println(block.getLocalizedName() + "obj_block - " + obj_block.toString());
		} else {
			if (Core.show_system_info_testing) System.out.println("Air");
		}

	}

	@Override
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player) {
		Core.network.sendToAllAround(new PacketSpawnParticle(1, player.posX, player.posY, player.posZ), 
				new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 18.5D));
	}

	@Override
	public void onHook(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		System.out.println("throwing - " + is.getDisplayName());
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
				list.add(addTag(j1, j2));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2) {
		ItemStack is = new ItemStack(PackMagic.proxy.item.stuffs);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		tag.setInteger("Cap", par2);
		is.setTagCompound(tag);
		return is;
	}

}
