package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomers extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfnum,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale, rbfemale;
    JLabel checkintime;
    Choice croom;
    JButton Add, back;
    AddCustomers(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(text);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lblid);
        String options[]={"Aadhaar Card","Passport","Driving License","Voter-id Card","Pan card"};
        comboid=new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnum=new JLabel("Number");
        lblnum.setBounds(35,120,100,20);
        lblnum.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lblnum);
        tfnum=new JTextField();
        tfnum.setBounds(200,120,150,25);
        add(tfnum);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lblgender);
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,200,60,25);
        rbmale.setFont(new Font("Times New Roman",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(270,200,100,25);
        rbfemale.setFont(new Font("Times New Roman",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lblcountry);
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom=new JLabel("Room No.");
        lblroom.setBounds(35,280,100,20);
        lblroom.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lblroom);
        croom=new Choice();
        try {
            Conn c=new Conn();
            String query="select * from room where availability='Available'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnum"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lbltime);
        Date date=new Date();
        checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(checkintime);

        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(lbldeposit);
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        Add=new JButton("Add");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(50,410,120,30);
        Add.addActionListener(this);
        add(Add);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/customer.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(350,50,340,400);
        add(image);
        setBounds(200,160,700,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Add){
            String id=(String) comboid.getSelectedItem();
            String number=tfnum.getText();
            String name= tfname.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time= checkintime.getText();
            String deposit= tfdeposit.getText();

            try{
                Conn c=new Conn();
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2="update room set availability='Occupied' where roomnum='"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new AddCustomers();
    }
}
