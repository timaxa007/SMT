package smt.pack.magic.event;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.Cancelable;

public class CountUseManaEntityEvent extends net.minecraftforge.event.entity.EntityEvent {

	public final ItemStack held;
	public int count_use_mana;

	/**
	<b>CountUseManaEntityEvent</b> is fired when using mana.<br>
	<b>CountUseManaEntityEvent</b> вызывается при использовании маны.<br>
	<br>
	{@link #held} if null - in hand empty or no hand.<br>
	{@link #held} если null - в руке пусто или нет руки.<br>
	{@link #count_use_mana} amount consumed mana.<br>
	{@link #count_use_mana} количество потребляемой маны.<br>
	<br>
	This event is {@link Cancelable}.<br>
	If this event is canceled, the Entity does not allow mana.<br>
	Если это событие будет отменено, то Сущность не позволяет использовать ману.<br>
	<br>
	This event does not have a result. {@link HasResult}<br>
	Это событие не имеет результата. {@link HasResult}<br>
	<br>
	This event is fired on the {@link MinecraftForge#EVENT_BUS}.<br>
	Это событие вызывается для {@link MinecraftForge#EVENT_BUS}.
	**/
	public CountUseManaEntityEvent(Entity player, ItemStack held, int count_use_mana) {
		super(player);
		this.held = held;
		this.count_use_mana = count_use_mana;
	}

}
