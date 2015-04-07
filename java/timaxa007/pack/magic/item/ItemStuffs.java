package timaxa007.pack.magic.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import timaxa007.module.control_button.trash.ItemPrimaryKey;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.packet.MessageInteractionEntity;
import timaxa007.tms.util.UtilTMS;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffs extends ItemPrimaryKey {

	public ItemStuffs(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setMaxStackSize(1);
		setMaxDamage(1024);
		setTextureName("timaxa007:stuffs");
		setFull3D();
	}

	@SideOnly(Side.CLIENT)
	public void onLeftClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onLeftClickClient(is, world, player, isPress);
		//if (isPress) {
		MovingObjectPosition entity = UtilTMS.LookOBJ.getMouseOver(1.0F, 7.0F, true);
		if (entity != null) {
			if (isPress) {
				System.out.println(entity.toString());
				if (entity.entityHit != null) {
					PackMagic.network.sendToServer(new MessageInteractionEntity(entity.entityHit.getEntityId(), 1));
				}
			}
			world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 255.0D);
		}
	}

	public void left(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	/**For Testing. This not work.**/
	public void act1(ItemStack is, World world, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityItem) {
			EntityItem item_entity = (EntityItem)entity;
			ItemStack is_entity = item_entity.getEntityItem();

			if (is_entity != null) {
				if (is_entity.getItem() == Items.stick && is_entity.stackSize == 1) {

					System.out.println(is_entity.getDisplayName());

					double pos_x = entity.posX;
					double pos_y = entity.posY;
					double pos_z = entity.posZ;

					double d0 = (double)(5);

					AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(pos_x, pos_y, pos_z, (double)(pos_x + 1), (double)(pos_y + 1), (double)(pos_z + 1)).expand(d0, d0, d0);
					axisalignedbb.maxY = (double)world.getHeight();
					List list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
					Iterator iterator = list.iterator();
					Entity entity2;

					while(iterator.hasNext()) {
						entity2 = (Entity)iterator.next();

						if (entity != null && entity2 != null && entity2 != entity) {

							if (entity2 instanceof EntityItem) {
								EntityItem item_entity2 = (EntityItem)entity;
								ItemStack is_entity2 = item_entity.getEntityItem();

								if (is_entity2 != null) {
									if (is_entity2.getItem() == Items.blaze_powder && is_entity2.stackSize == 3) {

										System.out.println(is_entity2.getDisplayName());

										NBTTagCompound nbt = is_entity.getTagCompound();
										is_entity = new ItemStack(Items.blaze_rod);
										is_entity.setTagCompound(nbt);
										UtilTMS.UtilWorld.dropItem(world, (int)pos_x, (int)pos_y, (int)pos_z, new ItemStack(Items.paper));
									}
								}

							}
						}

					}

				}
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void onRightClickClient(ItemStack is, World world, EntityPlayer player, boolean isPress) {
		super.onRightClickClient(is, world, player, isPress);
		MovingObjectPosition entity = Minecraft.getMinecraft().objectMouseOver;
		if (entity != null) {
			if (isPress) {
				System.out.println(entity.toString());
				if (entity.entityHit != null) {
					PackMagic.network.sendToServer(new MessageInteractionEntity(entity.entityHit.getEntityId(), 2));
				}
			}
			world.spawnParticle("reddust", player.posX, player.posY, player.posZ, 0.0D, 255.0D, 0.0D);
		}
	}

	public void right(ItemStack is, World world, EntityPlayer player, boolean isPress) {

	}

	public void act2(ItemStack is, World world, EntityPlayer player, Entity entity) {

	}

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
