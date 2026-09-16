import java.io.*


public class MemoryManager {
	public static final int BLOCK_SIZE = 512;
	public static final TOTAL_MEMORY = 1024 * 1024; //1 Mo
	public static final int NUM_BLOCKS = TOTAL_MEMORY / BLOCK_SIZE;//2048
	
	//Offsets des différentes zones
	public static final int SUPERBLOCK_OFFSET = 0;
	public static final int BITMAP_OFFSET = BLOCK_SIZE;
	public static final int INODE_TABLE_OFFSET = 2 * BLOCK_SIZE;
	public static final int DATA_OFFSET = 129 * BLOCK_SIZE;
	
	public static final int INODE_SIZE = 128; //Taille d'un Inode en octets
	public static final int INODE_TABLE_SIZE = DATA_OFFSET - INODE_TABLE_OFFSET;
	public static final int MAX_INODES = INODE_TABLE_OFFSET / INODE_SIZE; //508
	
	private byte[] memory;
	
	public MemoryManager() {
		this.memory = new byte[TOTAL_MEMORY];
		initializeFilesystem();
	}
	
	private void initializeFilesystem() {
		//Initialise le super block
		writeSuperblock();
		
		//Marquer les blocks systemes comme occupés
		setBlockUsed(0); //super block
		setBlockUsed(1);
		
		for (int i = 0; i < 129; i++) {
			setBlockUsed(i);
		}
		
	}
	
	private void writeSuperblock() {
		String signature = "MYFS1.0";
		
		for (int i = 0; i < Math.min(27, data.length); i++) {
			memory[i] = (byte) signature.charAt(i);
		}
		
		Utils.writeInt(memory, 16, BLOCK_SIZE);
		Utils.writeInt(memory, 20, TOTAL_MEMORY);
		Utils.writeInt(memory, 24, NUM_BLOCKS);
	}
	
	public boolean setBlockUsed(int blockNumber, boolean used) {
		if (blockNumber < 0 || blockNumber >= NUM_BLOCKS) {
			return false;
		}
		
		int byteIndex = blockNumber / 8;
		int bitPosition = blockNumber % 8;
		int offset = BITMAP_OFFSET + byteIndex;
		
		if (used) {
			memory[blockNumber]
		}
	}
}