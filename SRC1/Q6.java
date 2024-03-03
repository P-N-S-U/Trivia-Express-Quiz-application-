package SRC1;
import SCORE.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Q6 implements ActionListener{
    frame f = new frame();
    JTextField t1 = new JTextField();
    
    int SCORE;
    
    private ScoreHolder scoreHolder;

    boolean hintshown = false;

    ImageIcon hintIcon = new ImageIcon("images\\hint.png");

    //Important here                                                                                        //enter you question and option here
    JTextField Question = new JTextField("Which was the first animal to travel to space?");
    JButton o1 = new JButton("A mouse");                           
    JButton o2 = new JButton("A cat");
    JButton o3 = new JButton("A cockroach");
    JButton o4 = new JButton("A dog");

    public void Questions(ScoreHolder scoreHolder){

        this.scoreHolder = scoreHolder;
        SCORE = scoreHolder.getScore();
        t1.setText(Integer.toString(scoreHolder.getScore()));
        
        

        JLabel hint = new JLabel();
        hint.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {                 //for hint cost = -20
                if(!hintshown){
                    SCORE-=20;
                    scoreHolder.setScore(SCORE);
                    t1.setText(Integer.toString(scoreHolder.getScore()));
                    hintshown = true;
                }                                               //add hints here
                JOptionPane.showMessageDialog(null, "Laika", "HINT", 2, hintIcon);
                t1.setText(Integer.toString(scoreHolder.getScore()));
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {}
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {}
        });

        
        f.setLayout(null);
        f.setTitle("Q6");

        Question.setBackground(new Color(56, 182, 255));
        Question.setBorder(BorderFactory.createTitledBorder("QUESTION"));
        Question.setFont(new Font(Font.MONOSPACED, Font.BOLD, 27));
        Question.setFocusable(false);

        ImageIcon image = new ImageIcon("images\\QNA background.png");
        JLabel back = new JLabel(image);

        

        o1.setBorder(BorderFactory.createTitledBorder("1"));            //OPTION 1
        o1.setFocusable(false);
        o1.setBackground(new Color(56, 182, 255));
        o1.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 60));
        o1.addActionListener(this);
        

        o2.setBorder(BorderFactory.createTitledBorder("2"));            //OPTION 2
        o2.setFocusable(false);
        o2.setBackground(new Color(56, 182, 255));
        o2.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 60));
        o2.addActionListener(this);
        

        o3.setBorder(BorderFactory.createTitledBorder("3"));               //OPTION 3
        o3.setFocusable(false);
        o3.setBackground(new Color(56, 182, 255));
        o3.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 60));
        o3.addActionListener(this);
        

        o4.setBorder(BorderFactory.createTitledBorder("4"));            //OPTION 4
        o4.setFocusable(false);
        o4.setBackground(new Color(56, 182, 255));
        o4.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 60));
        o4.addActionListener(this);
        
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t1.setBorder(BorderFactory.createTitledBorder("SCORE"));
        t1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        t1.setBackground(new Color(56, 150, 255));
        t1.setEditable(false);


        f.add(Question);                    //Ading components 
       
        f.add(t1);
        f.add(o1);
        f.add(o2);
        f.add(o3);
        f.add(o4);
        f.add(back);
        f.add(hint);

        o1.setBounds(50, 440, 450, 70);             //DO-NOT touch
        o2.setBounds(675, 440, 450, 70);
        o3.setBounds(50, 550, 450, 70);
        o4.setBounds(675, 552, 450, 70);
        Question.setBounds(80, 140,1040, 150);
        t1.setBounds(1065, 0, 120, 55);
        back.setBounds(0, 0, 1200, 670);
        hint.setBounds(0, 0, 100, 120);

       

    }

    @Override                                                       //make changes here for correct option and score 
    public void actionPerformed(ActionEvent e) {                                    
        
        if(e.getSource()==o1){
            o1.setBackground(Color.red);
            SCORE-=10;
            scoreHolder.setScore(SCORE);
            t1.setText(Integer.toString(scoreHolder.getScore()));
            o1.setEnabled(false);
        }

        if(e.getSource()==o2){
            o2.setBackground(Color.green);
            SCORE-=10;
            scoreHolder.setScore(SCORE);
            t1.setText(Integer.toString(scoreHolder.getScore()));
            o2.setEnabled(false);
        }

        if(e.getSource()==o3){
            o3.setBackground(Color.red);
            SCORE-=10;
            scoreHolder.setScore(SCORE);
            t1.setText(Integer.toString(scoreHolder.getScore()));
            o3.setEnabled(false);
        }

        if(e.getSource()==o4){
            o4.setBackground(Color.red);
            SCORE+=25;
            scoreHolder.setScore(SCORE);
            t1.setText(Integer.toString(scoreHolder.getScore()));
            o4.setEnabled(false);
            f.dispose();
            Q7 a = new Q7();
            a.Questions(scoreHolder);
        }

    }
    
    
}
