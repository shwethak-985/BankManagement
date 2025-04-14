package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {
    JLabel l2;
    JButton b1;
    String pin;
    BalanceEnquriy(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));

        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);
        JLabel l1=new JLabel("YOUR CURRENT BALANCE RS.");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(430,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);
        l2=new JLabel();
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(430,220,400,35);
        l2.setForeground(Color.WHITE);
        l3.add(l2);
        b1=new JButton("BACK");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance=0;
        try{
            Connn c=new Connn();
            ResultSet resultSet=c.statement.executeQuery("Select * from bank where pin='"+pin+"'");
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        l2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }
    public static void main(String args[]){
        new BalanceEnquriy("");

    }

}
