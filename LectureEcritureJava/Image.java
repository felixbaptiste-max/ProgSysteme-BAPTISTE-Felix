import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Image {
    private int width;
    private int height;

    private int[][][] pixels;

    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}

    public Image(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[height][width][3];
    }

    public void setPixel(int x, int y, int r, int g, int b) {

        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixels[y][x][0] = r;
            pixels[y][x][1] = g;
            pixels[y][x][2] = b;
        }
    }

    public void save_txt(String filename) throws IOException {

        try (FileWriter writer = new FileWriter(filename)) {

            writer.write("P3\n");
            writer.write(width + " " + height + "\n");
            writer.write("255\n");

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    writer.write(
                        pixels[y][x][0] + " "
                        + pixels[y][x][1] + " "
                        + pixels[y][x][2] + " "
                    );
                }
                writer.write("\n");
            }
        }
    }
	
	public void write_bin(String filename) throws IOException {
		
		private final static int NB_PIXEL = this.getHeight * this.getWidth *
		
		byte[] tabByte = new byte[];
		
		try (FileWriter writer = new FileWriter(filename)) {
			
			writer.write("P3\n");
            writer.write(width + " " + height + "\n");
            writer.write("255\n");
			
			for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    writer.write(
                        pixels[y][x][0] + 
                        pixels[y][x][1] + 
                        pixels[y][x][2] 
                    );
                }
                writer.write("\n");
            }
		}
	}
	
	static public read_txt(String filename) throws IOException {
        try (BufferedReader lecture = new BufferedReader(new FileReader(filename))
		
		String ligne = lecture.readLine();
		
		ligne = lecture.readLine();
		String[] dimensions = ligne.trim().split("\\s+")
		int width = Integer.parseInt(dimensions[0]);
		int height = Integer.parseInt(dimensions[1]);
		
		ligne = lecture.readLine();
		
		Image image = new Image(width, height);
		
		for (int indice1 = 0; indice1 < height; indice1++) {
			ligne = lecture.readLine();
			String[] valeurs = ligne.trim().split("\\s+");
			
			for (int indice2 = 0; indice2 < width; indice2++) {
				int r = Integer.parseInt(valeurs[3 * x]);
				int r = Integer.parseInt(valeurs[3 * x + 1]);
				int r = Integer.parseInt(valeurs[3 * x + 2]);
				
				image.setPixel(indice1, indice2, r, g, b);
			}
		}
		
		return image;
	}
}
