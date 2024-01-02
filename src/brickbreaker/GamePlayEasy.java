package brickbreaker;

import Login.Login;
import Main.DBConnection;
import Main.MainMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*public class GamePlayEasy extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    
    private Timer timer;//Timer class to determine how fast the ball should move
    private int delay = 8;

    private int playerX = 310;
    private int level = 1;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir = -1;
    private int ballYDir = -2;
    private int row=2;
    private int col=6;
    private int totalBricks = row*col;

    private MapGeneratorEasy mp;
   

    public GamePlayEasy() {
        mp = new MapGeneratorEasy(row, col);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
//        
    }

    public void paint(Graphics g) {
        //backGround
        Color c1 = new Color(155, 155, 253);
        g.setColor(c1);
        g.fillRect(1, 1, 692, 592);
        //drawing map
        mp.draw((Graphics2D) g);
       

        //borders
        g.setColor(Color.pink);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        //scores
        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);
        
        //level
          
          if (level == 4) {
                    play = false;
                    ballXDir = 0;
                    ballYDir = 0;
                    g.setColor(Color.red);
                    g.setFont(new Font("Monosapced", Font.BOLD, 30));
                    g.drawString("GAME OVER", 230, 320);
                    g.setFont(new Font("Monospaced", Font.PLAIN, 25));
                    g.drawString("Score:" + score, 260, 350);
                    //g.setFont(new Font("serif",Font.BOLD,20));
                    g.drawString("Press Enter to go to Main Menu", 130, 380);

                }
                
        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("LEVEL" + level, 10, 30);
               

        //paddle
        g.setColor(Color.getHSBColor(49, 122, 138));
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.black);
        g.fillOval(ballPosX, ballPosY, 20-level, 20-level);

        if (totalBricks <= 0) { // if all bricks are destroyed then you win
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            
            if (!play) {
                play = true;
                ballPosX = 120;
                ballPosY = 250;
                ballXDir = -1;
                ballYDir = -2;
                playerX = 310;
                level++;
                delay--;
                row++;
                col++;
                totalBricks = row*col;
                mp = new MapGeneratorEasy(row,col);
                repaint();
              
            }
        }

        if (ballPosY > 570 ) {
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("Monosapced", Font.BOLD, 30));
            g.drawString("GAME OVER", 230, 320);
            g.setFont(new Font("Monospaced", Font.PLAIN, 25));
            g.drawString("Score:" + score, 260, 350);
            //g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press Enter to go to Main Menu", 130, 380);
            g.drawString("Press P to Continue",130,400);
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
            if (playerX >= 600) {
                playerX = 600;
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
        if (e.getKeyCode() == KeyEvent.VK_P) {

            if (!play) {
                play = true;
                ballPosX = 120;
                ballPosY = 350;
                ballXDir=1;
                ballYDir=-2;
                playerX=310;
                totalBricks=21;
                
              

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
            if (new Rectangle(ballPosX, ballPosY, 20-level, 20-level).intersects(new Rectangle(playerX, 550, 100, 8))) {
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
            if (ballPosX > 670) {
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
}*/


public class GamePlayEasy extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    
    private Timer timer;//Timer class to determine how fast the ball should move
    private int delay = 9;

    private int playerX = 310;
    private int level = 1;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir = 1;
    private int ballYDir = -2;
    private int row=2;
    private int col=6;
    private int totalBricks = row*col;
    private int lives=2;
    private int stick_width=100;

    private MapGeneratorMedium mp;
   
   
    public GamePlayEasy() {
        mp = new MapGeneratorMedium(row, col);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
//        
    }
    public void drawHeart(Graphics g, int x, int y, int width, int height) {
    int[] triangleX = {
            x - 2*width/18,
            x + width + 2*width/18,
            (x - 2*width/18 + x + width + 2*width/18)/2};
    int[] triangleY = { 
            y + height - 2*height/3, 
            y + height - 2*height/3, 
            y + height };
    g.fillOval(
            x - width/12,
            y, 
            width/2 + width/6, 
            height/2); 
    g.fillOval(
            x + width/2 - width/12,
            y,
            width/2 + width/6,
            height/2);
    g.fillPolygon(triangleX, triangleY, triangleX.length);
}


    public void paint(Graphics g) {
        //backGround
        Color c1 = new Color(155, 155, 253);
        g.setColor(c1);
        g.fillRect(1, 1, 692, 592);
        //drawing map
        mp.draw((Graphics2D) g);
       
       

        //borders
        g.setColor(Color.pink);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        //scores
        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);
        
        //lives
        g.setColor(Color.red);
         drawHeart(g,280,10,25,25);
        g.drawString(" " +(lives+1) , 310, 30);
        
        //level
          
          if (level == 4) {
                    play = false;
                    ballXDir = 0;
                    ballYDir = 0;
                    g.setColor(Color.red);
                    g.setFont(new Font("Monosapced", Font.BOLD, 30));
                    g.drawString("You Won", 230, 320);
                    g.setFont(new Font("Monospaced", Font.PLAIN, 25));
                    g.drawString("Score:" + score, 260, 350);
                    //g.setFont(new Font("serif",Font.BOLD,20));
                    g.drawString("Press Escape to go to Main Menu", 130, 380);
                    String name=Login.tf1.getText();
                    //save(name,Integer.toString(score));

                }
                
        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("LEVEL " + level, 10, 30);
               

        //paddle
        g.setColor(Color.white);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.black);
        g.fillOval(ballPosX, ballPosY, 20-level, 20-level);

        if (totalBricks <= 0) { // if all bricks are destroyed then you win
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            /*Color c4=new Color(51,102,0);
            g.setColor(c4);
            g.setFont(new Font("Monospaced", Font.BOLD, 30));
            g.drawString("You Won", 235, 320);
            g.setFont(new Font("Monospaced", Font.PLAIN, 25));
            g.drawString("Score:" + score, 237, 350);
            g.setFont(new Font("Monospaced", Font.PLAIN, 20));
            g.drawString("Press Enter to go to Main Menu", 130, 380);*/
            if (!play) {
                play = true;
                ballPosX = 120;
                ballPosY = 250;
                ballXDir = 1;
                ballYDir = -2;
                playerX = 310;
                level++;
                delay-=2;
                row++;
                col++;
                totalBricks = row*col;
                mp = new MapGeneratorMedium(row,col);
                repaint();
              
            }
        }

        if (ballPosY > 570) {
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            //lives--;
//            String name=Login.tf1.getText();
//            save(name,Integer.toString(score));
            Color c2=new Color(58,83,38);
            g.setColor(Color.red);
            g.setFont(new Font("Monosapced", Font.BOLD, 30));
            g.drawString("GAME OVER", 230, 320);
            g.setFont(new Font("Monospaced", Font.PLAIN, 25));
            g.drawString("Score:" + score, 260, 350);
            //g.setFont(new Font("serif",Font.BOLD,20));
            g.setFont(new Font("Monospaced", Font.PLAIN, 20));
            g.setColor(c2);
            if(lives!=0)g.drawString("Press P to continue playing", 140, 380);
            g.setFont(new Font("Monospaced", Font.PLAIN, 25));
            g.drawString("Press Escape to go to Main Menu", 130, 420);
//             JFrame top=(JFrame)SwingUtilities.getWindowAncestor(this);
//               top.dispose();
//               MainMenu m=new MainMenu();
//               m.setVisible(true);
        }

        g.dispose();

    }
     public void save(String name,String score)
    {
    Connection dbconn = DBConnection.connectDB();
        if(dbconn != null){
        try {
            String sql = "INSERT INTO leaderboard (username, score) VALUES (?, ?)";
            PreparedStatement st = (PreparedStatement) dbconn.prepareStatement(sql);
            
            st.setString(1, name);
            st.setString(2, score);
            //st.setString(3, password);
            
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Registration completed", "Register",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(this, "Username Error", "Register",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            System.out.println("The Connection is not available");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
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
        if (e.getKeyCode() == KeyEvent.VK_P) {
            
            

            if (!play && lives!=0) {
                lives--;
                play = false;
                ballPosX = 120;
                ballPosY = 350;
                ballXDir=1;
                ballYDir=-2;
                playerX=310;
//                JFrame top=(JFrame)SwingUtilities.getWindowAncestor(this);
//                top.dispose();
//                MainMenu m=new MainMenu();
//                m.setVisible(true);
                
               
               
              }
         }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
                JFrame top=(JFrame)SwingUtilities.getWindowAncestor(this);
                top.dispose();
                MainMenu m=new MainMenu();
                m.setVisible(true);
                String name=Login.tf1.getText();
                save(name,Integer.toString(score));
        
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20-level, 20-level).intersects(new Rectangle(playerX, 550, stick_width-(level*2), 8))) {
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
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20-level, 20-level);
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
            if (ballPosX > 670) {
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



