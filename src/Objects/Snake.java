package Objects;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The type Snake.
 */
public class Snake extends JComponent {
    private int width;
    private int height;
    private int[] x;
    private int[] y;
    private int bodyParts = 6;
    private static final int UNIT_SIZE = 40;
    private int applesEaten = 0;
    private char direction = 'R';
    private int NUM_OF_UNITS;
    private BufferedImage image;
    private BufferedImage image2;

    /**
     * Instantiates a new Snake.
     *
     * @param width  the width
     * @param height the height
     */
    public Snake(int width, int height) {
        this.width = width;
        this.height = height;
        NUM_OF_UNITS = (width*height) / (UNIT_SIZE*UNIT_SIZE);
        x = new int[NUM_OF_UNITS];
        y = new int[NUM_OF_UNITS];
        getImage();
    }

    /**
     * Restart snake.
     */
    public void restartSnake() {
        x = new int[NUM_OF_UNITS];
        y = new int[NUM_OF_UNITS];
        applesEaten = 0;
        bodyParts = 6;
        direction = 'R';
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int[] x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int[] y) {
        this.y = y;
    }

    /**
     * Move.
     */
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case 'U': {
                y[0] = y[0] - UNIT_SIZE;
                break;
            }
            case 'R': {
                x[0] = x[0] + UNIT_SIZE;
                break;
            }
            case 'D': {
                y[0] = y[0] + UNIT_SIZE;
                break;
            }
            case 'L': {
                x[0] = x[0] - UNIT_SIZE;
                break;
            }
        }
    }

    /**
     * Gets x.
     *
     * @param index the index
     * @return the x
     */
    public int getX(int index) {
        return this.x[index];
    }

    /**
     * Gets y.
     *
     * @param index the index
     * @return the y
     */
    public int getY(int index) {
        return this.y[index];
    }

    /**
     * Gets body parts.
     *
     * @return the body parts
     */
    public int getBodyParts() {
        return bodyParts;
    }

    /**
     * Gets apples eaten.
     *
     * @return the apples eaten
     */
    public int getApplesEaten() {
        return applesEaten;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public char getDirection() {
        return direction;
    }

    public void paint(Graphics g) {

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.drawImage(image, x[0], y[0], UNIT_SIZE,
                        UNIT_SIZE, null);
            } else {
                g.drawImage(image2, x[i], y[i], UNIT_SIZE,
                        UNIT_SIZE, null);
            }
        }
    }

    /**
     * Sets direction.
     *
     * @param c the c
     */
    public void setDirection(char c) {
        this.direction = c;
    }

    /**
     * Yammy.
     */
    public void yammy() {
        this.applesEaten++;
    }

    /**
     * Got bigger.
     */
    public void gotBigger() {
        this.bodyParts++;
    }
    private void getImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/snake" +
                    ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load the image");
        } finally {
            System.out.println("Got the apple image");
        }

        try {
            image2 = ImageIO.read(getClass().getResourceAsStream("/body" +
                    ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load the image");
        } finally {
            System.out.println("Got the apple image");
        }
    }
}
