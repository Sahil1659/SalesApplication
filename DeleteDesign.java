package CONN.Wipro.Flight.Design;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import CONN.Wipro.Flight.DAO.StockDao;

public class DeleteDesign extends JFrame implements ActionListener {
	JFrame f3=new JFrame("Delete Stock");
	JLabel label=new JLabel();
     JPanel panel=new JPanel(); 
     JButton b3=new JButton("Delete Now");
     JTextField tf5;
   public DeleteDesign(){
    panel.setBounds(0,0,900,900);
    panel.setBackground(Color.yellow); 
    label.setBounds(10, 20, 2000, 200);
    label.setText("Please Enter all the fields:-");
    label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
    label.setForeground(Color.red);
    JLabel l1=new JLabel("Enter Product Id:-");
    l1.setBounds(50, 180, 500, 50);
    l1.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
    f3.add(l1);
    tf5=new JTextField();
    tf5.setBounds(300, 180, 300, 40);
    tf5.setFont(new Font(Font.SERIF, Font.BOLD, 24));
    f3.add(tf5);
    
   
    b3.setBounds(270, 250, 200, 50);
    b3.setFont(new Font(Font.SERIF, Font.BOLD, 30));
    b3.setBackground(Color.black);
    b3.setForeground(Color.white);
    b3.addActionListener(this);
    f3.add(b3);
	f3.setSize(800,500);
	f3.add(label);
	
	f3.add(panel);
	f3.setVisible(true);
   }

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b3) {
String pid=tf5.getText();
if(pid.isEmpty()) {
JOptionPane.showMessageDialog(f3,"TextField can't be empty .","Alert",JOptionPane.WARNING_MESSAGE);
}
else
{
try {
	if(StockDao.deleteStock(pid))
	{
		JOptionPane.showMessageDialog(f3,"Stock entry deleted successfully .","Alert",JOptionPane.WARNING_MESSAGE);	
		tf5.setText("");		
	}
	else
	{
		JOptionPane.showMessageDialog(f3,"Enter valid Product ID .","Alert",JOptionPane.WARNING_MESSAGE);	
		
	}
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	//e1.printStackTrace();
}
}
	}

}
}
