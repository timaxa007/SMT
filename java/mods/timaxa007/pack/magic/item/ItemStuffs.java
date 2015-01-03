package mods.timaxa007.pack.magic.item;

import java.util.Iterator;
import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.tms.util.IActionKeyPrimary;
import mods.timaxa007.tms.util.IActionMouseKey;
import mods.timaxa007.tms.util.ItemActionKeyPrimary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
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
		double d0 = (double)(50);

		AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(d0, d0, d0);
		axisalignedbb.maxY = (double)world.getHeight();
		List list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
		Iterator iterator = list.iterator();
		Entity entity;

		System.out.println("x = " + ((double)player.posX + (Math.cos(player.rotationYaw) * 5)) + 
				", y = " + ((double)player.posY) + 
				", z = " + ((double)player.posZ + (Math.sin(player.rotationYaw) * 5)) + ".");

		while(iterator.hasNext()) {
			entity = (Entity)iterator.next();
			MovingObjectPosition target = new MovingObjectPosition(entity);
			System.out.println(target.toString());

			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityHugeExplodeFX(world, ((double)player.posX), ((double)player.posY), ((double)player.posZ), 0.0D, 0.0D, 0.0D));

			if (entity instanceof EntityPlayer) {
				if (entity == player) player.getFoodStats().addStats(2, 1.0F);
				//if (!world.isRemote) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 20 * 1));
			}

			else if (entity instanceof EntityLivingBase) {
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

			else if (entity instanceof EntityXPOrb) {
				int xpv = ((EntityXPOrb)entity).getXpValue();
				player.addExperience(xpv);
				entity.setDead();
				world.playSoundAtEntity(player, "random.orb", 0.1F, 0.5F + ((float)xpv * 0.02F));
			}

		}
		/*
		MovingObjectPosition target = new MovingObjectPosition(player);
		target = new MovingObjectPosition(player);
		if (target != null) {
			if (target.typeOfHit == MovingObjectType.BLOCK) {
				//Block block = target.typeOfHit.BLOCK;
				System.out.println(target.toString());
			}
			if (target.typeOfHit == MovingObjectType.ENTITY) {
				//Entity entity = target.typeOfHit.ENTITY;
				System.out.println(target.toString());
			}
		}
		 */
	}

	@Override
	public void onRightClick(ItemStack is, World world, EntityPlayer player, boolean isPress) {

		world.spawnParticle("reddust", 
				((double)player.posX + (Math.cos(player.rotationYaw) * 5)), 
				((double)player.posY + 0.75D), 
				((double)player.posZ + (Math.sin(player.rotationYaw) * 5)), 0.0D, 0.0D, 0.0D);

	}

	@Override
	public void onLeftClickTick(ItemStack is, World world, EntityPlayer player) {
		
	}

	@Override
	public void onRightClickTick(ItemStack is, World world, EntityPlayer player) {
		
	}

	@Override
	public void onHook(ItemStack is, World world, EntityPlayer player) {
		System.out.println("throwing - " + is.getDisplayName());
	}

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
    	list.add(StatCollector.translateToLocal("text.line1"));
    	list.add(StatCollector.translateToLocal("text.line2"));
    	list.add(StatCollector.translateToLocal("text.line3"));
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
