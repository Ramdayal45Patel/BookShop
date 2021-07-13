package com.ramdayal.userInterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.BevelBorder;

import com.ramdayal.dao.Dao;
import com.ramdayal.dao.UserData;
import com.ramdayal.model.User;

import java.awt.Color;

public class Profile extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Profile(String email, String password) {
		User user = UserData.getUserData().getAllData(email, password);

		setClosable(true);
		setBounds(100, 100, 874, 485);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("User Profile", JLabel.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(234, 11, 298, 41);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(48, 102, 159, 23);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(254, 102, 159, 23);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(48, 207, 159, 23);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Mobile_no");
		lblNewLabel_1_3.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(254, 207, 159, 23);
		getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("DOB");
		lblNewLabel_1_4.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(449, 207, 159, 23);
		getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Address");
		lblNewLabel_1_5.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(48, 298, 159, 23);
		getContentPane().add(lblNewLabel_1_5);

		textField = new JTextField(user.getfName());
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(48, 122, 159, 33);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(user.getlName());
		textField_1.setEditable(false);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(254, 122, 159, 33);
		getContentPane().add(textField_1);

		textField_2 = new JTextField(user.getEmail());
		textField_2.setEditable(false);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setColumns(10);
		textField_2.setBounds(48, 227, 159, 33);
		getContentPane().add(textField_2);

		textField_3 = new JTextField(user.getMobile());
		textField_3.setEditable(false);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setColumns(10);
		textField_3.setBounds(254, 227, 159, 33);
		getContentPane().add(textField_3);

		textField_4 = new JTextField(user.getDob());
		textField_4.setEditable(false);
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_4.setColumns(10);
		textField_4.setBounds(449, 227, 159, 33);
		getContentPane().add(textField_4);

		JTextArea textArea = new JTextArea(user.getAddress());
		textArea.setEditable(false);
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setBounds(48, 317, 280, 58);
		getContentPane().add(textArea);

		JLabel lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setBounds(687, 31, 142, 168);
		lblNewLabel_2.setIcon(Util.resize(new ImageIcon(user.getImage()),142, 168));
		getContentPane().add(lblNewLabel_2);

		JLabel back = new JLabel("");
		back.setBounds(0, 0, 858, 455);
		back.setIcon(Util.resize(
				new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\back2.jpg"),
				858, 455));
		getContentPane().add(back);

	}
}
