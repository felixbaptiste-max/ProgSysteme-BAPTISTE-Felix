import java.io.FileWriter;
import java.io.IOException;

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
}
