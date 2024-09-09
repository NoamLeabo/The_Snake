package GameLogic;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

/**
 * The type Game panel.
 */
public class GamePanel extends JPanel implements ActionListener {
    private int width;
    private int height;
    private int highestScore;
    private static final int DELAY = 80;
    private Apple apple;
    private Snake snake;
    private boolean running = false;
    private boolean waiting = true;
    private Timer timer;
    private StartButton startButton;
    private EndButton endButton;
    private RestartButton restartButton;
    private ResetScoreButton resetScoreButton;

    /**
     * Instantiates a new Game panel.
     *
     * @param width  the width
     * @param height the height
     * @param apple  the apple
     * @param snake  the snake
     */
    public GamePanel(int width, int height, Apple apple, Snake snake) {
        this.width = width;
        this.height = height;
        this.apple = apple;
        this.snake = snake;
        this.startButton = new StartButton();
        this.restartButton = new RestartButton();
        this.resetScoreButton = new ResetScoreButton();
        this.endButton = new EndButton();
        this.startButton.addActionListener(this);
        this.endButton.addActionListener(this);
        this.restartButton.addActionListener(this);
        this.resetScoreButton.addActionListener(this);
        this.addKeyListener(new MyKeyAdapter());
        this.add(apple);
        this.add(snake);
        this.add(startButton);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.setLayout(null);
        this.highestScore = readHighScore();
    }

    /**
     * Start run.
     */
    public void startRun() {
        startGame();
    }

    /**
     * Start game.
     */
    public void startGame() {
        this.apple.newApple();
        running = true;
        waiting = false;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        if (e.getSource() == this.startButton) {
            startRun();
            this.remove(this.startButton);
        }
        if (e.getSource() == this.endButton) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        if (e.getSource() == this.restartButton) {
            snake.restartSnake();
            this.remove(restartButton);
            this.remove(endButton);
            this.remove(resetScoreButton);
            startGame();
        }
        if (e.getSource() == this.resetScoreButton) {
            snake.restartSnake();
            this.remove(restartButton);
            this.remove(endButton);
            this.remove(resetScoreButton);
            writeNewHighScore(0);
            highestScore = 0;
            startGame();
        }
        repaint();
        stop();
    }

    /**
     * Move.
     */
    public void move () {
        snake.move();
    }

    /**
     * Check apple.
     */
    public void checkApple( ){
        if ((snake.getX(0) == apple.getxApple()) && snake.getY(0) == apple.getyApple()) {
            snake.gotBigger();
            snake.yammy();
            apple.newApple();
        }
    }

    /**
     * Check collisions.
     */
    public void checkCollisions() {
        for (int i = snake.getBodyParts(); i > 0; i--) {
            if ((snake.getX(0) == snake.getX(i)) && ((snake.getY(0) == snake.getY(i)))) {
                running = false;
            }
        }

        if (snake.getX(0) < 0 || snake.getX(0) >= width || snake.getY(0) < 0 || snake.getY(0) >= height) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * Draw.
     *
     * @param g the g
     */
    public void draw(Graphics g) {
        if (running) {
            apple.paint(g);
            snake.paint(g);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + snake.getApplesEaten(),
                    (width - metrics.stringWidth(
                            "Score: " + snake.getApplesEaten())) / 2,
                    g.getFont().getSize());
        } else if (waiting) {

            g.setColor(Color.GREEN);
            g.setFont(new Font("Ink Free", Font.ITALIC, 75));
            FontMetrics metrics2 = getFontMetrics(g.getFont());
            g.drawString("Welcome To The Snake!",
                    (width - metrics2.stringWidth(
                            "Welcome To The Snake!")) / 2,
                    (height / 2) - 100);
            apple.view(g);
        } else {
            apple.endView(g);
            gameOver(g);
        }
    }


    /**
     * Read high score int.
     *
     * @return the int
     */
    public int readHighScore() {
        int score = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("score.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                score = Integer.parseInt(line); // Parse the score as an integer
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }

    /**
     * Game over.
     *
     * @param g the g
     */
    public void gameOver(Graphics g) {
        int currBest = readHighScore();
        if (snake.getApplesEaten() > currBest) {
            highestScore = snake.getApplesEaten();
            writeNewHighScore(highestScore); // Write the new record to the file
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + snake.getApplesEaten(),
                (width - metrics1.stringWidth("Score: " + snake.getApplesEaten())) / 2,
                g.getFont().getSize());
        g.drawString("Best Score: " + highestScore,
                (width - metrics1.stringWidth("Best Score: " + highestScore)) / 2, 365);


        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over",
                (width - metrics2.stringWidth("Game Over")) / 2, height / 2);
        this.add(restartButton);
        this.add(endButton);
        this.add(resetScoreButton);
    }

    /**
     * Write new high score.
     *
     * @param score the score
     */
    public void writeNewHighScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("score.txt"))) {
            writer.write(String.valueOf(score)); // Write only the score as a string
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stop.
     */
    public void stop(){
    }

    /**
     * The type My key adapter.
     */
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(snake.getDirection() != 'R') {
                        snake.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(snake.getDirection() != 'L') {
                        snake.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(snake.getDirection() != 'D') {
                        snake.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(snake.getDirection() != 'U') {
                        snake.setDirection('D');
                    }
                    break;
            }
        }
    }
}
