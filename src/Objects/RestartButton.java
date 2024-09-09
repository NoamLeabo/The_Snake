package Objects;

import javax.swing.*;
import java.awt.*;

/**
 * The type Restart button.
 */
public class RestartButton extends JButton {
    /**
     * Instantiates a new Restart button.
     */
    public RestartButton() {
        this.setBounds(450, 400, 200,50);
        this.setText("Restart");
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(150,40));
        this.setFont(new Font("Ink Free", Font.BOLD, 20));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.GREEN);
    }
}
