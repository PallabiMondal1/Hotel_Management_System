package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/room2.png"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel c1=new JLabel("Room Number");
        c1.setBounds(5,10,100,20);
        add(c1);

        JLabel c2=new JLabel("Availability");
        c2.setBounds(110,10,100,20);
        add(c2);

        JLabel c3=new JLabel("Cleaning Status");
        c3.setBounds(205,10,100,20);
        add(c3);

        JLabel c4=new JLabel("Price");
        c4.setBounds(320,10,100,20);
        add(c4);

        JLabel c5=new JLabel("Bed Type");
        c5.setBounds(415,10,100,20);
        add(c5);

        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(150,50,1050,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Room();
    }
}
