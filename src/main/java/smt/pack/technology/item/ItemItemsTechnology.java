package smt.pack.technology.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import smt.pack.technology.SMTTechnology;

public class ItemItemsTechnology extends Item {

	public ItemItemsTechnology() {
		super();
		setMaxDamage(128);
	}
	/*
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int tick, boolean flag) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase entity_living = (EntityLivingBase)entity;
			if (entity_living.getActivePotionEffect(Potion.confusion) == null) {
				if (is.getMaxDamage() - itemStack.getItemDamage() <= 100) {
					entity_living.addPotionEffect(new PotionEffect(Potion.confusion.id, 20));
				}
			}
		}
	}
	 */
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		String name = world.getBlock(x, y, z).getUnlocalizedName();
		name = StatCollector.translateToLocal(name);
		world.setBlock(x, y, z, block);
		itemStack.damageItem(10, entity);
		System.out.println("onBlockDestroyed - " + block.getUnlocalizedName());
		return true;
	}
	/*
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null) {
			if (tile instanceof TileEntityBlocksTechnology) {
				TileEntityBlocksTechnology te = (TileEntityBlocksTechnology)tile;
				te.setActiveSlotsCapacity((byte)(te.getInventoryIn().getSizeInventory() - 1));
				return true;
			}
		}
		return false;
	}
	 */
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		//Если на стороне клиента, то идёт возвращение и код дальше не будет выполняться.
		if (world.isRemote) return false;

		//Если игрок не может ломать/строить
		//или не может использовать ItemStack в аргументе метода canPlayerEdit,
		//то идёт возвращение и код дальше не будет выполняться.
		if (!player.canPlayerEdit(x, y, z, side, itemStack)) return false;

		Block block = world.getBlock(x, y, z);//Берём блок по координатам
		int metadata = world.getBlockMetadata(x, y, z);//Берём метадату блока по координатам

		//Узнаём твёрдость блока по координатам и если она равно -1F,
		//то идёт возвращение и код дальше не будет выполняться.
		if (block.getBlockHardness(world, x, y, z) == -1F) return false;

		BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(x, y, z, world, block, metadata, player);
		MinecraftForge.EVENT_BUS.post(event);
		//Если в эвенте будет setCanceled(true),
		//то идёт возвращение и код дальше не будет выполняться.
		if (event.isCanceled()) return false;

		//Выпадения опыта из блока.
		block.dropXpOnBlockBreak(world, x, y, z, block.getExpDrop(world, metadata, 0));
		//Выпадения дропа из блока от имени игрока.
		block.harvestBlock(world, player, x, y, z, metadata);
		//Разрушаем блок с партиклами разрушения и со звуком разрушения,
		//а так-же блок замениться на воздух.
		//Аргумент false не даст выпасть (стандартный) дроп блока (он выпадает не от имени игрока).
		world.func_147480_a(x, y, z, false);
		return true;
	}

}
