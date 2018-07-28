package smt.pack.magic.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.magic.SMTMagic;

public final class Items {

	public static Item
	itemsMagic,
	upgradeMana,
	bookSpell,
	spawnEntity,
	artifact,
	teleport,
	random,
	spell
	;

	public static final void init() {

		itemsMagic = new ItemItemsMagic().setUnlocalizedName("items_magic").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(itemsMagic, "item_items_magic");

		upgradeMana = new ItemUpgradeMana().setUnlocalizedName("upgrade_mana").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(upgradeMana, "item_upgrade_mana");

		bookSpell = new ItemBookSpell().setUnlocalizedName("book_spell").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(bookSpell, "item_book_spell");

		spawnEntity = new ItemSpawnEntity().setUnlocalizedName("spawn_entity").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(spawnEntity, "item_spawn_entity");

		artifact = new ItemArtifact().setUnlocalizedName("artifact").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(artifact, "item_artifact");

		teleport = new ItemTeleport().setUnlocalizedName("teleport").setCreativeTab(SMTMagic.tabMagic).setHasSubtypes(true).setMaxDamage(0);
		GameRegistry.registerItem(teleport, "item_teleport");

		random = new ItemRandom().setUnlocalizedName("random").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(random, "item_random");

		spell = new ItemSpell().setUnlocalizedName("spell").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerItem(spell, "item_spell");

	}

}
