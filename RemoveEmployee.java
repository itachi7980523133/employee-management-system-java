
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JButton delete , back;
    
    
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50 ,50 ,150 , 30);
        add(labelempId);
        
       cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50 , 100 , 100 , 30);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200 , 100 , 100 , 30);
        add(labelname);
        
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50 , 150 , 100 , 30);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(200 , 150 , 100 , 30);
        add(labelphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50 , 200 , 100 , 30);
        add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(200 , 200 , 100 , 30);
        add(labelemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        cEmpId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        });
  
        
        
        
        delete = new JButton("Delete");
        delete.setBounds(80 , 300 , 100 , 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220 , 300 , 100 , 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
       
        
        setSize(1000, 400);
        setLocation(300 , 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== delete) {
            try{
                Conn c   = new Conn();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
                setVisible(false);
            new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
}
