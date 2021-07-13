package com.ramdayal.userInterface;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;
import com.ramdayal.dao.Dao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXml4SwfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookInverntory extends JFrame {

	private JPanel contentPane;
	private JTextField iname;
	private JTextField iprice;
	private JTextField itotal;
	private JTextField ipay;
	private JTextField ibalance;
	private JTable table;
	private JTextField iID;
	JSpinner iqty;
	private String authorname;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BookInverntory() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(33, 0, 744, 97);
		panel.setBackground(new Color(51, 204, 255));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("BookShop Inventory System", JLabel.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(174, 11, 451, 54);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 103, 744, 258);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("BookName :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(21, 75, 118, 31);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Price :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(21, 131, 100, 31);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Qty :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(24, 192, 86, 31);
		panel_1.add(lblNewLabel_1_2);

		iname = new JTextField();

		iname.setFont(new Font("Tahoma", Font.BOLD, 16));
		iname.setBounds(153, 76, 149, 31);
		panel_1.add(iname);
		iname.setColumns(10);

		iprice = new JTextField();
		iprice.setFont(new Font("Tahoma", Font.BOLD, 16));
		iprice.setColumns(10);
		iprice.setBounds(153, 132, 149, 31);
		panel_1.add(iprice);

		JSpinner iqty = new JSpinner();
		iqty.setBounds(165, 195, 86, 31);
		panel_1.add(iqty);

		itotal = new JTextField();
		itotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		itotal.setColumns(10);
		itotal.setBounds(577, 25, 149, 31);
		panel_1.add(itotal);

		JLabel lblNewLabel_1_3 = new JLabel("Total Cost :");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(456, 24, 111, 31);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Pay :");
		lblNewLabel_1_3_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(456, 96, 100, 31);
		panel_1.add(lblNewLabel_1_3_1);

		ipay = new JTextField();
		ipay.setFont(new Font("Tahoma", Font.BOLD, 16));
		ipay.setColumns(10);
		ipay.setBounds(577, 97, 149, 31);
		panel_1.add(ipay);

		JLabel lblNewLabel_1_3_2 = new JLabel("Balance :");
		lblNewLabel_1_3_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1_3_2.setBounds(456, 164, 100, 31);
		panel_1.add(lblNewLabel_1_3_2);

		ibalance = new JTextField();
		ibalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		ibalance.setColumns(10);
		ibalance.setBounds(577, 165, 149, 31);
		panel_1.add(ibalance);

		JButton iaddbtn = new JButton("ADD");
		iaddbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		iaddbtn.setBounds(310, 195, 89, 31);
		panel_1.add(iaddbtn);

		JLabel lblNewLabel_1_4 = new JLabel("Book ID :");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(21, 24, 118, 31);
		panel_1.add(lblNewLabel_1_4);

		iID = new JTextField();

		iID.setFont(new Font("Tahoma", Font.BOLD, 16));
		iID.setColumns(10);
		iID.setBounds(153, 25, 149, 31);
		panel_1.add(iID);

		String[] cols = { "BookID", "BookName", "Price", "Qty", "Total" };
		DefaultTableModel dt = new DefaultTableModel(cols, 0);
		table = new JTable(dt);
		// table.setBackground(new Color(0, 153, 204));
		table.setBounds(33, 375, 584, 121);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane iscroll = new JScrollPane(table);
		iscroll.setBackground(Color.LIGHT_GRAY);
		iscroll.setBounds(33, 375, 584, 121);
		contentPane.add(iscroll);

		JButton iInvoicebtn = new JButton("Print Invoice");

		iInvoicebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		iInvoicebtn.setBounds(627, 414, 151, 31);
		contentPane.add(iInvoicebtn);

		// Key Press
		iID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (iID.equals("")) {
					Util.warningMessage(iID, "Please Enter Book ID");
					iID.requestFocus();

				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					try {
						String Icode = iID.getText();
						PreparedStatement ps = Dao.getConnection()
								.prepareStatement("select * from bookdata where id=?");
						ps.setString(1, Icode);
						ResultSet rs = ps.executeQuery();
						if (rs.next() == false) {
							// JOptionPane.showInputDialog(contentPane, "Book Code not Found");
							JOptionPane.showMessageDialog(panel, "Book Code not Found");
						} else {
							String name = rs.getString("BookName");
							authorname = rs.getString(3);
							System.out.println(authorname);
							iname.setText(name.trim());

							int price = rs.getInt("Price");
							String sprice = String.valueOf(price);

							iprice.setText(sprice);
							iqty.requestFocus();

						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						Logger.getLogger("Bookshop").log(Level.INFO, e1.getMessage());
					}

				}

			}
		});

		// Add Event Action
		iaddbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int tprice = Integer.parseInt(iprice.getText());
				int tqty = Integer.parseInt(iqty.getValue().toString());

				int total = tprice * tqty;

				DefaultTableModel dt = (DefaultTableModel) table.getModel();
				dt.addRow(new Object[]

				{ iID.getText(), iname.getText(), iprice.getText(), iqty.getValue().toString(), total

				});

				int sum = 0;
				for (int i = 0; i < table.getRowCount(); i++) {
					sum = sum + Integer.parseInt(table.getValueAt(i, 4).toString());
				}
				itotal.setText(String.valueOf(sum));
				// iID.setText("");
				iname.setText("");
				iprice.setText("");
				iqty.setValue(0);
				iID.requestFocus();

			}
		});

		// print Invoices

		iInvoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pay = ipay.getText();
				if (pay.isEmpty()) {
					Util.warningMessage(ipay, "Plaese Enter Your Pay Amount");
					ipay.requestFocus();

				} else {
					int pay1 = Integer.parseInt(pay);
					int totalcost = Integer.parseInt(itotal.getText());
					int bal = pay1 - totalcost;
					ibalance.setText(String.valueOf(bal));
					sales();
				}

			}
		});

	}

