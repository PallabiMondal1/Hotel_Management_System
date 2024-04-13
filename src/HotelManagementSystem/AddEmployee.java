package HotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfgender,tfsalary,tfemail,tfphone,tfaadhaar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
       setLayout(null);

       JLabel lblname=new JLabel("NAME");
       lblname.setBounds(60,30,120,30);
       lblname.setFont(new Font("Times New Roman",Font.PLAIN,17));
       add(lblname);
       tfname=new JTextField();
       tfname.setBounds(180,30,150,30);
       add(tfname);

        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lblage);
        tfage=new JTextField();
        tfage.setBounds(180,80,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lblgender);
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(180,130,70,30);
        rbmale.setFont(new Font("Times New Roman",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(260,130,70,30);
        rbfemale.setFont(new Font("Times New Roman",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lbljob);
        String str[]={"Front Desk Clerks","Housekeeping",
                "Kitchen Staff","Chef","Room Service","Waiter/Waitress","Manager","Accountant"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(180,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lblsalary);
        tfsalary=new JTextField();
        tfsalary.setBounds(180,230,150,30);
        add(tfsalary);

        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lblphone);
        tfphone=new JTextField();
        tfphone.setBounds(180,280,150,30);
        add(tfphone);

        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lblemail);
        tfemail=new JTextField();
        tfemail.setBounds(180,330,150,30);
        add(tfemail);

        JLabel lblaadhaar=new JLabel("AADHAAR NO.");
        lblaadhaar.setBounds(60,380,120,30);
        lblaadhaar.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(lblaadhaar);
        tfaadhaar=new JTextField();
        tfaadhaar.setBounds(180,380,150,30);
        add(tfaadhaar);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(180,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/service.jpg"));
        Image i2=i1.getImage().getScaledInstance(430,430,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,40,450,450);
        add(image);

       getContentPane().setBackground(Color.WHITE);
       setBounds(250,160,850,510);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhaar=tfaadhaar.getText();

        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }else if(rbfemale.isSelected()){
            gender="Female";
        }
        String job=(String) cbjob.getSelectedItem(); //bcs it returns obj so typecast it
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        try{
            Conn c=new Conn();
            String query= "insert into Employee values('"+name+"','"+age+"','"+gender+"','"+job+"','" + salary+"','"+phone+"','"+email+"','"+aadhaar+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new AddEmployee();
    }
}
