package Objects;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

/**
 * The type Apple.
 */
public class Apple extends JComponent {
    private int width;
    private int height;
    private int xApple;
    private int yApple;
    private BufferedImage image;

    private final int UNIT_SIZE = 40;

    /**
     * Instantiates a new Apple.
     *
     * @param width  the width
     * @param height the height
     */
    public Apple(int width, int height) {
        this.width = width;
        this.height = height;
        newApple();
        getImage();
    }

    /**
     * New apple.
     */
    public void newApple(){
        Random random = new Random();
        xApple = random.nextInt((int)(width/UNIT_SIZE))*UNIT_SIZE;
        yApple = random.nextInt((int)(height/UNIT_SIZE))*UNIT_SIZE;
    }

    /**
     * Gets apple.
     *
     * @return the apple
     */
    public int getxApple() {
        return xApple;
    }

    /**
     * Gets apple.
     *
     * @return the apple
     */
    public int getyApple() {
        return yApple;
    }
    @Override
    public void paint(Graphics g) {

        System.out.println("painting");
        g.drawImage(image, this.xApple, this.yApple, UNIT_SIZE,
                UNIT_SIZE, null);
    }
    private void getImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/apple.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load the image");
        } finally {
        }
    }

    /**
     * Gets unit size.
     *
     * @return the unit size
     */
    public int getUNIT_SIZE() {
        return UNIT_SIZE;
    }

    /**
     * View.
     *
     * @param g the g
     */
    public void view(Graphics g) {
            g.drawImage(image, 100,
                    400,
                    UNIT_SIZE,
                    UNIT_SIZE, null);
        g.drawImage(image, 200,
                500,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 400,
                500,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 650,
                480,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 600,
                300,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 300,
                280,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 120,
                75,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 500,
                80,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 80,
                250,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 640,
                70,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 380,
                60,
                UNIT_SIZE,
                UNIT_SIZE, null);
    }

    public void endView(Graphics g) {
        g.drawImage(image, 60,
                400,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 700,
                370,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 200,
                500,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 400,
                550,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 650,
                480,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 670,
                220,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 300,
                120,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 120,
                75,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 500,
                80,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 80,
                250,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 640,
                70,
                UNIT_SIZE,
                UNIT_SIZE, null);
        g.drawImage(image, 380,
                60,
                UNIT_SIZE,
                UNIT_SIZE, null);
    }
}
