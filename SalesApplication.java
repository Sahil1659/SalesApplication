package CONN.Wipro.Flight.main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import CONN.Wipro.Flight.*;
import CONN.Wipro.Flight.Design.*;
public class SalesApplication extends JFrame implements ActionListener {
	
	
	
	JFrame f;
	JLabel label;
	JPanel panel;
	JButton b1;
	 JRadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7;
	    ButtonGroup bg;
	SalesApplication(){
		   
	         f=new JFrame("Sales Application");  
	        label=new JLabel();
	         panel=new JPanel(); 
	         b1=new JButton("Let's Go...");
	       
	        panel.setBounds(0,0,900,900);
	        panel.setBackground(Color.yellow); 
	        label.setBounds(10, 20, 2000, 200);
	        label.setText("Welcome, Please Select the Operation:-");
	        label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
	        label.setForeground(Color.red);
	        rb1=new JRadioButton("Insert Stock");
	        rb1.setBounds(30, 200, 250, 20);
	        rb1.setBackground(Color.yellow);
	      
	        rb1.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb1);
	        rb2=new JRadioButton("Delete Stock");
	        rb2.setBounds(30, 240, 250, 20);
	        rb2.setBackground(Color.yellow);
	       
	        rb2.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb2);
	        rb3=new JRadioButton("Update Stock");
	        rb3.setBounds(30, 280, 250, 25);
	        rb3.setBackground(Color.yellow);
	       
	        rb3.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb3);
	        rb4=new JRadioButton("Insert Sales");
	        rb4.setBounds(30, 320, 250, 20);
	        rb4.setBackground(Color.yellow);
	       
	        rb4.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb4);
	        rb5=new JRadioButton("View Sales Report");
	        rb5.setBounds(30, 360, 250, 25);
	        rb5.setBackground(Color.yellow);
	       
	        rb5.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb5);
	        rb6=new JRadioButton("View Stock");
	        rb6.setBounds(30, 400, 250, 20);
	        rb6.setBackground(Color.yellow);
	       
	        rb6.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb6);
	        rb7=new JRadioButton("Exit");
	        rb7.setBounds(30, 440, 250, 20);
	        rb7.setBackground(Color.yellow);
	       
	        rb7.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
	        f.add(rb7);
	        b1.setBounds(270, 490, 200, 50);
	        b1.setFont(new Font(Font.SERIF, Font.BOLD, 30));
	        b1.setBackground(Color.black);
	        b1.setForeground(Color.white);
	        b1.addActionListener(this);
	        f.add(b1);
	    bg=new ButtonGroup();    
	        bg.add(rb1);bg.add(rb2);
	        bg.add(rb3);bg.add(rb4);bg.add(rb5);bg.add(rb6);bg.add(rb7);
	        f.add(label);

	        f.add(panel);
	      
	        f.setSize(900,900);  
	        f.setVisible(true); 
	}
	
public static void main(String[]args) throws SQLException {
	new SalesApplication();
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(rb1.isSelected() && e.getSource()==b1) {
			new StockDesign();
		}
			
		else if(rb2.isSelected() && e.getSource()==b1) {
			new DeleteDesign();
		}
			
		
		else if(rb3.isSelected() && e.getSource()==b1) {
			new UpdateDesign();
		}
		else if(rb4.isSelected() && e.getSource()==b1) {
			new SalesDesign();
		}
		else if(rb5.isSelected() && e.getSource()==b1) {
			try {
				new SalesReportDesign();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
		else if(rb6.isSelected() && e.getSource()==b1) {
			new getStokesDesign();
		}
		else if(rb7.isSelected()) {
			 int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
			 if(a==JOptionPane.YES_OPTION){  
			   
			     System.exit(0);
			 }
			}
		else if(e.getSource()==b1) {
			JOptionPane.showMessageDialog(f,"Please select operation first.","Alert",JOptionPane.WARNING_MESSAGE); 
		}
	}
}
	

