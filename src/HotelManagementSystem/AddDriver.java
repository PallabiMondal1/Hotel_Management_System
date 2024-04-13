package HotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox availablecombo, gendercombo;
    JButton addDriver, cancel;
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Add Driver");
        heading.setFont(new Font("Times New Roman",Font.BOLD,18));
        heading.setBounds(150,30,200,20);
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblname.setBounds(60,80,120,30);
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblage.setBounds(60,130,120,30);
        add(lblage);
        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblgender.setBounds(60,180,120,30);
        add(lblgender);
        String gender[]={"Male","Female"};
        gendercombo=new JComboBox(gender);
        gendercombo.setBounds(200,180,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblcompany=new JLabel("Car Company");
        lblcompany.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblcompany.setBounds(60,230,120,30);
        add(lblcompany);
        tfcompany=new JTextField();
        tfcompany.setBounds(200,230,150,30);
        add(tfcompany);

        JLabel lblmodel=new JLabel("Car Model");
        lblmodel.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblmodel.setBounds(60,280,120,30);
        add(lblmodel);
        tfmodel=new JTextField();
        tfmodel.setBounds(200,280,150,30);
        add(tfmodel);

        JLabel lblavailable=new JLabel("Availability");
        lblavailable.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lblavailable.setBounds(60,330,120,30);
        add(lblavailable);
        String available[]={"Available","Busy"};
        availablecombo=new JComboBox(available);
        availablecombo.setBounds(200,330,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Times New Roman",Font.PLAIN,18));
        lbllocation.setBounds(60,380,120,30);
        add(lbllocation);
        tflocation=new JTextField();
        tflocation.setBounds(200,380,150,30);
        add(tflocation);

        addDriver=new JButton("Add Driver");
        addDriver.setForeground(Color.WHITE);
        addDriver.setBackground(Color.BLACK);
        addDriver.setBounds(60,430,130,30);
        addDriver.addActionListener(this);
        add(addDriver);

        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,430,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/driver.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,320,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,80,500,350);
        add(image);

        setBounds(200,160,980,520);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addDriver){
            String name= tfname.getText();
            String age= tfage.getText();
            String gender=(String) gendercombo.getSelectedItem();
            String company= tfcompany.getText();
            String availability=(String) availablecombo.getSelectedItem();
            String brand= tfmodel.getText();
            String location= tflocation.getText();

            try{
                Conn c=new Conn();
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+availability+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new AddDriver();
    }
}
