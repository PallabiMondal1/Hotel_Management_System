package HotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1330,700);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/dashboard.jpg"));
        Image i2=i1.getImage().getScaledInstance(1330,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1330,700);
        add(image);

        JLabel text=new JLabel("WELCOME TO BLISSFUL HAVEN");
        text.setBounds(300,80,1000,50);
        text.setFont(new Font("Times New Roman",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1350,40);
        image.add(mb);

        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.ORANGE);
        mb.add(hotel);
        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        admin.addActionListener(this);
        mb.add(admin);

        JMenuItem addEmployee=new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        JMenuItem addRooms=new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        admin.add(addRooms);
        JMenuItem addDrivers=new JMenuItem("ADD DRIVERS");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }

    }
    public static void main(String[] args) {
        new Dashboard();
    }
}
