package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel c1=new JLabel("Document Type");
        c1.setBounds(10,10,100,20);
        add(c1);

        JLabel c2=new JLabel("Number");
        c2.setBounds(150,10,100,20);
        add(c2);

        JLabel c3=new JLabel("Name");
        c3.setBounds(290,10,100,20);
        add(c3);

        JLabel c4=new JLabel("Gender");
        c4.setBounds(410,10,100,20);
        add(c4);

        JLabel c5=new JLabel("Country");
        c5.setBounds(510,10,100,20);
        add(c5);

        JLabel c6=new JLabel("Room No.");
        c6.setBounds(650,10,100,20);
        add(c6);

        JLabel c7=new JLabel("CheckIn Time");
        c7.setBounds(760,10,100,20);
        add(c7);

        JLabel c8=new JLabel("Deposit");
        c8.setBounds(900,10,100,20);
        add(c8);

        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(150,50,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {

        new CustomerInfo();
    }
}