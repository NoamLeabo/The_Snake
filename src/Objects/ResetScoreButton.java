package Objects;

import javax.swing.*;
import java.awt.*;

/**
 * The type Restart button.
 */
public class ResetScoreButton extends JButton {
    /**
     * Instantiates a new Restart button.
     */
    public ResetScoreButton() {
        this.setBounds(300, 470, 200,50);
        this.setText("Reset Score");
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(150,40));
        this.setFont(new Font("Ink Free", Font.BOLD, 20));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.GREEN);
    }
}
