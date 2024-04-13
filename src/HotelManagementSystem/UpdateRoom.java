package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.math.*;

public class UpdateRoom extends JFrame implements ActionListener{
    Choice cCustomer;
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
    JButton check,update,back;
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Update Room Status");
        text.setBounds(120,20,250,30);
        text.setFont(new Font("Times New Roman",Font.BOLD,24));
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,120,20);
        lblid.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblid);

        cCustomer=new Choice();
        cCustomer.setBounds(200,80,150,25);
        add(cCustomer);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cCustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblroom=new JLabel("Room No.");
        lblroom.setBounds(30,130,120,20);
        lblroom.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblroom);
        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lblavailable=new JLabel("Availability");
        lblavailable.setBounds(30,180,120,20);
        lblavailable.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblavailable);
        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lblstatus=new JLabel("Cleaning Status");
        lblstatus.setBounds(30,230,120,20);
        lblstatus.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblstatus);
        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);

        check=new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/room3.jpeg"));
        Image i2=i1.getImage().getScaledInstance(320,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(310,30,500,300);
        add(image);

        setBounds(200,150,760,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id= cCustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnum='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaningstatus"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==update) {
            String number= cCustomer.getSelectedItem();
            String room=tfroom.getText();
            String status=tfstatus.getText();
            String available=tfavailable.getText();

            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set availability='"+available+"',cleaningstatus='"+status+"' where roomnum='"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
