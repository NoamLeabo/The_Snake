package Objects;

import javax.swing.*;
import java.awt.*;

/**
 * The type Start button.
 */
public class StartButton extends JButton {
    /**
     * Instantiates a new Start button.
     */
    public StartButton() {
        this.setBounds(300, 400, 200,50);
        this.setText("START");
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(150,40));
        this.setFont(new Font("Ink Free", Font.BOLD, 20));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.RED);
    }
}
