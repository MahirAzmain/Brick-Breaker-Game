
package brickbreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;


public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;//Timer class to determine how fast the ball should move
    private int delay = 10;

    private int playerX = 520;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir = -1;
    private int ballYDir = -2;

    private MapGenerator mp;

    public GamePlay() {
        mp = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
//        
    }

    public void paint(Graphics g) {
        //backGround
        g.setColor(Color.darkGray);
        g.fillRect(1, 1, 1092, 692);
        //drawing map
        mp.draw((Graphics2D) g);

        //borders
        g.setColor(Color.pink);
        g.fillRect(0, 0, 3, 692);
        g.fillRect(0, 0, 1092, 3);
        g.fillRect(1091, 0, 3, 692);

        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 1050, 30);

        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 650, 100, 8);

        //ball
        g.setColor(Color.getHSBColor(255, 79, 18));
        g.fillOval(ballPosX, ballPosY, 20, 20);

          if (totalBricks <= 0) { // if all bricks are destroyed then you win
            /*play = false;
            ballXDir = 0;
            ballYDir = 0;
            g.setColor(Color.cyan);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won", 230, 320);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Score:" + score, 240, 350);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart...", 180, 380);*/
           
        }

        if (ballPosY > 670) {
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            g.setColor(Color.cyan);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("GAME OVER", 220, 320);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Score:" + score, 250, 350);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart...", 180, 380);
        }

        g.dispose();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 1090) {
                playerX = 1090;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!play) {
                play = true;
                ballPosX = 120;
                ballPosY = 350;
                ballXDir=1;
                ballYDir=-2;
                playerX=310;
                totalBricks=21;
                MapGeneratorMedium map;
                map=new MapGeneratorMedium(3,7);
                repaint();

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 650, 100, 8))) {
                ballYDir = -ballYDir;
            }
            A:
            for (int i = 0; i < mp.map.length; i++) {
                for (int j = 0; j < mp.map[0].length; j++) {
                    if (mp.map[i][j] > 0) {
                        int brickX = j * mp.brickWidth + 80;
                        int brickY = i * mp.brickHeight + 50;
                        int brickWidth = mp.brickWidth;
                        int brickHeight = mp.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            mp.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;
                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                ballXDir = -ballXDir;
                            } else {
                                ballYDir = -ballYDir;
                            }
                            break A;
                        }
                    }
                }
            }
            ballPosX += ballXDir;
            ballPosY += ballYDir;
            if (ballPosX < 0) {
                ballXDir = -ballXDir;
            }
            if (ballPosY < 0) {
                ballYDir = -ballYDir;
            }
            if (ballPosX > 1070) {
                ballXDir = -ballXDir;
            }

        }
        repaint();

    }

    public void moveRight() {
        play = true;
        playerX += 30;

    }

    public void moveLeft() {
        play = true;
        playerX -= 30;

    }
}