// Sale Method
	public void sales() {

		String total = itotal.getText();
		String pay = ipay.getText();
		String balance = ibalance.getText();
		int i = 0;
		try {
			PreparedStatement pts = Dao.getConnection().prepareStatement("insert into inventory values(default,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pts.setString(1, total);
			pts.setString(2, pay);
			pts.setString(3, balance);
			pts.executeUpdate();
			ResultSet rs = pts.getGeneratedKeys();
			if (rs.next()) {
				i = rs.getInt(1);
			}
			int row = table.getRowCount();
			PreparedStatement pts1 = Dao.getConnection()
					.prepareStatement("insert into sale_product values(default,?,?,?,?,?,?)");

			String name = "";
			String price;
			String quantity;
			String sale = iID.getText();
			System.out.println(sale);

			int stotal = 0;
			for (int j = 0; j < table.getRowCount(); j++) {

				name = (String) table.getValueAt(j, 1);
				price = (String) table.getValueAt(j, 2);
				quantity = (String) table.getValueAt(j, 3);
				stotal = (int) table.getValueAt(j, 4);

				pts1.setInt(1, Integer.parseInt(sale));
				pts1.setString(2, name);
				pts1.setString(3, price);
				pts1.setString(4, quantity);
				pts1.setString(5, String.valueOf(stotal));
				pts1.setString(6, authorname);

				pts1.executeUpdate();

			}

			JOptionPane.showMessageDialog(this, "Sale Completed");
			dispose();
			HashMap hmap = new HashMap();

			hmap.put("invoice", i);

			try {
				// Map<String, Object> params = new HashMap<String, Object>();
				JasperDesign js = JRXmlLoader.load(
						"C:\\Users\\bhola\\eclipse-workspace\\BookAPP\\src\\ramdayalbookapp\\file\\Blank_A4.jrxml");
				JasperReport jreport = JasperCompileManager.compileReport(js);
				JasperPrint jprint = JasperFillManager.fillReport(jreport, hmap, Dao.getConnection());
				JasperViewer.viewReport(jprint);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				Logger.getLogger("Report").log(Level.INFO, e.getMessage());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger("sale").log(Level.INFO, e.getMessage());
		}
	}

}
