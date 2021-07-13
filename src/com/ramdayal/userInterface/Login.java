package com.ramdayal.userInterface;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.ramdayal.dao.UserData;
import com.ramdayal.model.User;

import javax.swing.JLabel;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textuser;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 710, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(286, 74, 84, 79);
		lblNewLabel_2.setIcon(Util.resize(
				new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image\\userlogin.jpg"),
				84, 79));
		panel.add(lblNewLabel_2);

		JLabel user = new JLabel("Email id");
		user.setFont(new Font("Serif", Font.PLAIN, 16));
		user.setBounds(60, 182, 156, 14);
		panel.add(user);

		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Serif", Font.PLAIN, 16));
		pass.setBounds(60, 259, 156, 14);
		panel.add(pass);

		textuser = new JTextField();
		textuser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textuser.setBounds(60, 197, 201, 36);
		panel.add(textuser);
		textuser.setColumns(10);

		txtpass = new JPasswordField();
		txtpass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtpass.setBounds(60, 274, 201, 36);
		panel.add(txtpass);

		JButton txtlogin = new JButton("Login");
		txtlogin.setForeground(new Color(204, 204, 255));
		txtlogin.setBackground(new Color(0, 51, 51));

		txtlogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtlogin.setFont(new Font("Serif", Font.BOLD, 25));
		txtlogin.setBounds(252, 367, 201, 37);
		panel.add(txtlogin);

		JLabel regis = new JLabel("New Registration", JLabel.CENTER);
		regis.setForeground(new Color(255, 255, 255));
		regis.setFont(new Font("Tahoma", Font.BOLD, 15));
		regis.setBounds(426, 197, 201, 32);
		panel.add(regis);

		JLabel bygoogle = new JLabel("Login with Google", JLabel.CENTER);
		bygoogle.setForeground(new Color(255, 255, 255));
		bygoogle.setFont(new Font("Tahoma", Font.BOLD, 15));
		bygoogle.setBounds(441, 274, 186, 32);
		panel.add(bygoogle);

		JLabel gimg = new JLabel("");
		gimg.setBounds(430, 274, 33, 36);
		gimg.setIcon(Util.resize(
				new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image\\download.png"),
				33, 36));
		panel.add(gimg);

		JLabel lblNewLabel = new JLabel("<html>Welcome<br/> To  BookShop</html>", JLabel.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(252, 11, 172, 52);
		panel.add(lblNewLabel);

		JLabel jj = new JLabel();
		jj.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jj.setLocation(7, 5);
		jj.setSize(680, 425);
		jj.setIcon(Util.resize(
				new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\ack.jpg"), 710,
				461));
		panel.add(jj);

		// Mouse Event
		regis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration rr = new Registration();
				rr.setResizable(false);
				rr.setLocationRelativeTo(null);
				rr.setVisible(true);
				dispose();
			}
		});
		//
		txtlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					User user = UserData.getUserData().login(email, password);
					 //UserData.getUserData().getAllData(email, password);

					if (user != null) {
						new HomePage(email, password).setVisible(true);
						dispose();
					} else {
						Util.errorMessage(Login.this, "Invalid Email & Password");
					}

				}

			}
		});
	}

	private String email, password;

	private boolean valid() {
		email = textuser.getText();
		password = String.valueOf(txtpass.getPassword());

		if (email.isEmpty()) {
			Util.normalMessage(this, "Enter Email");
			textuser.requestFocus();
			return false;
		} else if (!Util.emailValidation(email)) {
			Util.warningMessage(this, " Enter valid email");
			textuser.requestFocus();
			return false;
		} else if (password.isEmpty()) {
			Util.normalMessage(this, "Enter password");
			txtpass.requestFocus();
			return false;
		} else if (!Util.isPasswordValid(password)) {
			Util.warningMessage(this, "Password is invalid");
			Util.normalMessage(this, "Please Enter valid Password");
			txtpass.requestFocus();
			return false;
		} else {

			return true;
		}

	}

}
