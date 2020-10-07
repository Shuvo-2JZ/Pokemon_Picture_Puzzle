
package picturepuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Instruction{
    JFrame frame;
    JPanel panel;
    //JButton optionsButton=new JButton("About");
   
    
    Color menuBackgroundColor;
    JLabel controlLabelImage;
    JButton clickHere;
    
    //static String playerSelected;
    
    public Instruction() {
        frame = new JFrame();
        panel=new JPanel();
        

        menuBackgroundColor=new Color(255,255,255);
        
        
        
        frame.setSize(1400, 800);
        frame.setResizable(false);
        
        panel.setLayout(null);
        //panel.setBackground(menuBackgroundColor);
        
        Font f= new Font("Pokemon solid", Font.BOLD, 50);
        
        
        clickHere = new JButton();
     controlLabelImage = new JLabel();
        controlLabelImage.setIcon(new ImageIcon("images\\Instructions.jpg"));
        controlLabelImage.setBounds(0,0,1400,760);
        controlLabelImage.setLayout(null);
        
        
        clickHere.setFont(f);
        clickHere.setBackground(Color.WHITE);
        clickHere.setBounds(400,580,600,100);
        clickHere.setText("Click Here To Start");
        clickHere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   
                    PuzzleWindow gui2=new PuzzleWindow();
                     frame.setVisible(false);
                } catch (Exception x) {
                    x.printStackTrace();
                }
            }
        });
        
        


     
        
        //startButton.addActionListener(new credits.backListener());

        panel.add(controlLabelImage);
        panel.add(clickHere);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        
    }
    

}
