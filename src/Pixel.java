public class Pixel {
    private int red,green,blue;

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
    public Pixel() {
        red = 255;
        green = 255;
        blue = 255;
    }
    public void changeRGB(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }
    public void printRGB() {
        System.out.println(red + " " + green + " " + blue);
    }
    public Pixel(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }
}
