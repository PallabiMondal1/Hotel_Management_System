package HotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
//        setSize(1066,565); //set the width and height of the frame
//        setLocation(100,100); //set the location origin start from left-top
        setBounds(100,100,1066,565);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/hotel.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1066,565);
        add(image);

        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,100);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        JButton next=new JButton("Next");
        next.setBounds(920,450,120,40);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.magenta);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,18));
        image.add(next);
        setVisible(true); //by default visibility is false so it marks as true

        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(700);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(700);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e){

        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {

        new HotelManagementSystem();
    }
}
