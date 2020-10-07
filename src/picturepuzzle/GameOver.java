
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

public class GameOver{
    JFrame frame;
    JPanel panel;
    //JButton optionsButton=new JButton("About");
   
    
    Color menuBackgroundColor;
    JLabel controlLabelImage;
    JButton clickHere;
    
    //static String playerSelected;
    
    public GameOver() {
        frame = new JFrame();
        panel=new JPanel();
        

        menuBackgroundColor=new Color(0,0,255);
        
        
        
        frame.setSize(1400,800);
        frame.setResizable(false);
        
        panel.setLayout(null);
        //panel.setBackground(menuBackgroundColor);
        
        Font f= new Font("Pokemon solid", Font.BOLD, 50);
        
        
        clickHere = new JButton();
     controlLabelImage = new JLabel();
        controlLabelImage.setIcon(new ImageIcon("images\\Over.jpg"));
       
        controlLabelImage.setBounds(0,0,1400,760);
        //controlLabelImage.setLayout(null);
        
        
        
        
        


     
        
        //startButton.addActionListener(new credits.backListener());

        panel.add(controlLabelImage);
        panel.add(clickHere);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
       
    }


   
    /*public static void main(String[] args) {
        new GameOver();
    } */
}
