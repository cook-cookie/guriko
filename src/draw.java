/**
 * Created by romachi on 2017/01/17.
 */

import java.awt.*;
import javax.swing.*;


public class draw extends JPanel {
    public draw() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1200, 600));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(100, 100, 100, 100);
        g.drawString("START", 110, 150);
        g.drawRect(200, 100, 100, 100);
        g.drawString("+100", 210, 150);
        g.drawRect(300, 100, 100, 100);
        g.drawString("-100", 310, 150);
        g.drawRect(400, 100, 100, 100);
        g.drawRect(400, 200, 100, 100);
        g.drawRect(400, 300, 100, 100);
        g.drawRect(400, 400, 100, 100);
        g.drawRect(300, 400, 100, 100);
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
