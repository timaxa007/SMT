package smt.pack.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;

public abstract class FileNBT {

	final File directory;
	final String name;

	public FileNBT(File directory, String name) {
		this.directory = directory;
		this.name = name;
	}

	public File getDirectory() {
		return directory;
	}

	public void loadData() {
		try {
			File file = new File(directory, name + ".nbt");
			if (file != null && file.exists()) {
				//System.out.println(file.toString());
				FileInputStream fileinputstream = new FileInputStream(file);
				NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(fileinputstream);
				fileinputstream.close();
				readFromNBT(nbttagcompound);
			}
		} catch (Exception e) {e.printStackTrace();}
	}

	public void saveData() {
		try {
			File file = new File(directory, name + ".nbt");
			if (file.getParentFile() != null) file.getParentFile().mkdirs();
			if (file != null) {
				//System.out.println(file.toString());
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				writeToNBT(nbttagcompound);

				FileOutputStream fileoutputstream = new FileOutputStream(file);
				CompressedStreamTools.writeCompressed(nbttagcompound, fileoutputstream);
				fileoutputstream.close();
			}
		} catch (Exception e) {e.printStackTrace();}
	}

	public abstract void readFromNBT(NBTTagCompound nbt);

	public abstract void writeToNBT(NBTTagCompound nbt);

}
