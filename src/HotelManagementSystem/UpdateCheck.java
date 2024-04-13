package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.math.*;

public class UpdateCheck extends JFrame implements ActionListener{
    Choice cCustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Update Status");
        text.setBounds(120,20,200,30);
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
        lblroom.setBounds(30,120,120,20);
        lblroom.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblroom);
        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,160,120,20);
        lblname.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblcheckin=new JLabel("Checkin Time");
        lblcheckin.setBounds(30,200,120,20);
        lblcheckin.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblcheckin);
        tfcheckin=new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);

        JLabel lblpaid=new JLabel("Amount Paid");
        lblpaid.setBounds(30,240,120,20);
        lblpaid.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblpaid);
        tfpaid=new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        JLabel lblpending=new JLabel("Pending Amount");
        lblpending.setBounds(30,280,120,20);
        lblpending.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(lblpending);
        tfpending=new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);

        check=new JButton("Check");
        check.setBounds(30,340,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(150,340,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(270,340,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/checkInOut.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(300,10,500,400);
        add(image);
        
        setBounds(200,150,760,450);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkinTime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnum='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountPaid);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==update) {
            String number= cCustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfpaid.getText();

            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set deposit='"+deposit+"' where room='"+room+"'");
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
        new UpdateCheck();
    }
}
