
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    
    
    int number = ran.nextInt(999999);
    
    JTextField w1 , q , m2 , v2 , k1 , E3 , V3 , adh2 ;
    JDateChooser dcob;
    JComboBox H3;
    JLabel emp;
    JButton add , back;
    
    
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel h1 = new JLabel("ADD EMPLOYEE DETAILS");
        h1.setBounds(320,30,500,50);
        h1.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(h1);
        
        JLabel Elabel = new JLabel("NAME");
        Elabel.setBounds(50 , 150 , 150 , 30);
        Elabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(Elabel);
        
        w1 = new JTextField();
        w1.setBounds(200, 150 , 150 , 30);
        add(w1);
        
        JLabel Hlabel = new JLabel("FATHER'S NAME");
        Hlabel.setBounds(400 , 150 , 250 , 30);
        Hlabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(Hlabel);
        
        q = new JTextField();
        q.setBounds(600, 150 , 150 , 30);
        add(q);
        
        JLabel dob = new JLabel("DATE OF BIRTH");
        dob.setBounds(50 , 200 , 150 , 30);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);
        
        dcob = new JDateChooser();
        dcob.setBounds(200,200,150,30);
        add(dcob);
        
        JLabel m1 = new JLabel("SALARY");
        m1.setBounds(400 , 200 , 150 , 30);
        m1.setFont(new Font("serif", Font.PLAIN, 20));
        add(m1);
        
        m2 = new JTextField();
        m2.setBounds(600, 200 , 150 , 30);
        add(m2);
        
        JLabel v1 = new JLabel("ADDRESS");
        v1.setBounds(50 , 250 , 150 , 30);
        v1.setFont(new Font("serif", Font.PLAIN, 20));
        add(v1);
        
        v2 = new JTextField();
        v2.setBounds(200, 250 , 150 , 30);
        add(v2);
        
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(400 , 250 , 150 , 30);
        phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(phone);
        
        k1 = new JTextField();
        k1.setBounds(600, 250 , 150 , 30);
        add(k1);
        
        JLabel E2 = new JLabel("EMAIL");
        E2.setBounds(50 , 300 , 150 , 30);
        E2.setFont(new Font("serif", Font.PLAIN, 20));
        add(E2);
        
        E3 = new JTextField();
        E3.setBounds(200, 300 , 150 , 30);
        add(E3);
        
        JLabel H1 = new JLabel("HIGHEST EDUCATION");
        H1.setBounds(400 , 300 , 300 , 30);
        H1.setFont(new Font("serif", Font.PLAIN, 20));
        add(H1);
        
        String courses[] = {"BBA" , "BCA", "BA" , "B.COM" , "BTECH" , "MTECH" , "PHD"};
        H3 = new JComboBox(courses);
        H3.setBackground(Color.WHITE);
        H3.setBounds(610, 300 , 150 , 30);
        add(H3);
        
        JLabel E4 = new JLabel("DESIGNATION");
        E4.setBounds(50 , 350 , 150 , 30);
        E4.setFont(new Font("serif", Font.PLAIN, 20));
        add(E4);
        
        V3 = new JTextField();
        V3.setBounds(200, 350 , 150 , 30);
        add(V3);
        
        JLabel ADH = new JLabel("AADHAR NUMBER");
        ADH.setBounds(400 , 350 , 250 , 30);
        ADH.setFont(new Font("serif", Font.PLAIN, 20));
        add(ADH);
        
        adh2 = new JTextField();
        adh2.setBounds(600, 350 , 150 , 30);
        add(adh2);
        
        JLabel empid = new JLabel("EMPLOYEE ID");
        empid.setBounds(50 , 400 , 150 , 30);
        empid.setFont(new Font("serif", Font.PLAIN, 20));
        add(empid);
     
        emp = new JLabel("" + number);
        emp.setBounds(200 , 400 , 150 , 30);
        emp.setFont(new Font("serif", Font.PLAIN, 20));
        add(emp);
        
        add = new JButton("ADD DETAILS");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
       
        
        
        
        
        
        setSize(900, 700);
        setLocation(300 , 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name = w1.getText();
            String fname = q.getText();
            String dob = ((JTextField) dcob.getDateEditor().getUiComponent()).getText();
            String salary = m2.getText();
            String address = v2.getText();
            String phone = k1.getText();
            String email = E3.getText();
            String education = (String)H3.getSelectedItem();
            String designation =  V3.getText();
            String aadhar = adh2.getText();
            String empId = emp.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee Values('"+name+"','"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added sucessfully");
                setVisible(false);
                new Home();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
            
    }
        
}
    public static void main(String args[]){
        new AddEmployee();
    }
}
