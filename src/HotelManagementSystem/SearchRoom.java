package HotelManagementSystem;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedcombo;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search For Room");
        heading.setFont(new Font("Times New Roman",Font.BOLD,20));
        heading.setBounds(400,30,200,30);
        add(heading);

        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblbedtype.setBounds(60,100,100,20);
        add(lblbedtype);
        String bedOptions[]={"Single Bed","Double Bed"};
        bedcombo=new JComboBox(bedOptions);
        bedcombo.setBounds(150,100,100,25);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);

        available=new JCheckBox("Only Display Available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel c1=new JLabel("Room Number");
        c1.setBounds(50,160,100,20);
        add(c1);

        JLabel c2=new JLabel("Availability");
        c2.setBounds(240,160,100,20);
        add(c2);

        JLabel c3=new JLabel("Cleaning Status");
        c3.setBounds(400,160,100,20);
        add(c3);

        JLabel c4=new JLabel("Price");
        c4.setBounds(640,160,100,20);
        add(c4);

        JLabel c5=new JLabel("Bed Type");
        c5.setBounds(800,160,100,20);
        add(c5);

        table=new JTable();
        table.setBounds(0,200,940,300);
        add(table);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
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
                String query1="select * from room where bedtype='"+bedcombo.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND bedtype='"+bedcombo.getSelectedItem()+"'";
                Conn c=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs=c.s.executeQuery(query2);
                }else{
                    rs=c.s.executeQuery(query1);
                }
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

        new SearchRoom();
    }
}
