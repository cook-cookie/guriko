/**
 * Created by romachi on 2017/01/17.
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class Draw extends JPanel {
    BufferedImage bi;
    Player[] p;
    private int[][] playerPositions = {
            {150, 150},
            {250, 150},
            {350, 150},
            {450, 150},
            {550, 150},
            {650, 150},
            {750, 150},
            {850, 150},
            {950, 150},
            {1050, 150},//右上
            {1050, 250},
            {1050, 350},
            {1050, 450},//右下
            {950, 450},
            {850, 450},
            {750, 450},
            {650, 450},
            {550, 450},
            {450, 450},
            {350, 450},
            {250, 450},
            {150, 450},//左下
    };

    public void Draw() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1200, 600));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println("Painted");

        for (int i = 0; i < 22; ++i) {
            g.setColor(Color.white);
            g.fillRect(playerPositions[i][0] - 50, playerPositions[i][1] - 50, 100, 100);
            g.setColor(Color.black);
            g.drawRect(playerPositions[i][0] - 50, playerPositions[i][1] - 50, 100, 100);
        }

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.blue);
        g.drawString("START", 130, 95);
        g.setColor(Color.black);
        g.drawString("+100", 230, 95);
        g.drawString("-100", 330, 95);
        g.setColor(Color.RED);
        g.drawString("GOAL", 130, 395);
//        g.setColor(Color.ORANGE);
        if (p != null) {
            for (int i = 0; i < p.length; i++) {
                int x = playerPositions[p[i].position][0] - 20;
                int y = playerPositions[p[i].position][1] - 25;

                switch (i) {
                    case 0:
                        g.setColor(Color.red);
                        g.drawString("player", x, y);
                        break;
                    case 1:
                        g.setColor(Color.blue);
                        if (p[i].position == p[i - 1].position)
                            g.drawString("player", x, y + 20);
                        else
                            g.drawString("player", x, y);
                        break;
                    case 2:
                        g.setColor(Color.green);
                        if (p[i].position == p[i - 1].position)
                            g.drawString("player", x, y + 40);
                        else
                            g.drawString("player", x, y);
                        break;
                    case 3:
                        g.setColor(Color.orange);
                        if (p[i].position == p[i - 1].position)
                            g.drawString("player", x, y + 60);
                        else
                            g.drawString("player", x, y);
                        break;
                    default:
                        g.setColor(Color.black);
                        System.out.println("default occured");
                        break;
                }
                g.setColor(Color.black);
                g.drawString("player" + String.valueOf(i) + ": " + String.valueOf(p[i].point), 10, 20 * (i + 1));
            }
        }
    }

    public void movePlayer(Player p) {
        bi = new BufferedImage(1200, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.drawString("player", 150, 150);
    }

    public void run() {
        int max_player = 4;
        int players = 2;
        int cpus;
        p = new Player[max_player];
        int k;
        for (k = 0; k < max_player; k++) {
            p[k] = new Player();
        }
        Kadaijanken kj = new Kadaijanken();

        while (true) {

            for (k = 0; k < players; k++) {
                kj.Gethand(k, p);
            }
            for (cpus = (max_player - players); cpus < max_player; cpus++) {
                kj.Cpu(cpus, p);
            }
            kj.Judge(max_player, p);
            for (int l = 0; l < max_player; l++) {
                System.out.println(">>>>>Player" + l + "<<<<<");
                System.out.println("point " + p[l].point);
                System.out.println("position" + p[l].position);
                System.out.println("/////////////////////");
                repaint();
            }
        }
    }

    /*public static void main(String args[]) {
        JFrame frame = new JFrame("guriko");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw d = new draw();

        frame.add(d, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }*/
}
