package smt.pack.technology.tile.machine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import smt.pack.EntityLook;

public class ElectricPlacer extends ElectricMachine {

	int time = 0;
	int state_destroy = -1;
	public float yaw = 0F;
	public float pitch = 0F;

	public ElectricPlacer(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {

		if (time > 0) --time;

		if (time == 0) {
			place();
			time = 20 * 3;
		}
		/*
		if (!worldObj.isAirBlock(xCoord, yCoord - 1, zCoord)) {
			if (time % 10 == 0) ++state_destroy;
			if (state_destroy < 10)
				worldObj.destroyBlockInWorldPartially(0, xCoord, yCoord - 1, zCoord, state_destroy);
			else {
				state_destroy = -1;
				worldObj.func_147480_a(xCoord, yCoord - 1, zCoord, true);
			}
		}
		 */
	}

	public void place() {
		ItemStack itemStack = new ItemStack(Blocks.furnace);
		if (itemStack != null) {
			//if (itemStack != null && itemStack.getItem() instanceof ItemBlock) {
			//ItemBlock ib = (ItemBlock)itemStack.getItem();
			if (tile.getWorldObj() instanceof WorldServer) {
				/*
				float yaw = (getBlockMetadata() >= 0 && getBlockMetadata() < EntityLook.YAW.length ?
						(float)EntityLook.YAW[getBlockMetadata()] : 0F);
				float pitch = (getBlockMetadata() >= 0 && getBlockMetadata() < EntityLook.PITCH.length ?
						(float)EntityLook.PITCH[getBlockMetadata()] : 0F);
				 */
				FakePlayer player_fake = FakePlayerFactory.getMinecraft((WorldServer)tile.getWorldObj());
				player_fake.setPositionAndRotation((double)tile.xCoord + 0.5D, (double)tile.yCoord + 0.5D, (double)tile.zCoord + 0.5D, yaw, pitch);
				Vec3 vec31 = Vec3.createVectorHelper((double)tile.xCoord + 0.5D, (double)tile.yCoord + 0.5D, (double)tile.zCoord + 0.5D);
				Vec3 vec32 = null;
				int gh = 1;
				if (gh == 0) vec32 = vec31.addVector(1.0D, 0.0D, 0.0D);
				else if (gh == 1) vec32 = vec31.addVector(-1.0D, 0.0D, 0.0D);
				else if (gh == 2) vec32 = vec31.addVector(0.0D, 0.0D, -1.0D);
				else if (gh == 3) vec32 = vec31.addVector(0.0D, 0.0D, 1.0D);
				else if (gh == 4) vec32 = vec31.addVector(0.0D, 1.0D, 0.0D);
				else if (gh == 5) vec32 = vec31.addVector(0.0D, -1.0D, 0.0D);
				else vec32 = vec31.addVector(0.0D, 0.0D, 0.0D);
				//render(vec31, vec32);
				MovingObjectPosition mop = EntityLook.block(tile.getWorldObj(), vec31, vec32, false);
				//System.out.println(mop != null);
				if (mop != null) {

					int blockX = mop.blockX;
					int blockY = mop.blockY;
					int blockZ = mop.blockZ;
					int side = mop.sideHit;
					float hitX = (float)(mop.hitVec.xCoord - (double)blockX);
					float hitY = (float)(mop.hitVec.yCoord - (double)blockY);
					float hitZ = (float)(mop.hitVec.zCoord - (double)blockZ);

					int x = blockX;
					int y = blockY;
					int z = blockZ;

					switch(side) {
					case 0: --y;break;
					case 1: ++y;break;
					case 2: --z;break;
					case 3: ++z;break;
					case 4: --x;break;
					case 5: ++x;break;
					}

					//if (worldObj.isAirBlock(x, y, z)) {
					//Хотелось-бы чтобы этот метод использовать, но всё-же краши будут, все нормально не пофиксишь.
					//if (player_fake.theItemInWorldManager.activateBlockOrUseItem(player_fake, worldObj, is, blockX, blockY, blockZ, side, hitX, hitY, hitZ)) {
					//Не так полезен этот метод.
					//if (is.tryPlaceItemIntoWorld(player_fake, worldObj, blockX, blockY, blockZ, side, hitX, hitY, hitZ)) {
					//В итоге это использую.
					if (itemStack.getItem().onItemUse(itemStack, player_fake, tile.getWorldObj(), blockX, blockY, blockZ, side, hitX, hitY, hitZ)) {
						System.out.println("itemStack.stackSize = " + itemStack.stackSize);
						//--itemStack.stackSize;
					}

				}
				//}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private void render(Vec3 vec31, Vec3 vec32) {
		System.out.println("Vec31" + vec31.toString());
		System.out.println("Vec32" + vec32.toString());
		/*
		GL11.glColor3b((byte)127, (byte)0, (byte)0);
		GL11.glBegin(GL11.GL_POINT);
		GL11.glVertex3d(vec31.xCoord, vec31.yCoord, vec31.zCoord);
		GL11.glEnd();
		GL11.glColor3b((byte)0, (byte)0, (byte)127);
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex3d(vec31.xCoord, vec31.yCoord, vec31.zCoord);
		GL11.glVertex3d(vec32.xCoord, vec32.yCoord, vec32.zCoord);
		GL11.glColor3b((byte)0, (byte)0, (byte)0);
		 */
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
