package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rflash extends JFrame implements ActionListener{
    
    Rflash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif",Font.PLAIN, 60));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50 , 100 ,1050, 500 );
        add(image);
        
        JButton clickMe = new JButton("CLICK HERE TO CONTINUE");
        clickMe.setBounds(400, 400, 300, 70);
        clickMe.setBackground(Color.BLACK);
        clickMe.setForeground(Color.WHITE);
        clickMe.addActionListener(this);
        image.add(clickMe);
        
       
        
       
       
        
        
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
        
        
         while(true){
            heading.setVisible(false);
            
            try{
                Thread.sleep(500);
            }catch (Exception e){
                
            }
            
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }
    public static void main(String args[]){
        new Rflash();
    }
}    