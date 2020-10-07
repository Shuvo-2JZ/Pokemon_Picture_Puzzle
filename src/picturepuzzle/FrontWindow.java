
package picturepuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FrontWindow{
    JFrame frame;
    JPanel panel;
    //JButton optionsButton=new JButton("About");
    JButton startButton,highScoreButton,ExitButton;
    
    Color menuBackgroundColor;
    Color buttonColor,buttonColor2,buttonColor3;
    JLabel controlLabelImage;
    JTextField Thanks;
    JButton button;
    
    
    public FrontWindow() {
        frame = new JFrame();
        panel=new JPanel();
        Color buttonColor=new Color(70,53,35);
        Color buttonColor2=new Color(80,74,60);
        Color buttonColor3=new Color(93,90,35);
        
        
        
        startButton=new JButton();
        highScoreButton=new JButton();
        ExitButton=new JButton();

        
        
        
        frame.setSize(1400, 800);
        frame.setResizable(false);
        
        panel.setLayout(null);
        //panel.setBackground(menuBackgroundColor);
        
        
        
     controlLabelImage = new JLabel();
        controlLabelImage.setIcon(new ImageIcon("images\\image.jpg"));
        controlLabelImage.setBounds(0,0,1400,760);
        controlLabelImage.setLayout(null);
        
        startButton.setBounds(960,332,220,75);
        startButton.setBackground(buttonColor);
        startButton.setForeground(Color.WHITE);
        
        
        Font f= new Font("Pokemon solid", Font.BOLD, 40);
        startButton.setFont(f);
        startButton.setText("Start");
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instruction instruction = new Instruction();
                frame.setVisible(false);
            }
        });
        
        highScoreButton.setBounds(960,419,260,80);
        highScoreButton.setBackground(buttonColor2);
        highScoreButton.setFont(f);
        highScoreButton.setText("High Score");
        highScoreButton.setForeground(Color.WHITE);
        
        ExitButton.setBounds(960,512,270,75);
        ExitButton.setBackground(buttonColor3);
        ExitButton.setFont(f);
        ExitButton.setText("Exit");
        ExitButton.setForeground(Color.WHITE);
        
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
        


        panel.add(controlLabelImage);
        panel.add(startButton);
        
        panel.add(highScoreButton);
        panel.add(ExitButton);
        
        frame.add(panel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        
    }
   
  
    public static void main(String[] args) {
        new FrontWindow();
    }
}
