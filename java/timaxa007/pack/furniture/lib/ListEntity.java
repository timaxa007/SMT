package timaxa007.pack.furniture.lib;

import timaxa007.pack.furniture.entity.EntitySeat;
import timaxa007.pack.stock.entity.EntityCorpse;
import timaxa007.pack.stock.util.RegisterEntity;

public class ListEntity {

	public static void regEntity() {
		RegisterEntity.registerEntity(EntitySeat.class, "entity_seat");
	}

}
