package timaxa007.pack.magic.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import timaxa007.module.control_button.api.IActionMouse;
import timaxa007.module.control_button.api.IActionPrimaryKey;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.packet.MessageInteractionBlock;
import timaxa007.pack.magic.packet.MessageInteractionEntity;
import timaxa007.tms.util.ModifiedItem;
import timaxa007.tms.util.UtilTMS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffs extends ModifiedItem implements IActionMouse, IActionPrimaryKey {
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
	@SideOnly(Side.CLIENT)
	public void onLeftClickTickClient(ItemStack is, World world, EntityPlayer player, int tick) {

	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		isLeftClick = isPress;

		//if (isPress) {
		MovingObjectPosition entity = UtilTMS.LookOBJ.getEntity(1.0F, 7.0F, true);

		if (entity != null) {
			if (isPress) {
				//System.out.println(entity.toString());
				if (entity.entityHit != null && entity.typeOfHit == MovingObjectType.ENTITY) {

					double pos_x = entity.entityHit.posX;
					double pos_y = entity.entityHit.posY;
					double pos_z = entity.entityHit.posZ;
					world.spawnParticle("reddust", pos_x, pos_y, pos_z, 0.0D, 255.0D, 0.0D);

					PackMagic.network.sendToServer(new MessageInteractionEntity(entity.entityHit.getEntityId(), 1));
				}
			}
			//world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 255.0D, 0.0D);
		}
	}

	public void left(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	/**For Testing.**/
	public void act1(ItemStack is, World world, EntityPlayer player, Entity entity) {
		//magicAct1(is, world, player, entity);
		magicAct2(is, world, player, entity);
	}

	public static void magicAct1(ItemStack is, World world, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityItem) {
			EntityItem item_entity = (EntityItem)entity;
			ItemStack is_entity = item_entity.getEntityItem();

			double pos_x = entity.posX;
			double pos_y = entity.posY;
			double pos_z = entity.posZ;

			double d0 = 5.0D;

			AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(pos_x, pos_y, pos_z, (double)(pos_x + 1), (double)(pos_y + 1), (double)(pos_z + 1)).expand(d0, d0, d0);
			List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			Iterator iterator = list.iterator();
			Entity entity2;

			EntityItem entity_a = null;
			EntityItem entity_b = null;
			EntityItem entity_c = null;

			while(iterator.hasNext()) {
				entity2 = (Entity)iterator.next();

				if (entity2 instanceof EntityItem) {
					EntityItem item_entity2 = (EntityItem)entity2;
					ItemStack is_entity2 = item_entity.getEntityItem();

					if (is_entity2 != null) {

						if (is_entity2.getItem() == Items.stick) {entity_a = item_entity2;}
						if (is_entity2.getItem() == Items.book) {entity_b = item_entity2;}
						if (is_entity2.getItem() == Items.blaze_powder) {entity_c = item_entity2;}

					}

				}

			}

			if (entity_a != null && entity_c != null) {

				ItemStack is_entity_a = entity_a.getEntityItem();
				ItemStack is_entity_c = entity_c.getEntityItem();

				ItemStack is_new = new ItemStack(Items.blaze_rod);

				if (is_entity_a.getTagCompound() != null)
					is_new.setTagCompound(is_entity_a.getTagCompound());
				else if (is_entity_c.getTagCompound() != null)
					is_new.setTagCompound(is_entity_c.getTagCompound());

				entity_a.setDead();
				entity_c.setDead();

				UtilTMS.UtilWorld.dropItem(world, pos_x, pos_y, pos_z, is_new);

			}

			if (entity_b != null) {

				ItemStack is_entity_b = entity_b.getEntityItem();

				ItemStack is_new = new ItemStack(Items.book);
				NBTTagCompound nbt_new = new NBTTagCompound();

				if (is_entity_b.getTagCompound() != null)
					is_new.setTagCompound(is_entity_b.getTagCompound());

				entity_b.setDead();

				UtilTMS.UtilWorld.dropItem(world, pos_x, pos_y, pos_z, is_new);

			}

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

					UtilTMS.UtilWorld.dropItem(world, pos_x, pos_y, pos_z, is_new);

				}
				//------------------------------------------------------------------------------------
				if (is_entity.getItem() == Items.book && is_entity.stackSize == 3 && 
						world.getBlock((int)pos_x, (int)pos_y - 1, (int)pos_z) == Blocks.planks) {


					if (is_entity.getTagCompound() != null) {
						ItemStack is_new = new ItemStack(Items.paper);
						is_new.setTagCompound(is_entity.getTagCompound());
						UtilTMS.UtilWorld.dropItem(world, pos_x, pos_y, pos_z, is_new);
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

		MovingObjectPosition block = UtilTMS.LookOBJ.getBlock(1.0F, 12.0F, true);
		if (block != null) {
			if (isPress) {
				System.out.println(block.toString());
				if (block.typeOfHit == MovingObjectType.BLOCK) {

					int pos_x = block.blockX;
					int pos_y = block.blockY;
					int pos_z = block.blockZ;
					//world.spawnParticle("reddust", pos_x, pos_y, pos_z, 0.0D, 0.0D, 255.0D);

					PackMagic.network.sendToServer(new MessageInteractionBlock(pos_x, pos_y, pos_z, 1));
				}
			}
			//world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 255.0D);
		}
	}

	public void right(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void actBlock1(ItemStack is, World world, EntityPlayer player, Block block, int x, int y, int z) {
		blockAct1(is, world, player, block, x, y, z);
		//blockAct2(is, world, player, block, x, y, z);
	}

	public static void blockAct1(ItemStack is, World world, EntityPlayer player, Block block, int x, int y, int z) {

		if (block == Blocks.water) {
			world.setBlock(x, y, z, Blocks.ice);
		}

		//if (block == Blocks.flowing_water) {}//not work

		if (block == Blocks.ice) {
			ItemStack is_new = new ItemStack(Items.snowball, 1);
			UtilTMS.UtilWorld.dropItem(world, x, y, z, is_new);
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
			UtilTMS.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlock(x, y, z, Blocks.planks);
		}

		if (block == Blocks.sapling) {
			ItemStack is_new = new ItemStack(
					(world.getBlockMetadata(x, y, z) < 4 ? Blocks.leaves : Blocks.leaves2), 1, 
					(world.getBlockMetadata(x, y, z) < 4 ? 
							world.getBlockMetadata(x, y, z) : (world.getBlockMetadata(x, y, z) - 4)));

			UtilTMS.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlock(x, y, z, Blocks.deadbush);
		}

		if (block == Blocks.log) {
			ItemStack is_new = new ItemStack(Blocks.planks, 4, world.getBlockMetadata(x, y, z));
			UtilTMS.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlockToAir(x, y, z);
		}

		if (block == Blocks.log2) {
			ItemStack is_new = new ItemStack(Blocks.planks, 4, world.getBlockMetadata(x, y, z) + 4);
			UtilTMS.UtilWorld.dropItem(world, x, y, z, is_new);
			world.setBlockToAir(x, y, z);
		}

		double d0 = 5.0D;

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
							break;
						}

						if (is_entity.getItem() == Items.coal && is_entity.getItemDamage() == 1 && is_entity.stackSize >= 16) {
							world.setBlock(x, y, z, Blocks.coal_ore);
							if (is_entity.stackSize == 16) entity.setDead();
							else is_entity.stackSize -= 16;
							break;
						}

						if (is_entity.getItem() == Items.diamond && is_entity.stackSize >= 6) {
							world.setBlock(x, y, z, Blocks.diamond_ore);
							if (is_entity.stackSize == 6) entity.setDead();
							else is_entity.stackSize -= 6;
							break;
						}

						if (is_entity.getItem() == Items.iron_ingot && is_entity.stackSize >= 2) {
							world.setBlock(x, y, z, Blocks.iron_ore);
							if (is_entity.stackSize == 2) entity.setDead();
							else is_entity.stackSize -= 2;
							break;
						}

						if (is_entity.getItem() == Items.gold_ingot && is_entity.stackSize >= 2) {
							world.setBlock(x, y, z, Blocks.gold_ore);
							if (is_entity.stackSize == 2) entity.setDead();
							else is_entity.stackSize -= 2;
							break;
						}

					}

					if (block == Blocks.cobblestone) {

						if (is_entity.getItem() == Item.getItemFromBlock(Blocks.grass) && is_entity.stackSize >= 1) {
							world.setBlock(x, y, z, Blocks.mossy_cobblestone);
							world.setBlock(x, y + 1, z, Blocks.dirt);
							if (is_entity.stackSize == 1) entity.setDead();
							else is_entity.stackSize -= 1;
							break;
						}

					}

					if (block == Blocks.deadbush) {

						if (is_entity.getItem() == Item.getItemFromBlock(Blocks.leaves) && is_entity.stackSize >= 1) {
							world.setBlock(x, y, z, Blocks.sapling);
							world.setBlockMetadataWithNotify(x, y, z, is_entity.getItemDamage(), 3);
							if (is_entity.stackSize == 1) entity.setDead();
							else is_entity.stackSize -= 1;
							break;
						}

						if (is_entity.getItem() == Item.getItemFromBlock(Blocks.leaves2) && is_entity.stackSize >= 1) {
							world.setBlock(x, y, z, Blocks.sapling);
							world.setBlockMetadataWithNotify(x, y, z, is_entity.getItemDamage() + 4, 3);
							if (is_entity.stackSize == 1) entity.setDead();
							else is_entity.stackSize -= 1;
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
		return is;
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
