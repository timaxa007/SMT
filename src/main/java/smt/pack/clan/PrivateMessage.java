package smt.pack.clan;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import smt.pack.common.util.FileNBT;

public class PrivateMessage {

	@Nonnull public static final PrivateMessage INSTANCE = new PrivateMessage();
	public static final String TAG = "private_message";

	ArrayList<FileNBT> list = new ArrayList<FileNBT>();

	public PrivateMessage() {

	}

	public void createPM(String username, String text) {
		
	}

	public void load() {
		System.out.println("\"" + TAG + "\" Loading.");



		System.out.println("\"" + TAG + "\" Loaded.");
	}

	public void save() {
		System.out.println("\"" + TAG + "\" Saving.");



		System.out.println("\"" + TAG + "\" Saved.");
	}

	public static File getDir() {
		return new File(MinecraftServer.getServer().worldServers[0].getSaveHandler().getWorldDirectory(), TAG);
	}

}
