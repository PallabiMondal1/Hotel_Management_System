package HotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user=new JLabel("Username");
        user.setBounds(40,40,100,30);
        add(user);
        username=new JTextField();
        username.setBounds(150,40,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(40,100,100,30);
        add(pass);
        password=new JPasswordField();
        password.setBounds(150,100,150,30);
        add(password);

        login=new JButton("Login");
        login.setBounds(40,170,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,170,140,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/user.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,180,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(300,200,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user=username.getText();
            String pass=password.getText();
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+user+"' and password='"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or Password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
