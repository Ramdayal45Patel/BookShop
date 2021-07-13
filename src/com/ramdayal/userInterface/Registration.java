package com.ramdayal.userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import com.ramdayal.dao.UserData;
import com.ramdayal.model.User;
import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txtfirst;
	private JTextField txtlast;
	private JTextField txtuser;
	private JTextField txtemail;
	private JPasswordField txtpass;
	private File file;
	private JFileChooser ch;
	private JTextField txtaddress;
	private JTextField txtmobile;
	private JRadioButton male;
	private JRadioButton female;
	ButtonGroup group = new ButtonGroup();
	String selected;

	/**
	 * Launch the application.
	 */

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	public Registration() {
		setTitle("New Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel hlabel = new JLabel("");
		hlabel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hlabel.setIcon(Util.resize(
				new ImageIcon(
						"C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image\\registartion.png"),
				203, 74));
		hlabel.setBounds(286, 0, 203, 74);
		contentPane.add(hlabel);

		JLabel lname = new JLabel("Name");
		lname.setFont(new Font("Serif", Font.BOLD, 16));
		lname.setBounds(46, 113, 136, 14);
		contentPane.add(lname);

		txtfirst = new JTextField();
		txtfirst.setBounds(46, 129, 203, 30);
		contentPane.add(txtfirst);
		txtfirst.setColumns(10);

		txtlast = new JTextField();
		txtlast.setBounds(287, 129, 202, 30);
		contentPane.add(txtlast);
		txtlast.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("First");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 11));
		lblNewLabel_1.setBounds(46, 158, 75, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Last");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 11));
		lblNewLabel_2.setBounds(287, 158, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel luser = new JLabel("Username");
		luser.setFont(new Font("Serif", Font.BOLD, 16));
		luser.setBounds(46, 194, 161, 14);
		contentPane.add(luser);

		txtuser = new JTextField();
		txtuser.setBounds(46, 210, 203, 30);
		contentPane.add(txtuser);
		txtuser.setColumns(10);

		JLabel lmobile = new JLabel("Mobile_no");
		lmobile.setFont(new Font("Serif", Font.BOLD, 16));
		lmobile.setBounds(287, 184, 202, 30);
		contentPane.add(lmobile);

		txtmobile = new JTextField();
		txtmobile.setBounds(287, 210, 202, 30);
		contentPane.add(txtmobile);
		txtuser.setColumns(10);

		JLabel lemail = new JLabel("E-mail");
		lemail.setFont(new Font("Serif", Font.BOLD, 16));
		lemail.setBounds(46, 252, 111, 14);
		contentPane.add(lemail);

		txtemail = new JTextField();
		txtemail.setBounds(46, 267, 203, 30);
		contentPane.add(txtemail);
		txtemail.setColumns(10);

		JLabel lpass = new JLabel("Password");
		lpass.setFont(new Font("Serif", Font.BOLD, 16));
		lpass.setBounds(46, 318, 111, 14);
		contentPane.add(lpass);

		txtpass = new JPasswordField();
		txtpass.setBounds(46, 333, 203, 30);
		contentPane.add(txtpass);

		JLabel laddress = new JLabel("Address");
		laddress.setFont(new Font("Serif", Font.BOLD, 16));
		laddress.setBounds(46, 371, 129, 14);
		contentPane.add(laddress);

		JLabel lphoto = new JLabel("");
		lphoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lphoto.setBounds(617, 94, 143, 165);
		lphoto.setIcon(new Util().resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\images.jpg"), 143, 165));
		contentPane.add(lphoto);

		JLabel lblNewLabel = new JLabel("DOB");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 16));
		lblNewLabel.setBounds(287, 253, 111, 11);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 16));
		lblNewLabel_3.setBounds(287, 320, 134, 11);
		contentPane.add(lblNewLabel_3);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(287, 267, 202, 30);
		dateChooser.setDateFormatString("13 Oct 2016");
		contentPane.add(dateChooser);

		male = new JRadioButton("Male");
		male.setBounds(289, 337, 52, 23);
		contentPane.add(male);

		female = new JRadioButton("Female");
		female.setBounds(343, 337, 78, 23);
		contentPane.add(female);

		group.add(male);
		group.add(female);

		JButton browser = new JButton("Browser..");
		browser.setFont(new Font("Serif", Font.BOLD, 16));
		browser.setFont(new Font("Tahoma", Font.BOLD, 16));
		browser.setBounds(631, 299, 111, 33);
		contentPane.add(browser);

		JButton sbmit = new JButton("Submit");
		sbmit.setBackground(new Color(51, 204, 204));
		sbmit.setFont(new Font("Arial", Font.BOLD, 18));
		sbmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		sbmit.setBounds(329, 411, 165, 39);
		contentPane.add(sbmit);

		txtaddress = new JTextField();
		txtaddress.setBounds(46, 387, 203, 30);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);

		JLabel jj = new JLabel();
		jj.setSize(803, 517);
		jj.setIcon(Util.resize(
				new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\ack.jpg"), 803,
				517));
		contentPane.add(jj);

		// Image
		browser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch = new JFileChooser();
				int i = ch.showOpenDialog(null);
				if (i == JFileChooser.APPROVE_OPTION) {
					file = ch.getSelectedFile();
					lphoto.setIcon(new Util().resize(new ImageIcon(file.getAbsolutePath()), 157, 166));
				}
			}
		});

		// Submit
		sbmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					// Detail into database
					User user = new User();
					user.setEmail(email);
					user.setPass(pass);
					user.setfName(fname);
					user.setlName(lastname);
					user.setGender(selected);
					user.setDob(dateChooser.getDate().toString().formatted("13 Oct 2016"));
					user.setMobile(mobile);
					user.setAddress(address);
					user.setImage(file.getAbsolutePath());
					// user.setDob(dateChooser.getDate().toString());
					int callback = UserData.getUserData().insert(user);
					if (callback > 0) {
						Util.normalMessage(Registration.this, "Successfully Register");
					} else {
						Util.errorMessage(Registration.this,"Registartion Failed");
					}

					Login home = new Login();
					home.setVisible(true);
					dispose();

				}

			}
		});

	}

	private String fname, lastname, username, email, pass, address, mobile;

	private boolean valid() {
		fname = txtfirst.getText();
		lastname = txtlast.getText();
		username = txtuser.getText();
		email = txtemail.getText();
		pass = String.valueOf(txtpass.getPassword());
		address = txtaddress.getText();
		mobile = txtmobile.getText();

		if (fname.isEmpty()) {
			Util.normalMessage(this, "Enter First Name");
			txtfirst.requestFocus();
			return false;
		} else if (lastname.isEmpty()) {
			Util.normalMessage(this, "Enter Last Name");
			txtlast.requestFocus();
			return false;
		} else if (username.isEmpty()) {
			Util.normalMessage(this, "Enter UserName");
			txtuser.requestFocus();
			return false;
		} else if (mobile.isEmpty()) {
			Util.warningMessage(this, "Enter Mobile Number");
			txtmobile.requestFocus();
			return false;
		} else if (!Util.mobileNumber(mobile)) {
			Util.warningMessage(this, "Mobile_no is not Valid");
			txtmobile.requestFocus();
			return false;
		} else if (email.isEmpty()) {
			Util.normalMessage(this, "Enter Your Email");
			txtemail.requestFocus();
			return false;
		} else if (!Util.emailValidation(email)) {
			Util.warningMessage(this, "Enter Valid Emali");
			txtemail.requestFocus();
			return false;
		} else if (pass.isEmpty()) {
			Util.normalMessage(this, "Enter Password");
			txtpass.requestFocus();
			return false;
		} else if (!Util.isPasswordValid(pass)) {
			Util.warningMessage(this, "Enter Valid Password");
			txtlast.requestFocus();
			return false;
		} else if (address.isEmpty()) {
			Util.normalMessage(this, "Enter Address");
			txtaddress.requestFocus();
			return false;
		} else if ((male.isSelected() == false) && (female.isSelected() == false)) {
			Util.normalMessage(rootPane, "select Gender");
			return false;
		} else if (file == null) {
			Util.warningMessage(rootPane, "Insert Your Photo");
			return false;
		} else {
			return true;
		}

	}

}
