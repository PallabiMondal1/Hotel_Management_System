package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Departments extends JFrame implements ActionListener{
    JTable table;
    JButton Back;
    Departments(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel dep=new JLabel("Departments");
        dep.setBounds(120,10,120,20);
        dep.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(dep);

        JLabel budget=new JLabel("Budget");
        budget.setBounds(500,10,100,20);
        budget.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(budget);

        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(300,300,120,30);
        Back.addActionListener(this);
        add(Back);

        table=new JTable();
        table.setBounds(0,50,700,400);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        setBounds(300,150,700,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Departments();
    }
}
