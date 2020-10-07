
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


public class Congrats{
    JFrame frame;
    JPanel panel;
    //JButton optionsButton=new JButton("About");

    public Congrats(JFrame frame, JPanel panel, Color menuBackgroundColor, JLabel controlLabelImage, JButton clickHere) {
        this.frame = frame;
        this.panel = panel;
        this.menuBackgroundColor = menuBackgroundColor;
        this.controlLabelImage = controlLabelImage;
        this.clickHere = clickHere;
    }
   
    Color menuBackgroundColor;
    JLabel controlLabelImage;
    JButton clickHere;
    JLabel totalTime;
    JPanel timeJPanel;
    
    //static String playerSelected;
    
    public Congrats() {
        
        frame = new JFrame();
        panel = new JPanel();
        totalTime = new JLabel();
        
        totalTime.setText("Hello World");

        menuBackgroundColor=new Color(255,255,255);
       
        frame.setSize(1400, 800);
        frame.setResizable(false);
        Font f= new Font("Pokemon solid", 0, 20);
        panel.setLayout(null);
        //panel.setBackground(menuBackgroundColor);
        
        //clickHere = new JButton();
        controlLabelImage = new JLabel();
        controlLabelImage.setIcon(new ImageIcon("images\\Result.jpg"));
        controlLabelImage.setBounds(0,0,1400,760);
        controlLabelImage.setLayout(null);
        
        timeJPanel=new JPanel();
        totalTime=new JLabel();
        timeJPanel.setBounds(100, 550, 250, 40);
        timeJPanel.setBackground(Color.WHITE);
        timeJPanel.add(totalTime);
        totalTime.setForeground(Color.BLACK);
        totalTime.setFont(f);
        totalTime.setBounds(100, 550, 250, 40);

        //this.add(timeJPanel);
        //this.add(totalTime);
        totalTime.setVisible(true);
        timeJPanel.setVisible(true);
        
        


     
        
        //startButton.addActionListener(new credits.backListener());

        panel.add(controlLabelImage);
        //panel.add(clickHere);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        
    }

  
}
