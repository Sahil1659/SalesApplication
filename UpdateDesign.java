package CONN.Wipro.Flight.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import CONN.Wipro.Flight.DAO.StockDao;

public class UpdateDesign extends JFrame implements ActionListener {
	
	JFrame f4;
	JLabel label,l1,l2;
	JTextField tf6,tf7;
	JPanel panel;
	JButton b4;
	public UpdateDesign() {
	
	f4=new JFrame("Update Stock");
	label=new JLabel();
     panel=new JPanel(); 
      b4=new JButton("Update Now");
   
    panel.setBounds(0,0,900,900);
    panel.setBackground(Color.yellow); 
    label.setBounds(10, 20, 2000, 200);
    label.setText("Please Enter all the fields:-");
    label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
    label.setForeground(Color.red);
    l1=new JLabel("Enter Product Id:-");
    l1.setBounds(50, 180, 500, 50);
    l1.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
    f4.add(l1);
    tf6=new JTextField();
    tf6.setBounds(300, 180, 300, 40);
    tf6.setFont(new Font(Font.SERIF, Font.BOLD, 24));
    f4.add(tf6);
    l2=new JLabel("Enter Quantity :-");
    l2.setBounds(50, 250, 500, 50);
    l2.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
    f4.add(l2);
    tf7=new JTextField();
    tf7.setBounds(300, 250, 300, 40);
    tf7.setFont(new Font(Font.SERIF, Font.BOLD, 24));
    f4.add(tf7);
    
   
    b4.setBounds(270, 330, 200, 50);
    b4.setFont(new Font(Font.SERIF, Font.BOLD, 30));
    b4.setBackground(Color.black);
    b4.setForeground(Color.white);
    b4.addActionListener(this);
    f4.add(b4);
	f4.setSize(800,500);
	f4.add(label);
	
	f4.add(panel);
	f4.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pid=tf6.getText();
		String qty=tf7.getText();
		if(pid.isEmpty()||qty.isEmpty())
		{
			JOptionPane.showMessageDialog(f4,"TextField can't be empty.","Alert",JOptionPane.WARNING_MESSAGE);      
			return ;
			}
			
			try {
			     Integer.parseInt(qty);
			   
			    
			}
			catch (NumberFormatException f) {
			     JOptionPane.showMessageDialog(f4,"Quantity must be Number.","Alert",JOptionPane.WARNING_MESSAGE); 
			}
			finally {
				try {
					int result=StockDao.updateStock(pid, Integer.parseInt(qty));
					if(result==0) {
						JOptionPane.showMessageDialog(f4,"Updated Successfully.","Alert",JOptionPane.WARNING_MESSAGE); 
					tf6.setText("");
					tf7.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(f4,"Please check Product ID.","Alert",JOptionPane.WARNING_MESSAGE); 				
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
		}
	}
	}


