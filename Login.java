
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField reusername , repassword ;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel hhusername = new JLabel("USERNAME");
        hhusername.setBounds(40,20,100,30);
        add(hhusername);
        
        reusername = new JTextField();
        reusername.setBounds(150,20,150,30);
        add(reusername);
        
        JLabel hhpassword = new JLabel("PASSWORD");
        hhpassword.setBounds(40,70,100,30);
        add(hhpassword);
        
        repassword = new JTextField();
        repassword.setBounds(150,70,150,30);
        add(repassword);
        
        JButton c1 = new JButton("LOGIN");
        c1.setBounds(150,140,150,30);
        c1.setBackground(Color.BLACK);
        c1.setForeground(Color.WHITE);
        c1.addActionListener(this);
        add(c1);
        
        ImageIcon h1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        Image h2 = h1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon h3 = new ImageIcon(h2);
        JLabel image1 = new JLabel(h3);
        image1.setBounds(350,0,200,200 );
        add(image1);
        
        
        
        
        setSize(600, 300);
        setLocation(450,200);
        setVisible(true);
    }    
    public void actionPerformed(ActionEvent ae){
        try {
            String username = reusername.getText();
            String password = repassword.getText();
            
            Conn c = new Conn();
            String query = "select* from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
                
            }else{
                JOptionPane.showMessageDialog(null, "invalid");
                setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();

    }
  
    }   
    
    public static void main(String args[]){
        new Login();
    }
}
