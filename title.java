import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class title implements KeyListener{
    
    frame f = new frame();
    ImageIcon image = new ImageIcon("images\\TRIVIA EXPRESS 1.jpg");
    JLabel l1 = new JLabel(image);
    JLabel l2= new JLabel("Press enter to Start");

    

    title(){
        f.setLayout(null);
        
        l2.setForeground(Color.blue);
        l2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        
        f.addKeyListener(this);
        f.add(l2);
        f.add(l1);
        
        l1.setBounds(0, 0, 1200, 640);

        l2.setBounds(450, 520, 340, 30);
        l2.setLayout(new FlowLayout(FlowLayout.CENTER));
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode()==10){
            l2.setText("I lied press SPACE to Start");
        }
        if(e.getKeyCode()==32){
            f.dispose();
            new Category2();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
}
