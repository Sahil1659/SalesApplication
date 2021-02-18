package CONN.Wipro.Flight.Design;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

import CONN.Wipro.Flight.Bean.Sales;
import CONN.Wipro.Flight.Service.Administator;
import CONN.Wipro.Flight.Util.DBUtil;
public class SalesDesign extends JFrame implements ActionListener{
JFrame f5;
JLabel label,l1,l2,l3;
JTextField tf8,tf9,tf10;
JPanel panel;
JButton b5;
	public SalesDesign() {
		f5=new JFrame("Insert Sale");
		label=new JLabel();
         panel=new JPanel(); 
          b5=new JButton("Insert Now");
       
        panel.setBounds(0,0,900,900);
        panel.setBackground(Color.yellow); 
        label.setBounds(10, 20, 2000, 200);
        label.setText("Please Enter all the fields:-");
        label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
        label.setForeground(Color.red);
        l1=new JLabel("Enter Product ID:-");
        l1.setBounds(50, 180, 500, 50);
        l1.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
        f5.add(l1);
        tf8=new JTextField();
        tf8.setBounds(300, 180, 300, 40);
        tf8.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        f5.add(tf8);
        
        l2=new JLabel("Enter Quantity Sold:-");
        l2.setBounds(50, 250, 500, 50);
        l2.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
        f5.add(l2);
        tf9=new JTextField();
        tf9.setBounds(300, 250, 300, 40);
        tf9.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        f5.add(tf9);
        
        l3=new JLabel("Enter Sale Price:-");
        l3.setBounds(50, 320, 500, 50);
        l3.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
        f5.add(l3);
        tf10=new JTextField();
        tf10.setBounds(300, 320, 300, 40);
        tf10.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        f5.add(tf10);
        
        
        b5.setBounds(270, 400, 200, 50);
        b5.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        f5.add(b5);
		f5.setSize(700,700);
		f5.add(label);
		
		f5.add(panel);
		f5.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String pid=tf8.getText();
		String qty=tf9.getText();
		String price=tf10.getText();
		if(pid.isEmpty()||qty.isEmpty()||price.isEmpty()) {
			JOptionPane.showMessageDialog(f5,"TextField can't be empty .","Alert",JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
		     Integer.parseInt(qty);
		   
		     	Float.parseFloat(price);
		}
		catch (NumberFormatException f) {
		     JOptionPane.showMessageDialog(f5,"Quantity & Price must be Number.","Alert",JOptionPane.WARNING_MESSAGE); 
		     return;
		}
		
		finally {
			
			Sales s=new Sales();
			
			s.setQuantitySold(Integer.parseInt(qty));
			s.setSalesPricePerUnit(Float.parseFloat(price));
			java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
			//s.setSalesId(SalesDao.generateSalesID(date));
			s.setSalesDate((Date) date);
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from TBL_STOCK where product_id = ?");
				  ps.setString(1, pid);
				    ResultSet rs = ps.executeQuery();
		
				    if (rs.next()) {
				     // s.setProductId(rs.getString(1));
					//s.setProductId(Product.getProductID());
				    	ps = con.prepareStatement("select * from TBL_SALES where product_id = ?");		    	
				    	ps.setString(1, pid);
					    ResultSet rs1 = ps.executeQuery();
					    if(rs1.next())
					    {
					    	JOptionPane.showMessageDialog(f5,"Product already exist.","Alert",JOptionPane.WARNING_MESSAGE);
					    	 return;
					    }
					    else
				    	s.setProductId(pid);
				    	 
				    }
				    else {
				    	JOptionPane.showMessageDialog(f5,"Unknown product for sale.","Alert",JOptionPane.WARNING_MESSAGE);
				    	 return;
				    }
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			finally {
				try {
					int result=Administator.insertSales(s);
					if(result==1)
					{
						 JOptionPane.showMessageDialog(f5,"Inserted Successfully.","Alert",JOptionPane.WARNING_MESSAGE);		
				tf8.setText("");tf9.setText("");tf10.setText("");
						 return;	
					}
					else if(result==2) {
						 JOptionPane.showMessageDialog(f5,"Product name not valid.","Alert",JOptionPane.WARNING_MESSAGE);
						 return;
					}
					else if(result==3) {
						 JOptionPane.showMessageDialog(f5,"Not enough stock for sale.","Alert",JOptionPane.WARNING_MESSAGE);
						 return;
					}
					else if(result==4) {
						 JOptionPane.showMessageDialog(f5,"Date not valid.","Alert",JOptionPane.WARNING_MESSAGE);
						 return;
					}
					else
					{
						 JOptionPane.showMessageDialog(f5,"Problem in insertion.","Alert",JOptionPane.WARNING_MESSAGE);
						 return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		  
		}
			
	}

	
	}


