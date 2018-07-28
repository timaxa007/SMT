package smt.pack.common.entity;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityCorpse extends Entity {

	private InventoryBasic inventory = new InventoryBasic("EntityCorpse", false, 9);
	public NBTTagCompound corpse_nbt = new NBTTagCompound();
	public String corpse_class;

	public EntityCorpse(World world) {
		super(world);
		setSize(1F, 1F);
	}

	@Override
	public void entityInit() {

	}

	public void setDrops(ArrayList<EntityItem> drops) {
		if (drops == null || drops.size() <= 0) return;
		inventory = new InventoryBasic("InventoryEntityCorpse", false, drops.size());
		for (int i = 0; i < drops.size(); ++i) {
			EntityItem entity_item = drops.get(i);
			if (entity_item.getEntityItem() != null) {
				inventory.setInventorySlotContents(i, entity_item.getEntityItem());
				System.out.println(entity_item.getEntityItem().toString());
			}
		}
	}

	@Override
	public boolean interactFirst(EntityPlayer player) {
		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			ItemStack item = inventory.getStackInSlot(i);
			if (item != null) {
				System.out.println(item.toString());
			}
		}
		this.setDead();
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return entity.boundingBox;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		corpse_class = nbt.getString("corpse_class");
		corpse_nbt = nbt.getCompoundTag("corpse_nbt");
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		nbt.setString("corpse_class", corpse_class);
		nbt.setTag("corpse_nbt", corpse_nbt);
	}

	public void setCorpse(EntityLivingBase to) {
		corpse_class = to.getClass().getName();
		to.writeEntityToNBT(corpse_nbt);
	}

}
