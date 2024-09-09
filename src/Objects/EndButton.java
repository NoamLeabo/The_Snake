package Objects;

import javax.swing.*;
import java.awt.*;

/**
 * The type End button.
 */
public class EndButton extends JButton {
    /**
     * Instantiates a new End button.
     */
    public EndButton() {
        this.setBounds(150, 400, 200,50);
        this.setText("End Game");
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(150,40));
        this.setFont(new Font("Ink Free", Font.BOLD, 20));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.GREEN);
    }
}
