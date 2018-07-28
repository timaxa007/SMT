package smt.pack;

import net.minecraft.block.Block;

public class UtilBlock {

	public static class BlockPosState {

		private BlockState state;
		private BlockPos pos;

		public BlockPosState(BlockState state, BlockPos pos) {
			this.state = state;
			this.pos = pos;
		}

		public BlockState getBlockState() {
			return state;
		}

		public BlockPos getBlockPos() {
			return pos;
		}

	}

	public static class BlockState {

		private Block block;
		private int metadata;

		public BlockState(Block block, int metadata) {
			this.block = block;
			this.metadata = metadata;
		}

		public Block getBlock() {
			return block;
		}

		public int getMetadata() {
			return metadata;
		}

	}

	public static class BlockPos {

		public int x;
		public int y;
		public int z;

		public BlockPos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

}
