package smt.pack.magic.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import smt.pack.ActionInventory;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.inventory.EntityMagicChestContainer;
import smt.pack.magic.network.MessageOpenGuiEntityMagicChest;
import smt.pack.magic.network.MessageSyncNbtEntityMagicChest;

public class EntityMagicChest extends Entity {

	private IInventory inventoryEntityMagicChest = new InventoryBasic("InventoryEntityMagicChest", false, 9 * 3);

	public EntityMagicChest(World world) {
		super(world);
	}

	@Override
	public void entityInit() {
		setSize(1F, 1F);

	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (getInventory() != null) {
			/*
			for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
				ItemStack item = getInventory().getStackInSlot(i);
				if (item != null) System.out.println("i = " + i + " - " + item.toString() + ".");
			}
			 */
		}
	}

	@Override
	public boolean interactFirst(EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			SMTMagic.network.sendTo(getDescriptionPacket(), (EntityPlayerMP)player);
			player.openContainer = new EntityMagicChestContainer(this, player);
			MessageOpenGuiEntityMagicChest packetOpenGui = new MessageOpenGuiEntityMagicChest();
			packetOpenGui.entityID = this.getEntityId();
			SMTMagic.network.sendTo(packetOpenGui, (EntityPlayerMP)player);
		}
		/*
		if (worldObj.isRemote)
			Minecraft.getMinecraft().displayGuiScreen(new EntityMagicChestGui(this, player));
		player.openContainer = new EntityMagicChestContainer(this, player);
		 */
		return true;
	}
	/*
	@Override
	public boolean canTriggerWalking() {
		return false;
	}
	 */
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return entity.boundingBox;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !isDead;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource dmg_src, float f) {
		setDead();
		return true;
	}

	public IInventory getInventory() {
		return inventoryEntityMagicChest;
	}

	public MessageSyncNbtEntityMagicChest getDescriptionPacket() {
		System.out.println("getDescriptionPacket");
		NBTTagCompound nbt = new NBTTagCompound();
		writeEntityToNBT(nbt);
		MessageSyncNbtEntityMagicChest packet = new MessageSyncNbtEntityMagicChest();
		packet.entityID = this.getEntityId();
		packet.nbt = nbt;
		return packet;
	}

	public void onDataPacket(MessageSyncNbtEntityMagicChest packet) {
		System.out.println("onDataPacket");
		readFromNBT(packet.nbt);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		inventoryEntityMagicChest = ActionInventory.readFromNBT(nbt, inventoryEntityMagicChest);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		ActionInventory.writeToNBT(nbt, inventoryEntityMagicChest);
	}

}
