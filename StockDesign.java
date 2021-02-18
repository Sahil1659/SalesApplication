package CONN.Wipro.Flight.Design;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import CONN.Wipro.Flight.Bean.Product;
import CONN.Wipro.Flight.Service.Administator;

public class StockDesign extends JFrame implements ActionListener {
	JLabel label,l1,l2,l3,l4;
	JPanel panel;
	JButton b2;
	JFrame f2=new JFrame("Insert Stock");
	JTextField tf1,tf2,tf3,tf4;
	public StockDesign() {
	label=new JLabel();
    panel=new JPanel(); 
     b2=new JButton("Insert Now");
  
   panel.setBounds(0,0,900,900);
   panel.setBackground(Color.yellow); 
   label.setBounds(10, 20, 2000, 200);
   label.setText("Please Enter all the fields:-");
   label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
   label.setForeground(Color.red);
   l1=new JLabel("Enter Product Name:-");
   l1.setBounds(50, 180, 500, 50);
   l1.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
   f2.add(l1);
   tf1=new JTextField();
   tf1.setBounds(300, 180, 300, 40);
   tf1.setFont(new Font(Font.SERIF, Font.BOLD, 24));
   f2.add(tf1);
   
   l2=new JLabel("Enter Quantity On Hand:-");
   l2.setBounds(50, 250, 500, 50);
   l2.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
   f2.add(l2);
   tf2=new JTextField();
   tf2.setBounds(300, 250, 300, 40);
   tf2.setFont(new Font(Font.SERIF, Font.BOLD, 24));
   f2.add(tf2);
   
   l3=new JLabel("Enter Reorder Level:-");
   l3.setBounds(50, 320, 500, 50);
   l3.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
   f2.add(l3);
   tf3=new JTextField();
   tf3.setBounds(300, 320, 300, 40);
   tf3.setFont(new Font(Font.SERIF, Font.BOLD, 24));
   f2.add(tf3);
   
   l4=new JLabel("Enter Unit Price:-");
   l4.setBounds(50, 390, 500, 50);
   l4.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
   f2.add(l4);
   tf4=new JTextField();
   tf4.setBounds(300, 390, 300, 40);
   tf4.setFont(new Font(Font.SERIF, Font.BOLD, 24));
   f2.add(tf4);
   b2.setBounds(270, 490, 200, 50);
   b2.setFont(new Font(Font.SERIF, Font.BOLD, 30));
   b2.setBackground(Color.black);
   b2.setForeground(Color.white);
   b2.addActionListener(this);
   f2.add(b2);
	f2.setSize(900,900);
	f2.add(label);
	
	f2.add(panel);
	f2.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) {
			String name=tf1.getText();
			String qty=tf2.getText();
			String rorder=tf3.getText();
			String price=tf4.getText();
			if(tf1.getText().isEmpty()|| tf2.getText().isEmpty()|| tf3.getText().isEmpty()|| tf4.getText().isEmpty()) {
				JOptionPane.showMessageDialog(f2,"TextField can't be empty.","Alert",JOptionPane.WARNING_MESSAGE);      
			return ;
			}
			
			try {
			     Integer.parseInt(qty);
			     Integer.parseInt(rorder);
			     Float.parseFloat(price);
			    
			}
			catch (NumberFormatException f) {
			     JOptionPane.showMessageDialog(f2,"Quantity, Reorder and Price must be Number.","Alert",JOptionPane.WARNING_MESSAGE); 
			}
			
			finally {
				Product p=new Product();
				p.setProductName(name);
				p.setQuantityOnHand(Integer.parseInt(qty));
				p.setReorderLevel(Integer.parseInt(rorder));
				p.setProductUnitPrice(Float.parseFloat(price));
				try {
					int result=Administator.insertStock(p);
					if(result==1)
					{
						JOptionPane.showMessageDialog(f2,"Inserted Successfully.","Alert",JOptionPane.WARNING_MESSAGE);
						tf1.setText("");	tf2.setText("");	tf3.setText("");	tf4.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(f2,"Product Name not valid.","Alert",JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
			}
			
	}
		}
	}