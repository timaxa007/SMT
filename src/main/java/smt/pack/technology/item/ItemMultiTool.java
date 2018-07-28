package smt.pack.technology.item;

import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import smt.pack.technology.SMTTechnology;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMultiTool extends smt.pack.technology.api.object.ItemElectricDummy {

	private static final Set effective_with_blocks = Sets.newHashSet(new Block[] {
			/*pickaxe*/Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.obsidian,
			/*spade*/Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium,
			/*axe*/Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin,
			/*sword*/Blocks.web, Blocks.wool
	});

	private float efficiencyOnProperMaterial;
	private float damageVsEntity;
	private Item.ToolMaterial toolMaterial;

	public ItemMultiTool() {
		super();
		//setCreativeTab(CreativeTabs.tabTools);
		toolMaterial = Item.ToolMaterial.IRON;
		setMaxDamage(toolMaterial.getMaxUses() * 5);
		efficiencyOnProperMaterial = toolMaterial.getEfficiencyOnProperMaterial();
		damageVsEntity = efficiencyOnProperMaterial + toolMaterial.getDamageVsEntity();
		setContainerItem(this);
		setMaxDamage(1000);
		setMaxStackSize(1);
		setNoRepair();
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		if (itemStack.getItemDamage() >= 0) {
			itemStack.setItemDamage(itemStack.getItemDamage() + 1);
			return itemStack;
		}
		return super.getContainerItem(itemStack);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entity) {
		return Items.shears.itemInteractionForEntity(itemStack, player, entity);
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemStack, int x, int y, int z, EntityPlayer player) {
		return Items.shears.onBlockStartBreak(itemStack, x, y, z, player);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(x, y, z, side, itemStack)) return false;
		else {
			UseHoeEvent event = new UseHoeEvent(player, itemStack, world, x, y, z);
			if (MinecraftForge.EVENT_BUS.post(event)) return false;

			if (event.getResult() == Result.ALLOW) {
				itemStack.damageItem(1, player);
				return true;
			}

			Block block = world.getBlock(x, y, z);

			if (side != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt)) {
				Block block1 = Blocks.farmland;
				world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

				if (world.isRemote) {
					return true;
				} else {
					world.setBlock(x, y, z, block1);
					itemStack.damageItem(2, player);
					return true;
				}
			} else {
				return false;
			}
		}
	}

	@Override
	//canHarvestBlock
	public boolean func_150897_b(Block block) {
		return effective_with_blocks.contains(block);
	}

	@Override
	//getDigSpeed
	public float func_150893_a(ItemStack itemStack, Block block) {
		return effective_with_blocks.contains(block) ? efficiencyOnProperMaterial : super.func_150893_a(itemStack, block);
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase entity1, EntityLivingBase entity2) {
		itemStack.damageItem(2, entity2);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {

		}
		if (block.getBlockHardness(world, x, y, z) == 0.0F) {
			itemStack.damageItem(1, entity);
		}
		itemStack.damageItem(3, entity);
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D() {
		return true;
	}

	public Item.ToolMaterial getToolMaterial() {
		return toolMaterial;
	}
	/*
	public String getToolMaterialName() {
		return getToolMaterial().toString();
	}
	 */
	public float getDamageVsEntity() {
		return getToolMaterial().getDamageVsEntity();
	}

	@Override
	public int getItemEnchantability() {
		return getToolMaterial().getEnchantability();
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2) {
		ItemStack mat = getToolMaterial().getRepairItemStack();
		if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, itemStack2, false)) return true;
		return super.getIsRepairable(itemStack1, itemStack2);
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)getDamageVsEntity(), 0));
		return multimap;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
		if (isTagEPT(itemStack)) {
			NBTTagCompound eet = checkEPT(itemStack);
			if (getEnergy(itemStack) >= 0) {
				String text = "Energy: " + getEnergy(itemStack);
				if (getEnergyMax(itemStack) >= 0) 
					text += " / " + getEnergyMax(itemStack);
				list.add(text + ".");
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT(id, 0, 10000));
		list.add(addNBT(id, 10000, 10000));
	}

	public ItemStack addNBT(Item id, int i, int max) {
		return setEnergyMax(new ItemStack(id), i, max);
	}

	@Override
	public int getRateMax() {
		return 3;//For testing
	}

	@Override
	public boolean isCharging(ItemStack item) {
		return true;
	}

}
