/**
 * Created by romachi on 2017/01/17.
 */

import java.awt.*;
import javax.swing.*;


public class draw extends JPanel {
    public draw() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1200, 600));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 1; i < 10; ++i) {
            g.drawRect(100 * i, 100, 100, 100);
        }
        for (int i = 100; i <= 400; i += 100) {
            g.drawRect(1000, i, 100, 100);
        }
        for (int i = 1000; i >= 100; i -= 100) {
            g.drawRect(i, 400, 100, 100);
        }
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("START", 130, 155);
        g.drawString("+100", 210, 150);
        g.drawString("-100", 310, 150);
        g.drawString("GOAL", 130, 455);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("guriko");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw d = new draw();
        frame.add(d, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
