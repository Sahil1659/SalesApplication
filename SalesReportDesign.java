package CONN.Wipro.Flight.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import CONN.Wipro.Flight.Bean.SalesReport;
import CONN.Wipro.Flight.Service.Administator;

public class SalesReportDesign extends JFrame{

	
	
	JFrame f7=new JFrame("Get Sales Report");
	JLabel label=new JLabel();
     JPanel panel=new JPanel(); 
     StringBuilder sb=new StringBuilder();
     String d="SALES_ID"+"\t\t"+"SALES_DATE"+"\t"+"PRODUCT_ID"+"\t"+"PRODUCT_NAME"+"\t"+"QUANTITY_SOLD"+"\t\t"+"PRODUCT_UNIT_PRICE"+"\t\t"+"SALES_PRICE_PER_UNIT"+"\t\t"+"PROFIT_AMOUNT"+"\n";
     
     JTextArea stock=new JTextArea();
     public SalesReportDesign() throws SQLException {
    	  panel.setBounds(0,0,900,900);
          panel.setBackground(Color.yellow); 
          label.setBounds(10, 20, 2000, 200);
          label.setText("Your Sales Report:-");
          label.setFont(new Font(Font.SERIF, Font.BOLD, 44));
          label.setForeground(Color.red);
          stock.setBounds(10, 200, 1800, 500);
          stock.setBackground(Color.black);
          stock.setForeground(Color.white);
          stock.setFont(new Font(Font.SERIF, Font.BOLD, 15));
          JScrollPane scrollableTextArea = new JScrollPane(stock);  
          
          scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
          f7.add(scrollableTextArea);
          f7.add(label);
          f7.add(stock);
          f7.add(panel);
          f7.setSize(1900,800);
          f7.setVisible(true);
          sb.append(d);
          
          ArrayList<SalesReport> sr=new ArrayList<SalesReport>(Administator.getSalesReport());
			for(SalesReport q:sr) {
				d=q.getSalesID()+"\t\t"+q.getSalesDate()+"\t\t"+q.getProductID()+"\t\t"+q.getProductNmae()+"\t\t"+q.getQuantitySold()+"\t\t\t"+q.getProductUnitPrice()+"\t\t\t"+q.getSalesPricePerUnit()+"\t\t\t"+q.getProfitAmount()+"\n";
			sb.append(d);
			}
			stock.setText(sb.toString());
		} 
     }
	
		// TODO Auto-generated method stub
     
		
		 
     

	

