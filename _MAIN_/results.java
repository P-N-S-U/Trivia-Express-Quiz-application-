package _MAIN_;
import SRC1.*;
import SCORE.*;
import SRC2.*;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class results{

    ScoreHolder scoreHolder = new ScoreHolder();
    ScoreHolderfun scoreHolderfun = new ScoreHolderfun();

    int SCORE,SCOREFUN;
    
    public void SCORE(ScoreHolder scoreHolder, ScoreHolderfun ScoreHolderfun){
        
        SCORE = scoreHolder.getScore();
        SCOREFUN = scoreHolderfun.getScore();

        JFrame f = new JFrame("results");
        f.setLayout(null);

        

        ImageIcon image = new ImageIcon("images\\T BG 2.png");
        ImageIcon forbrain = new ImageIcon("images\\Brainstorming removed.png");
        ImageIcon forfun = new ImageIcon("images\\fun removes.png");
        JLabel back = new JLabel(image);
        JLabel brain = new JLabel(forbrain);
        JLabel fun = new JLabel(forfun);

        brain.setHorizontalAlignment(JLabel.CENTER);
        brain.setVerticalAlignment(JLabel.TOP);
        brain.setVerticalTextPosition(JLabel.BOTTOM);
        brain.setHorizontalTextPosition(JLabel.CENTER);
        brain.setText("Click here to test your IQ");
        brain.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));
        brain.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SCORE==0){
                f.dispose();
                Q1 a = new Q1();
                a.Questions(scoreHolder);
                
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });


        fun.setHorizontalAlignment(JLabel.CENTER);
        fun.setVerticalAlignment(JLabel.TOP);
        fun.setVerticalTextPosition(JLabel.BOTTOM);
        fun.setHorizontalTextPosition(JLabel.CENTER);
        fun.setText("Click here for fun riddles");
        fun.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));
        fun.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(SCOREFUN==0){
                    f.dispose();
                    F1 a = new F1();
                    a.Questions(ScoreHolderfun);
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        

        f.setSize(1200, 675);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

        f.add(fun);
        f.add(brain);
        f.add(back);

        back.setBounds(0, 0, 1200, 675);
        brain.setBounds(0, 0, 602, 675);
        fun.setBounds(602, 0, 600, 675);



        if(SCOREFUN!=0){
            fun.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 55));
            fun.setText(SCOREFUN+"/375");
        }

        if(SCORE!=0){
            brain.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 55));
            brain.setText(SCORE+"/500");

        }
        

    }
}
