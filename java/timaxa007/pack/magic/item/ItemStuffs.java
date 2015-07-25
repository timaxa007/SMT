package timaxa007.pack.magic.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import timaxa007.api.IInteractionWithBlock;
import timaxa007.api.IInteractionWithEntity;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.module.control_button.api.IActionPrimaryKey;
import timaxa007.module.control_button.api.IUpdateClient;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.packet.MessagePuff;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.object.ModifiedItem;
import timaxa007.smt.packet.MessageInteractionBlock;
import timaxa007.smt.packet.MessageInteractionEntity;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffs extends ModifiedItem implements
IActionMouse, IActionPrimaryKey,
IInteractionWithBlock, IInteractionWithEntity,
IUpdateClient
{
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT) public static boolean isLeftClick;
	@SideOnly(Side.CLIENT) public static boolean isRightClick;

	@SideOnly(Side.CLIENT) public static boolean isReload;
	@SideOnly(Side.CLIENT) public static boolean isCharge;
	@SideOnly(Side.CLIENT) public static boolean isMode;
	@SideOnly(Side.CLIENT) public static boolean isAction;
	@SideOnly(Side.CLIENT) public static boolean isModeIn;
	@SideOnly(Side.CLIENT) public static boolean isModeOut;
	//--------------------------------------------------------------------------------------------------------------
	/**Уже не знаю как тут ещё хуже сделать. (<i>Это был почти сарказм.</i>) <br>
	 * Do not know how to do here is even worse. (<i>It was almost sarcasm.</i>)**/
	public ItemStuffs(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setTextureName("timaxa007:stuffs");
		setFull3D();
	}
	//--------------------------------------------------------------------------------------------------------------
	public void onUpdate(ItemStack is, World world, Entity entity, int tick, boolean flag) {

		if (entity instanceof EntityPlayer) {

			double d0 = 8.0D;

			AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)entity.posX, (double)entity.posY, (double)entity.posZ, (double)(entity.posX + 1), (double)(entity.posY + 1), (double)(entity.posZ + 1)).expand(d0, d0, d0);
			List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			Iterator iterator = list.iterator();
			Entity entity2 = null;
			//EntityItem entity_item = null;

			while(iterator.hasNext()) {
				entity2 = (Entity)iterator.next();

				if (entity2 instanceof EntityItem) {
					EntityItem entity_item = (EntityItem)entity2;
					/*EntityXPOrb*/
					if (entity2 != null && entity_item.delayBeforeCanPickup == 0) {
						double d1 = (entity.posX - entity2.posX) / d0;
						double d2 = (entity.posY + (double)entity.getEyeHeight() - entity2.posY) / d0;
						double d3 = (entity.posZ - entity2.posZ) / d0;
						double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
						double d5 = 1.0D - d4;

						if (d5 > 0.0D) {
							d5 *= d5;
							entity2.motionX += d1 / d4 * d5 * 0.1D;
							entity2.motionY += d2 / d4 * d5 * 0.1D;
							entity2.motionZ += d3 / d4 * d5 * 0.1D;
						}
					}

					entity2.moveEntity(entity2.motionX, entity2.motionY, entity2.motionZ);
					float f = 0.98F;

					if (entity2.onGround) {
						f = entity2.worldObj.getBlock(MathHelper.floor_double(entity2.posX), MathHelper.floor_double(entity2.boundingBox.minY) - 1, MathHelper.floor_double(entity2.posZ)).slipperiness * 0.98F;
					}

					entity2.motionX *= (double)f;
					entity2.motionY *= 0.9800000190734863D;
					entity2.motionZ *= (double)f;

					if (entity2.onGround) {
						entity2.motionY *= -0.8999999761581421D;
					}

				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateClient(ItemStack is, World world, EntityPlayer player) {

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

		if (tick >= 20 && tick % 20 == 0) {
			MovingObjectPosition entity = UtilSMT.LookOBJ.look(1.0F, 25.0F, true);

			if (entity != null) {
				if (entity.entityHit != null && entity.typeOfHit == MovingObjectType.ENTITY) {

					double pos_x = entity.entityHit.posX;
					double pos_y = entity.entityHit.posY;
					double pos_z = entity.entityHit.posZ;
					world.spawnParticle("reddust", pos_x, pos_y, pos_z, 0.0D, 255.0D, 0.0D);

					CoreSMT.network.sendToServer(new MessageInteractionEntity(entity.entityHit.getEntityId()));
				}
				if (entity.typeOfHit == MovingObjectType.BLOCK) {

					int pos_x = entity.blockX;
					int pos_y = entity.blockY;
					int pos_z = entity.blockZ;

					CoreSMT.network.sendToServer(new MessageInteractionBlock(pos_x, pos_y, pos_z));
				}

			}

		}

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;
		/*
		MovingObjectPosition entity = UtilSMT.LookOBJ.look(0.5F, 25.0F, true);

		if (entity != null) {
			if (isPress) {
				if (entity.entityHit != null && entity.typeOfHit == MovingObjectType.ENTITY) {

					double pos_x = entity.entityHit.posX;
					double pos_y = entity.entityHit.posY;
					double pos_z = entity.entityHit.posZ;
					world.spawnParticle("reddust", pos_x, pos_y, pos_z, 0.0D, 255.0D, 0.0D);

					PackMagic.network.sendToServer(new MessageInteractionEntity(entity.entityHit.getEntityId(), 1));
				}
				if (entity.typeOfHit == MovingObjectType.BLOCK) {

					int pos_x = entity.blockX;
					int pos_y = entity.blockY;
					int pos_z = entity.blockZ;

					PackMagic.network.sendToServer(new MessageInteractionBlock(pos_x, pos_y, pos_z, 1));
				}

			}
		}
		 */
	}

	public void left(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void interactionWithEntity(ItemStack is, World world, EntityPlayer player, Entity entity) {
		magicAct1(is, world, player, entity);
		magicAct2(is, world, player, entity);
	}

	public static void magicAct1(ItemStack is, World world, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityItem) {
			EntityItem item_entity = (EntityItem)entity;
			ItemStack is_entity = item_entity.getEntityItem();

			double pos_x = item_entity.posX;
			double pos_y = item_entity.posY;
			double pos_z = item_entity.posZ;
			float light = world.getLightBrightness(MathHelper.floor_double(pos_x), MathHelper.floor_double(pos_y), MathHelper.floor_double(pos_z));

			//System.out.println(light);

			if (world.canBlockSeeTheSky(MathHelper.floor_double(pos_x), MathHelper.floor_double(pos_y), MathHelper.floor_double(pos_z))) {

				if (light >= 0.9F) {

					magicFried1(item_entity, 
							new ItemStack(Items.beef, 1), 
							new ItemStack(Items.cooked_beef, 1));

					magicFried1(item_entity, 
							new ItemStack(Items.porkchop, 1), 
							new ItemStack(Items.cooked_porkchop, 1));

					magicFried1(item_entity, 
							new ItemStack(Items.chicken, 1), 
							new ItemStack(Items.cooked_chicken, 1));
				}

				if (light >= 0.8F) {

					magicFried1(item_entity, 
							new ItemStack(Items.fish, 1), 
							new ItemStack(Items.cooked_fished, 1));

					magicFried1(item_entity, 
							new ItemStack(Items.potato, 1), 
							new ItemStack(Items.baked_potato, 1));

				}

			}

			double d0 = 5.0D;

			AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(pos_x, pos_y, pos_z, pos_x + 1.0D, pos_y + 1.0D, pos_z + 1.0D).expand(d0, d0, d0);
			List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			Iterator iterator = list.iterator();
			Entity entity2;

			while(iterator.hasNext()) {
				entity2 = (Entity)iterator.next();

				if (entity2 != null) {

					if (entity2 instanceof EntityItem) {
						EntityItem item_entity2 = (EntityItem)entity2;
						ItemStack is_entity2 = item_entity2.getEntityItem();

						if (is_entity2 != null && item_entity.getEntityId() != item_entity2.getEntityId()) {

							//System.out.println(is_entity.getDisplayName());
							//System.out.println(is_entity2.getDisplayName());

							magicCraft1(item_entity, item_entity2, 
									new ItemStack(Items.stick, 1),
									new ItemStack(Items.blaze_powder, 3),
									new ItemStack(Items.blaze_rod));

						}

					}

				}
			}
			/*
			Entity[] entity_list = new Entity[1024];

			for (int i = 0; i < list.size(); ++i) {
				Entity entity1 = (Entity)list.get(i);
				if (entity1 != null) {
					entity_list[i] = entity1;
					System.out.println(entity1);
				}
			}
			 */
		}

		if (entity instanceof EntityCreature) {

			world.playSoundEffect(player.posX, player.posY, player.posZ, "mob.endermen.portal", 1.0F, 1.0F);
			world.playSoundEffect(entity.posX, entity.posY, entity.posZ, "mob.endermen.portal", 1.0F, 1.0F);

			entity.setPosition(player.posX, player.posY, player.posZ);

		}

	}

	public static void magicCraft1(EntityItem item_entity_a, EntityItem item_entity_b, 
			ItemStack element_a, ItemStack element_b, ItemStack out) {
		ItemStack is_entity_a = item_entity_a.getEntityItem();
		ItemStack is_entity_b = item_entity_b.getEntityItem();

		if (is_entity_a.getItem() == element_a.getItem() && is_entity_a.stackSize >= element_a.stackSize && 
				is_entity_a.getItemDamage() >= element_a.getItemDamage() && 
				is_entity_b.getItem() == element_b.getItem() && is_entity_b.stackSize >= element_b.stackSize && 
				is_entity_b.getItemDamage() >= element_b.getItemDamage()) {

			if (is_entity_a.getTagCompound() != null) {
				out.setTagCompound(is_entity_a.getTagCompound());
			}
			else if (is_entity_b.getTagCompound() != null) {
				out.setTagCompound(is_entity_b.getTagCompound());
			}

			if (is_entity_a.stackSize > element_a.stackSize) is_entity_a.stackSize -= element_a.stackSize; 
			else item_entity_a.setDead();
			if (is_entity_b.stackSize > element_b.stackSize) is_entity_b.stackSize -= element_b.stackSize; 
			else item_entity_b.setDead();

			UtilSMT.UtilWorld.dropItem(item_entity_a.worldObj, item_entity_a.posX, item_entity_a.posY, item_entity_a.posZ, out);

			PackMagic.network.sendToAllAround(new MessagePuff(2, item_entity_a.posX, item_entity_a.posY, item_entity_a.posZ), 
					new NetworkRegistry.TargetPoint(item_entity_a.dimension, item_entity_a.posX, item_entity_a.posY, item_entity_a.posZ, 18.5D));
			//break;
		}

	}

	public static void magicFried1(EntityItem item_entity_a, ItemStack in, ItemStack out) {
		ItemStack is_entity_a = item_entity_a.getEntityItem();

		if (is_entity_a.getItem() == in.getItem() && is_entity_a.stackSize >= in.stackSize && 
				is_entity_a.getItemDamage() >= in.getItemDamage()) {

			if (is_entity_a.getTagCompound() != null) {
				out.setTagCompound(is_entity_a.getTagCompound());
			}

			if (is_entity_a.stackSize > in.stackSize) is_entity_a.stackSize -= in.stackSize; 
			else item_entity_a.setDead();

			UtilSMT.UtilWorld.dropItem(item_entity_a.worldObj, item_entity_a.posX, item_entity_a.posY, item_entity_a.posZ, out);

			PackMagic.network.sendToAllAround(new MessagePuff(3, item_entity_a.posX, item_entity_a.posY, item_entity_a.posZ), 
					new NetworkRegistry.TargetPoint(item_entity_a.dimension, item_entity_a.posX, item_entity_a.posY, item_entity_a.posZ, 18.5D));
			//break;
		}

	}

	public static void magicAct2(ItemStack is, World world, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityItem) {
			EntityItem item_entity = (EntityItem)entity;
			ItemStack is_entity = item_entity.getEntityItem();

			double pos_x = entity.posX;
			double pos_y = entity.posY;
			double pos_z = entity.posZ;

			if (is_entity != null) {
				//------------------------------------------------------------------------------------
				if (is_entity.getItem() == Items.coal && 
						is_entity.getItemDamage() == 0 && 
						is_entity.stackSize == is_entity.getMaxStackSize()) {

					ItemStack is_new = new ItemStack(Items.diamond);

					if (is_entity.getTagCompound() != null)
						is_new.setTagCompound(is_entity.getTagCompound());

					item_entity.setDead();

					UtilSMT.UtilWorld.dropItem(world, pos_x, pos_y, pos_z, is_new);

				}
				//------------------------------------------------------------------------------------
				if (is_entity.getItem() == Items.book && is_entity.stackSize == 3 && 
						world.getBlock((int)pos_x, (int)pos_y - 1, (int)pos_z) == Blocks.planks) {


					if (is_entity.getTagCompound() != null) {
						ItemStack is_new = new ItemStack(Items.paper);
						is_new.setTagCompound(is_entity.getTagCompound());
						UtilSMT.UtilWorld.dropItem(world, pos_x, pos_y, pos_z, is_new);
					}

					item_entity.setDead();

					world.setBlock((int)pos_x, (int)pos_y - 1, (int)pos_z, Blocks.bookshelf);

				}
				//------------------------------------------------------------------------------------
				if (is_entity.getItem() == Item.getItemFromBlock(Blocks.sponge)) {
					for (int x_i = -5; x_i <= 5; x_i++) {
						for (int y_i = -5; y_i <= 5; y_i++) {
							for (int z_i = -5; z_i <= 5; z_i++) {
								if (world.getBlock((int)pos_x + x_i, (int)pos_y + y_i, (int)pos_z + z_i).getMaterial() == 
										Material.water) {
									world.setBlockToAir((int)pos_x + x_i, (int)pos_y + y_i, (int)pos_z + z_i);
								}
							}
						}
					}
				}
				//------------------------------------------------------------------------------------
			}

		}

	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onRightClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isRightClick = isPress;

		MovingObjectPosition block = UtilSMT.LookOBJ.block(1.0F, 25.0F, true);
		if (block != null) {
			if (isPress) {
				System.out.println(block.toString());
				if (block.typeOfHit == MovingObjectType.BLOCK) {

					int pos_x = block.blockX;
					int pos_y = block.blockY;
					int pos_z = block.blockZ;
					//world.spawnParticle("reddust", pos_x, pos_y, pos_z, 0.0D, 0.0D, 255.0D);

					CoreSMT.network.sendToServer(new MessageInteractionBlock(pos_x, pos_y, pos_z));
				}
			}
			//world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 255.0D);
		}
	}

	public void right(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	@Override
	public void interactionWithBlock(ItemStack is, World world, EntityPlayer player, int x, int y, int z) {
		if (!world.isAirBlock(x, y, z)) {
			Block block = world.getBlock(x, y, z);

			UtilSMT.UtilWorld.setBiome(BiomeGenBase.desert, world, x, z);

			blockAct1(is, world, player, block, x, y, z);
			blockAct2(is, world, player, block, x, y, z);
		}
	}

	public static void blockAct1(ItemStack is, World world, EntityPlayer player, Block block, int x, int y, int z) {

		if (block == Blocks.water) {
			world.setBlock(x, y, z, Blocks.ice);
		}

		//if (block == Blocks.flowing_water) {}//not work

		if (block == Blocks.ice) {
			ItemStack is_new = new ItemStack(Items.snowball, 1);
			UtilSMT.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlock(x, y, z, Blocks.water);
		}

		if (block == Blocks.lava) {
			world.setBlock(x, y, z, Blocks.obsidian);
		}

		//if (block == Blocks.flowing_lava) {}//not work

		if (block == Blocks.obsidian) {
			world.setBlock(x, y, z, Blocks.lava);
		}

		if (block == Blocks.bookshelf) {
			ItemStack is_new = new ItemStack(Items.book, 3);
			UtilSMT.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlock(x, y, z, Blocks.planks);
		}

		if (block == Blocks.sapling) {
			ItemStack is_new = new ItemStack(
					(world.getBlockMetadata(x, y, z) < 4 ? Blocks.leaves : Blocks.leaves2), 1, 
					(world.getBlockMetadata(x, y, z) < 4 ? 
							world.getBlockMetadata(x, y, z) : (world.getBlockMetadata(x, y, z) - 4)));

			UtilSMT.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlock(x, y, z, Blocks.deadbush);
		}

		if (block == Blocks.log) {
			ItemStack is_new = new ItemStack(Blocks.planks, 4, world.getBlockMetadata(x, y, z));
			UtilSMT.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlockToAir(x, y, z);
		}

		if (block == Blocks.log2) {
			ItemStack is_new = new ItemStack(Blocks.planks, 4, world.getBlockMetadata(x, y, z) + 4);
			UtilSMT.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlockToAir(x, y, z);
		}

		double d0 = 1.0D;

		AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).expand(d0, d0, d0);
		List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
		Iterator iterator = list.iterator();
		Entity entity = null;
		//EntityItem entity_item = null;

		while(iterator.hasNext()) {
			entity = (Entity)iterator.next();

			if (entity instanceof EntityItem) {
				EntityItem item_entity = (EntityItem)entity;
				ItemStack is_entity = item_entity.getEntityItem();

				if (is_entity != null) {

					if (block == Blocks.stone) {

						if (is_entity.getItem() == Items.coal && is_entity.getItemDamage() == 0 && is_entity.stackSize >= 9) {
							world.setBlock(x, y, z, Blocks.coal_ore);
							if (is_entity.stackSize == 9) entity.setDead();
							else is_entity.stackSize -= 9;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

						if (is_entity.getItem() == Items.coal && is_entity.getItemDamage() == 1 && is_entity.stackSize >= 16) {
							world.setBlock(x, y, z, Blocks.coal_ore);
							if (is_entity.stackSize == 16) entity.setDead();
							else is_entity.stackSize -= 16;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

						if (is_entity.getItem() == Items.diamond && is_entity.stackSize >= 6) {
							world.setBlock(x, y, z, Blocks.diamond_ore);
							if (is_entity.stackSize == 6) entity.setDead();
							else is_entity.stackSize -= 6;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

						if (is_entity.getItem() == Items.iron_ingot && is_entity.stackSize >= 2) {
							world.setBlock(x, y, z, Blocks.iron_ore);
							if (is_entity.stackSize == 2) entity.setDead();
							else is_entity.stackSize -= 2;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

						if (is_entity.getItem() == Items.gold_ingot && is_entity.stackSize >= 2) {
							world.setBlock(x, y, z, Blocks.gold_ore);
							if (is_entity.stackSize == 2) entity.setDead();
							else is_entity.stackSize -= 2;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

					}

					if (block == Blocks.cobblestone) {

						if (is_entity.getItem() == Item.getItemFromBlock(Blocks.grass) && is_entity.stackSize >= 1) {
							world.setBlock(x, y, z, Blocks.mossy_cobblestone);
							world.setBlock(x, y + 1, z, Blocks.dirt);
							if (is_entity.stackSize == 1) entity.setDead();
							else is_entity.stackSize -= 1;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

					}

					if (block == Blocks.deadbush) {

						if (is_entity.getItem() == Item.getItemFromBlock(Blocks.leaves) && is_entity.stackSize >= 1) {
							world.setBlock(x, y, z, Blocks.sapling);
							world.setBlockMetadataWithNotify(x, y, z, is_entity.getItemDamage(), 3);
							if (is_entity.stackSize == 1) entity.setDead();
							else is_entity.stackSize -= 1;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

						if (is_entity.getItem() == Item.getItemFromBlock(Blocks.leaves2) && is_entity.stackSize >= 1) {
							world.setBlock(x, y, z, Blocks.sapling);
							world.setBlockMetadataWithNotify(x, y, z, is_entity.getItemDamage() + 4, 3);
							if (is_entity.stackSize == 1) entity.setDead();
							else is_entity.stackSize -= 1;
							PackMagic.network.sendToAllAround(new MessagePuff(1, entity.posX, entity.posY, entity.posZ), 
									new NetworkRegistry.TargetPoint(player.dimension, entity.posX, entity.posY, entity.posZ, 18.5D));
							break;
						}

					}

				}

			}

		}

	}

	public static void blockAct2(ItemStack is, World world, EntityPlayer player, Block block, int x, int y, int z) {

	}

	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onReloadTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onReloadClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isReload = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onChargeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onChargeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isCharge = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isMode = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onActionTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onActionClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isAction = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeInTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeInClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeIn = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public void onModeOutTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onModeOutClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isModeOut = isPress;
	}
	//--------------------------------------------------------------------------------------------------------------
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		/*
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
		 */
		is.damageItem(1, player);
		return super.onItemRightClick(is, world, player);
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
