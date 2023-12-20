import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class F2 implements KeyListener{
    frame f = new frame();
    JTextField t1 = new JTextField();
    JTextArea T = new JTextArea();
    JTextField Ans = new JTextField();
    ImageIcon hintIcon = new ImageIcon("images\\hint.png");
    
    int SCORE;
    int count;
    private ScoreHolderfun scoreHolderfun;
    boolean hintshown = false;
    



    public void Questions(ScoreHolderfun scoreHolderfun){

        //Important here                                                                                        //enter you question
        T.append("What has to be broken before you can use it?");
        T.setBackground(new Color(56, 182, 255));
        T.setBorder(BorderFactory.createTitledBorder("QUESTION"));
        T.setFont(new Font(Font.MONOSPACED, Font.BOLD, 27));
        T.setEditable(false);

        this.scoreHolderfun = scoreHolderfun;
        SCORE = scoreHolderfun.getScore();
        t1.setText(Integer.toString(scoreHolderfun.getScore()));
        
        

        JLabel hint = new JLabel();
        hint.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {                 //for hint cost = -20
                if(!hintshown){
                    SCORE-=10;
                    scoreHolderfun.setScore(SCORE);
                    t1.setText(Integer.toString(scoreHolderfun.getScore()));
                    hintshown = true;
                }                                               //add hints here
                JOptionPane.showMessageDialog(null, "Food item with potential of giving birth", "HINT", 2, hintIcon);
                t1.setText(Integer.toString(scoreHolderfun.getScore()));
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
        f.setTitle("Q2");

        ImageIcon image = new ImageIcon("images\\fun background.png");
        JLabel back = new JLabel(image);

        Ans.setBackground(new Color(56, 182, 255));
        Ans.setBorder(BorderFactory.createTitledBorder("Answer!"));
        Ans.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
        Ans.addKeyListener(this);

        t1.setHorizontalAlignment(JTextField.RIGHT);                                //text feild formatting
        t1.setBorder(BorderFactory.createTitledBorder("SCORE"));
        t1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        t1.setBackground(new Color(56, 150, 255));
        t1.setEditable(false);

        f.add(T);                                //Ading components 
        f.add(t1);
        f.add(Ans);
        f.add(back);
        f.add(hint);
        
        Ans.setBounds(220, 440, 760, 125);
        T.setBounds(80, 140,1040, 150);                           //DO-NOT touch
        t1.setBounds(1065, 0, 120, 55);
        back.setBounds(0, 0, 1200, 670);
        hint.setBounds(0, 0, 100, 120);
    }




    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {

        String Answer = Ans.getText();
        System.out.println(Answer);

        if(e.getKeyCode()==10){
            count++;
            System.out.println(count);

            if(Answer.equals("egg")||Answer.equals("Egg")){
                SCORE+=25;
                scoreHolderfun.setScore(SCORE);
                t1.setText(Integer.toString(scoreHolderfun.getScore()));
                f.dispose();
                F3 a = new F3();
                a.Questions(scoreHolderfun);
            }
            else{
                SCORE-=10;
                scoreHolderfun.setScore(SCORE);
                t1.setText(Integer.toString(scoreHolderfun.getScore()));
            }

            if(count==3){
                Ans.setText("Egg");
                // f.dispose();
                // new Category2();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    
    
}
