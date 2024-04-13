package HotelManagementSystem;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice carType;
    JCheckBox available;
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Pickup Service");
        heading.setFont(new Font("Times New Roman",Font.BOLD,20));
        heading.setBounds(400,30,200,30);
        add(heading);

        JLabel lblcartype=new JLabel("Type of Car");
        lblcartype.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblcartype.setBounds(60,100,100,20);
        add(lblcartype);
        carType=new Choice();
        carType.setBounds(170,100,200,25);
        add(carType);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()) {
                carType.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel c1=new JLabel("Name");
        c1.setBounds(30,160,100,20);
        add(c1);

        JLabel c2=new JLabel("Age");
        c2.setBounds(200,160,100,20);
        add(c2);

        JLabel c3=new JLabel("Gender");
        c3.setBounds(320,160,100,20);
        add(c3);

        JLabel c4=new JLabel("Company");
        c4.setBounds(430,160,100,20);
        add(c4);

        JLabel c5=new JLabel("Brand");
        c5.setBounds(570,160,100,20);
        add(c5);

        JLabel c6=new JLabel("Availability");
        c6.setBounds(700,160,100,20);
        add(c6);

        JLabel c7=new JLabel("Location");
        c7.setBounds(830,160,100,20);
        add(c7);

        table=new JTable();
        table.setBounds(0,200,940,300);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(200,80,940,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query="select * from driver where brand='"+carType.getSelectedItem()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Pickup();
    }
}
