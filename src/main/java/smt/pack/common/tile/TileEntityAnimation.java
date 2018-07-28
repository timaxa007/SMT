package smt.pack.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import smt.pack.common.animation.a3D.Animation3DCustom;
import smt.pack.common.animation.a3D.Animation3DPlay;

public class TileEntityAnimation extends TileEntity {

	@SideOnly(Side.CLIENT)
	public Animation3DCustom animation = new Animation3DCustom(100, false, null, null, null, null, null, null);
	@SideOnly(Side.CLIENT)
	public Animation3DPlay animation_play = new Animation3DPlay(animation);

	public TileEntityAnimation() {

	}

	public void updateEntity() {
		if (worldObj.isRemote)
			if (animation_play != null) animation_play.update();
	}

}
