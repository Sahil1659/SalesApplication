package CONN.Wipro.Flight.Design;
import javax.swing.*;

import CONN.Wipro.Flight.Bean.Product;
import CONN.Wipro.Flight.DAO.StockDao;
import CONN.Wipro.Flight.Util.DBUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getStokesDesign extends JFrame implements ActionListener{
	
	JFrame f6=new JFrame("Get Stock");
	JLabel label=new JLabel();
     JPanel panel=new JPanel(); 
     JButton b6=new JButton("Get Stocks");
     JTextField tf11;
     JTextArea stock;
	public getStokesDesign() {
	
   
    panel.setBounds(0,0,900,900);
    panel.setBackground(Color.yellow); 
    label.setBounds(10, 20, 2000, 200);
    label.setText("Please Enter all the fields:-");
    label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
    label.setForeground(Color.red);
    JLabel l1=new JLabel("Enter Product Id:-");
    l1.setBounds(50, 180, 500, 50);
    l1.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
    f6.add(l1);
    tf11=new JTextField();
    tf11.setBounds(300, 180, 300, 40);
    tf11.setFont(new Font(Font.SERIF, Font.BOLD, 24));
    f6.add(tf11);
    
   stock=new JTextArea();
   stock.setEditable(false);
   stock.setBounds(30, 330, 800, 500);
   stock.setBackground(Color.black);
   stock.setForeground(Color.white);
   stock.setFont(new Font(Font.SERIF, Font.BOLD, 30));
   stock.setVisible(false);
   f6.add(stock);
    b6.setBounds(270, 250, 200, 50);
    b6.setFont(new Font(Font.SERIF, Font.BOLD, 30));
    b6.setBackground(Color.black);
    b6.setForeground(Color.white);
    b6.addActionListener(this);
    f6.add(b6);
	f6.setSize(900,900);
	f6.add(label);
	
	f6.add(panel);
	f6.setVisible(true);
   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b6) {
			String stockd=tf11.getText();
			if(stockd.isEmpty()) {
				JOptionPane.showMessageDialog(f6,"TextField can't be empty .","Alert",JOptionPane.WARNING_MESSAGE);
				return;
			}
			Product pp=new Product();
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps;
		    
		     try {
				ps = con.prepareStatement("select * from TBL_STOCK where product_id = ?");
				ps.setString(1, stockd);
			    ResultSet rs = ps.executeQuery();

			    if (rs.next()) {
			    	try {
						pp= StockDao.getStock(stockd);
						stock.setVisible(true);
			stock.setText("PRODUCT_ID:- \t"+pp.getProductID()+"\nPRODUCT_NAME:- \t"+pp.getProductName()+"\nQUANTITY_ON_HAND:- \t"+pp.getQuantityOnHand()+"\nPRODUCT_UNIT_PRICE:- \t"+pp.getProductUnitPrice()+"\nREORDER_LEVEL:- \t"+pp.getReorderLevel());
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(f6,"Stock doesn't exist .","Alert",JOptionPane.WARNING_MESSAGE);
			    }
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				//e2.printStackTrace();
			}
		    
			
		    }
		    
			
		}
	}
