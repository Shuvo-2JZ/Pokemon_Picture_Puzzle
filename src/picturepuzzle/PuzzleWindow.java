package picturepuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;

public class PuzzleWindow extends JFrame {
    JFrame frame;
    private JPanel jumblePanel;
    private JPanel previewPanel;
    private JLabel previewLabel;
    private JPanel timeJPanel;
    private JLabel timeJLabel;
    private ImageIcon preview;
    private JButton one,two,three,four,five,reshuffle;
    private JMenuBar menu;
    private ArrayList<JButton> buttons;
    private JButton dummy;
    private MouseHandler mousehandler;
    private ItemHandler itemhandler;
    Icon star;
    private javax.swing.Timer t1; 
    private int timeCounter = 0;
    
    private String path;
    private String path1="Pikachu2.jpg";
    private String path2="Charmander.jpg";
    private String path3="Eevee.jpg";
    private String path4="Jigglypuff.jpg";
    private String path5="Meowth.jpg";
    
    private int indexOfBlank = 8;
    
    public PuzzleWindow() throws IOException {
        

        this.setSize(1400, 800);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        one=new JButton();
        one.setBounds(1100, 220, 200, 40);
        one.setBackground(Color.ORANGE);
        one.setForeground(Color.BLACK);
        Font f= new Font("Pokemon solid", 0, 20);
        one.setFont(f);
        one.setText("Pikachu");
         this.add(one);
        one.setVisible(true);
    
        
        two=new JButton();
        two.setBounds(1100, 280, 200, 40);
        two.setBackground(Color.ORANGE);
        two.setForeground(Color.BLACK);
        two.setFont(f);
        two.setText("Charmander");
        this.add(two);
        two.setVisible(true);
        
        
        three=new JButton();
        three.setBounds(1100, 340, 200, 40);
        three.setBackground(Color.ORANGE);
        three.setForeground(Color.BLACK);
        three.setFont(f);
        three.setText("Eevee");
          this.add(three);
        three.setVisible(true);
      
        
        four=new JButton();
        four.setBounds(1100, 400, 200, 40);
        four.setBackground(Color.ORANGE);
        four.setForeground(Color.BLACK);
        four.setFont(f);
        four.setText("Jigglypuff");
        this.add(four);
        four.setVisible(true);
       
        
        five=new JButton();
        five.setBounds(1100, 460, 200, 40);
        five.setBackground(Color.ORANGE);
        five.setForeground(Color.BLACK);
        five.setFont(f);
        five.setText("Meowth");
        this.add(five);
        five.setVisible(true);
        
        reshuffle=new JButton();
        reshuffle.setBounds(750, 550, 200, 40);
        reshuffle.setBackground(Color.pink);
        reshuffle.setForeground(Color.BLACK);
        reshuffle.setFont(f);
        reshuffle.setText("Reshuffle");
        this.add(reshuffle);
        reshuffle.setVisible(true);
        
        timeJPanel=new JPanel();
        timeJLabel=new JLabel();
        timeJPanel.setBounds(1100, 550, 250, 40);
        timeJPanel.setBackground(Color.WHITE);
        timeJPanel.add(timeJLabel);
        timeJLabel.setForeground(Color.BLACK);
        timeJLabel.setFont(f);
        
        
        this.add(timeJPanel);
        timeJLabel.setVisible(true);
        timeJPanel.setVisible(true);
        
        
        jumblePanel = new JPanel();
        jumblePanel.setBounds(10, 10, 700, 650);
        jumblePanel.setBackground(Color.BLACK);
        this.add(jumblePanel);
        jumblePanel.setVisible(true);
        

        previewPanel = new JPanel();
        previewPanel.setBounds(1100, 10, 200, 200);
        previewPanel.setBackground(Color.BLACK);
        preview = new ImageIcon(getClass().getResource(path3));
        Image img = preview.getImage();
        Image img1 = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        preview = new ImageIcon(img1);

        previewLabel = new JLabel(preview);
        
       this.setBackground(new Color(0, 0,0));
      

        previewPanel.add(previewLabel);
        this.add(previewPanel);
   
        previewPanel.setVisible(true);


        buttons = new ArrayList<JButton>();

        setImage();

        jumblePanel.setLayout(new GridLayout(3, 3));
        //Collections.shuffle(buttons.subList(0, 7));
       
         drawButtons();

        t1 = new javax.swing.Timer(100 , new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    timeCounter++;
                    
                    timeJLabel.setText("Time: "+ (timeCounter/10)+" sec");
                    
                    if(timeCounter/10 == 300){
                        
                        GameOver go = new GameOver();
                        dispose();
                    }
                    
                }
            });

            t1.start();
        
        
        refresh();

    }

    

    public void setImage() throws IOException {
        URL img = FrontWindow.class.getResource(path3);
        BufferedImage bimg = ImageIO.read(img);

        int w = bimg.getWidth();
        int h = bimg.getHeight();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                BufferedImage wim = bimg.getSubimage(j * w / 3, i * h / 3, w / 3, h / 3);
                Image sc = wim.getScaledInstance(jumblePanel.getWidth() / 3, jumblePanel.getHeight() / 3, Image.SCALE_AREA_AVERAGING);
                setupImage(count++, sc);
            }
        }
    }

    private void setupImage(int i, Image wim) {
        JButton button;
        if (i == 8) {
            button = new JButton();
        } else {
            button = new JButton(new ImageIcon(wim));
        }
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (buttons.indexOf(e.getSource())==0) {
                     //Icon s1=buttons.get(0).getIcon();
                   //  System.out.println("c on"+ buttons.indexOf(e.getSource()));
                    //JButton  button1 = buttons.get(5);
                    if (indexOfBlank == 1) {
                        Collections.swap(buttons,0,1);
                        drawButtons();
                        indexOfBlank = 0;
                        refresh();
                    }else  if (indexOfBlank == 3) {
                        Collections.swap(buttons,0,3);
                        drawButtons();
                        indexOfBlank = 0;
                        refresh();
                      //buttons.get(3).setIcon(s1);
                      //buttons.get(0).setIcon(star);
                    }
                    
                }
                
                else if (buttons.indexOf(e.getSource())==1) {
                     //Icon s1=buttons.get(1).getIcon();
                    // System.out.println("c on"+buttons.indexOf(e.getSource()));
                    //JButton  button1 = buttons.get(5);
                    if (indexOfBlank == 0) {
                        Collections.swap(buttons,1,0);
                        drawButtons();
                        indexOfBlank = 1;
                        refresh();
                      //buttons.get(0).setIcon(s1);
                      //buttons.get(1).setIcon(star);
                    }else  if (indexOfBlank == 2) {
                        Collections.swap(buttons,1,2);
                        drawButtons();
                        indexOfBlank = 1;
                        refresh();
                      //buttons.get(2).setIcon(s1);
                      //buttons.get(1).setIcon(star);
                    }else  if (indexOfBlank == 4) {
                        Collections.swap(buttons,1,4);
                        drawButtons();
                        indexOfBlank = 1;
                        refresh();
                      //buttons.get(4).setIcon(s1);
                      //buttons.get(1).setIcon(star);
                    }
                    
                }
                
                
                else if (buttons.indexOf(e.getSource())==2) {
                     //Icon s1=buttons.get(2).getIcon();
                   //  System.out.println("c on"+buttons.indexOf(e.getSource()));
                    //JButton  button1 = buttons.get(5);
                    if (indexOfBlank == 1) {
                        Collections.swap(buttons,2,1);
                        drawButtons();
                        indexOfBlank = 2;
                        refresh();
                      //buttons.get(1).setIcon(s1);
                      //buttons.get(2).setIcon(star);
                    }else  if (indexOfBlank == 5) {
                        Collections.swap(buttons,2,5);
                        drawButtons();
                        indexOfBlank = 2;
                        refresh();
                      //buttons.get(5).setIcon(s1);
                      //buttons.get(2).setIcon(star);
                    }
                    
                }
                
                else if (buttons.indexOf(e.getSource())==3) {
                     //Icon s1=buttons.get(3).getIcon();
                   //  System.out.println("c on"+buttons.indexOf(e.getSource()));
                    //JButton  button1 = buttons.get(5);
                    if (indexOfBlank == 0) {
                        Collections.swap(buttons,3,0);
                        drawButtons();
                        indexOfBlank = 3;
                        refresh();
                      //buttons.get(0).setIcon(s1);
                      //buttons.get(3).setIcon(star);
                    }else  if (indexOfBlank == 4) {
                        Collections.swap(buttons,3,4);
                        drawButtons();
                        indexOfBlank = 3;
                        refresh();
                      //buttons.get(4).setIcon(s1);
                      //buttons.get(3).setIcon(star);
                    }else  if (indexOfBlank == 6) {
                        Collections.swap(buttons,3,6);
                        drawButtons();
                        indexOfBlank = 3;
                        refresh();
   

                    }
                    
                }
                
                else if (buttons.indexOf(e.getSource())==4) {

                    if (indexOfBlank == 1) {
                        Collections.swap(buttons,4,1);
                        drawButtons();
                        indexOfBlank = 4;
                        refresh();

                    }else  if (indexOfBlank == 3) {
                        Collections.swap(buttons,4,3);
                        drawButtons();
                        indexOfBlank = 4;
                        refresh();

                    }else  if (indexOfBlank == 5) {
                        Collections.swap(buttons,4,5);
                        drawButtons();
                        indexOfBlank = 4;
                        refresh();

                    }else  if (indexOfBlank == 7) {
                        Collections.swap(buttons,4,7);
                        drawButtons();
                        indexOfBlank = 4;
                        refresh();
                    }
                    
                    
                }
                
                else if (buttons.indexOf(e.getSource())==5) {

                    if (indexOfBlank == 8) {
                        Collections.swap(buttons,5,8);
                        drawButtons();
                        indexOfBlank = 5;
                        refresh();

                    }else  if (indexOfBlank == 2) {
                        Collections.swap(buttons,5,2);
                        drawButtons();
                        indexOfBlank = 5;
                        refresh();

                    }else  if (indexOfBlank == 4) {
                        Collections.swap(buttons,5,4);
                        drawButtons();
                        indexOfBlank = 5;
                        refresh();
                    }
                    
                }
                 
                else if (buttons.indexOf(e.getSource())==6) {
                    if (indexOfBlank == 3) {
                        Collections.swap(buttons,6,3);
                        drawButtons();
                        indexOfBlank = 6;
                        refresh();
                        
                    }else  if (indexOfBlank == 7) {
                        Collections.swap(buttons,6,7);
                        drawButtons();
                        indexOfBlank = 6;
                        refresh();
                    
                    }
                    
                }
                 
                else if (buttons.indexOf(e.getSource())==7) {
                    
                    if (indexOfBlank == 4) {
                        
                        Collections.swap(buttons,7,4);
                        
                        drawButtons();
                        indexOfBlank = 7;
                        refresh();
                  
                    }
                    else  if (indexOfBlank == 6) {
                        Collections.swap(buttons,7,6);
                        
                        drawButtons();
                        indexOfBlank = 7;
                        refresh();
           
                    }
                    else  if (indexOfBlank == 8) {
                       
                        Collections.swap(buttons,7,8);
           
                        drawButtons();
                        indexOfBlank = 7;
                        refresh();
                       
                    }
                    
                }
                
                else if (buttons.indexOf(e.getSource())==8) {
                   
                    if (indexOfBlank == 5) {
                          //System.out.println("dummy name:" + buttons.get(indexOfBlank).getName());
                        Collections.swap(buttons,8,5);
                        drawButtons();
                        indexOfBlank = 8;
                        refresh();
                     
                    }else  if (indexOfBlank == 7) {
                       
                        Collections.swap(buttons,8,7);
                         
                        drawButtons();
                        indexOfBlank = 8;
                        refresh();
                       
                      
                        
                      //buttons.get(7).setIcon(s1);
                      //buttons.get(8).setIcon(star);
                    }
                    
                }
                
                isCompleted();
                 
           
            }

            private void isCompleted() {
                int count = 0;
                
                for(JButton bt:buttons){
                    if(buttons.indexOf(bt) == Integer.parseInt(bt.getName())){
                        count++;
                    }
                }
                if(count == 9)
                {
                        System.out.println("Win :)");
                    Congrats congrats = new Congrats();
                    setVisible(false);
                }
                else {
                    System.out.println("Not completed");
                  //  GameOver gameOver = new GameOver();
                }
                
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        button.setName(Integer.toString(i));
        buttons.add(button);
    }

    private void refresh() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                revalidate();
                repaint();

            }
        });
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void drawButtons() {
        
         for (int i = 0; i < 9; i++) {

            dummy = buttons.get(i);
            jumblePanel.add(dummy);
          //  System.out.println(dummy.getName());

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class MouseHandler extends MouseAdapter {

        private int first = -1;
        private boolean won = false;

        public void mousePressed(MouseEvent e) {
            //if (dummy == null) {
               // Point j = dummy.getLocation();

            }
        }
    }

    class ItemHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }


 