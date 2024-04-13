package HotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class AddRooms extends JFrame implements ActionListener {
    JTextField tfroom,tfprice;
    JComboBox availablecombo, cleancombo, bedcombo;
    JButton addroom, cancel;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Times New Roman",Font.BOLD,18));
        heading.setBounds(150,30,200,20);
        add(heading);

        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        String availableOptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        String cleanOptions[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblbedtype.setBounds(60,280,120,30);
        add(lblbedtype);
        String bedOptions[]={"Single Bed","Double Bed"};
        bedcombo=new JComboBox(bedOptions);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);

        addroom=new JButton("Add Room");
        addroom.setForeground(Color.WHITE);
        addroom.setBackground(Color.BLACK);
        addroom.setBounds(60,350,130,30);
        addroom.addActionListener(this);
        add(addroom);

        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/room.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,350);
        add(image);

        setBounds(200,160,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addroom){
            String roomnumber= tfroom.getText();
            String availability=(String) availablecombo.getSelectedItem();
            String cleanstatus=(String) cleancombo.getSelectedItem();
            String price= tfprice.getText();
            String bedtype=(String) bedcombo.getSelectedItem();

            try{
                Conn c=new Conn();
                String query="insert into room values('"+roomnumber+"','"+availability+"','"+cleanstatus+"','"+price+"','"+bedtype+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new AddRooms();
    }
}
