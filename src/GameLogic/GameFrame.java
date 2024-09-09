package GameLogic;

import Objects.Apple;
import Objects.Snake;
import Objects.StartButton;
import biuoop.Sleeper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The type Game frame.
 */
public class GameFrame extends JFrame {

    /**
     * The constant WIDTH.
     */
    public static final int WIDTH = 800;
    /**
     * The constant HEIGHT.
     */
    public static final int HEIGHT = 600;
    private BufferedImage image;

    /**
     * Instantiates a new Game frame.
     */
    public GameFrame() {
        this.setSize(new Dimension(WIDTH, HEIGHT));
        GamePanel g = new GamePanel(WIDTH, HEIGHT,new Apple(WIDTH, HEIGHT),
                new Snake(WIDTH, HEIGHT));

        this.add(g);
        this.setTitle("Snake");
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/snake" +
                    ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load the image");
        } finally {
            System.out.println("Got the apple image");
        }
        this.setIconImage(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }
}