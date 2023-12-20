

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Category2 {

    ScoreHolder scoreHolder = new ScoreHolder();
    ScoreHolderfun ScoreHolderfun = new ScoreHolderfun();

    JLabel back = new JLabel();
    JLabel brain = new JLabel("Encounter various Riddles and fun Questions");
    JLabel fun = new JLabel("Encounter question that will test you IQ");
    

    Category2(){
        frame f = new frame();
        f.setLayout(null);
       
        
        ImageIcon image = new ImageIcon("images\\category bg.png");
        back.setIcon(image);

        brain.setHorizontalAlignment(JLabel.CENTER);
        brain.setFont(new Font("MV Boli", Font.BOLD, 25));

        fun.setHorizontalAlignment(JLabel.CENTER);
        fun.setFont(new Font("MV Boli", Font.BOLD, 25));


        brain.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
               JOptionPane.showMessageDialog(null,
                "Correct Answer : +25 pts \nWrong Answer : -10 pts", 
                "POINT SYSTEM", 1);

                JOptionPane.showMessageDialog(null,
                "For hint click on the bulb \nhint cost -20pts", 
                "POINT SYSTEM", 1);

               f.dispose();
               //calling the quesions 
                Q1 a = new Q1();
                a.Questions(scoreHolder);
               
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                fun.setOpaque(true);
                fun.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fun.setBackground(Color.white);
                fun.setOpaque(false);
            }
        });


        fun.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {


                JOptionPane.showMessageDialog(null,
                "Correct answer : +25pts\nWrong answer : -10pts\ntotal tries : 3 ", "point system", 1);

                JOptionPane.showMessageDialog(null, "for hint click on the bulb\nhint cost : -10pts", "HINTS", 1);
                f.dispose();
                F1 a = new F1();
                a.Questions(ScoreHolderfun);


            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                brain.setOpaque(true);
                brain.setBackground(Color.pink);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                brain.setBackground(Color.white);
                brain.setOpaque(false);
            }
            
        });
        
        
        f.add(back);
        f.add(brain);
        f.add(fun);

        back.setBounds(0, 0, 1200, 650);
        brain.setBounds(0, 0, 600, 675);
        fun.setBounds(600, 0, 600, 675);
        
        

    }

    
}
