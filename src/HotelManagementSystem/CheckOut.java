package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice customerId;
    JLabel lblroomnum,lblcheckintime,lblcheckouttime;
    JButton checkoutbtn,back;
    CheckOut(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel checkout=new JLabel("Checkout");
        checkout.setBounds(100,20,100,30);
        checkout.setForeground(Color.BLUE);
        checkout.setFont(new Font("Times New Roman" ,Font.BOLD,20));
        add(checkout);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setFont(new Font("Times New Roman" ,Font.PLAIN,16));
        lblid.setBounds(30,80,100,20);
        add(lblid);

        customerId=new Choice();
        customerId.setBounds(150,80,200,30);
        add(customerId);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/tick.png"));
        Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(350,78,30,25);
        add(tick);

        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        lblroomnum=new JLabel();
        lblroomnum.setBounds(150,130,100,30);
        add(lblroomnum);

        JLabel lblcheckin=new JLabel("Check In");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(150,180,200,30);
        add(lblcheckintime);

        JLabel lblcheckout=new JLabel("Check Out");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);

        Date date=new Date();
        lblcheckouttime=new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,200,30);
        add(lblcheckouttime);

        checkoutbtn= new JButton("CheckOut");
        checkoutbtn.setBackground(Color.BLACK);
        checkoutbtn.setForeground(Color.WHITE);
        checkoutbtn.setBounds(30,280,120,30);
        checkoutbtn.addActionListener(this);
        add(checkoutbtn);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()) {
                customerId.add(rs.getString("number"));
                lblroomnum.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkinTime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Images/checkout.jpeg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(390,50,400,250);
        add(image);

        setBounds(250,150,830,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkoutbtn){
            String query1="delete from customer where number='"+customerId.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnum='"+lblroomnum.getText()+"'";

            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
