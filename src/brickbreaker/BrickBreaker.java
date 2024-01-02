package brickbreaker;


import javax.swing.JFrame;


public class BrickBreaker {

    JFrame frame = new JFrame();

    public BrickBreaker(int d) {
        frame = new JFrame();

        if (d == 1) 
        {
            GamePlayEasy eplay = new GamePlayEasy();
            frame.add(eplay);
        } 
        else if (d == 2) 
        {
            GamePlayMedium mplay = new GamePlayMedium();
            frame.add(mplay);
        } 
        else if(d==3)
        {
            GamePlayHard hplay = new GamePlayHard();
            frame.add(hplay);
        }
//       GamePlay play=new GamePlay();
//       frame.add(play);

        frame.setBounds(1, 1, 700, 600);
        frame.setTitle("Brick Breaker");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
     

}
