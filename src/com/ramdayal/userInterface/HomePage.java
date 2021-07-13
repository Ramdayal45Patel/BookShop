package com.ramdayal.userInterface;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;

public class HomePage extends JFrame {

	private JPanel contentPane;
	int count = 1;
	
	
	
	
	
	
	

	/**
	 * 
	 * /** Create the frame.
	 */
	public HomePage(String email,String password){
		setTitle("Home");
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		setSize(d.width, d.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(153, 204, 204));
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(
				Util.resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\add.png"), 80, 50));
		lblNewLabel.setBounds(10, 0, 91, 66);
		desktopPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("AddBook", JLabel.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 64, 75, 21);
		desktopPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		lblNewLabel_2.setIcon(
				Util.resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\Users.png"), 80, 50));
		lblNewLabel_2.setBounds(10, 207, 91, 66);
		desktopPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Profile", SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 277, 91, 21);
		desktopPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3 = new JLabel("");

		lblNewLabel_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setIcon(Util
				.resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\booklist.png"), 80, 50));
		lblNewLabel_3.setBounds(10, 96, 91, 66);
		desktopPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1_2 = new JLabel("BookList", SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(3, 163, 98, 21);
		desktopPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("");

		lblNewLabel_2_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setIcon(
				Util.resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\logout2.png"), 85, 57));
		lblNewLabel_2_1.setBounds(10, 319, 91, 66);
		desktopPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("LogOut", SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 401, 91, 21);
		desktopPane.add(lblNewLabel_1_1_1);

		JLabel back = new JLabel("");
		back.setBounds(134, 0, 1196, 708);
		// back.setIcon(Util.resize(new
		// ImageIcon(HomePAge1.class.getResource("/ramdayalbookapp/Image2/i1.jpg")),
		// 1151, 710));

		new Timer().schedule(new TimerTask() {
			public void run() {
				back.setIcon(Util.resize(
						new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\i" + count + ".jpg"), 1151,
						710));
				if (count == 5) {
					count = 1;
				} else {
					count++;
				}

			}
		}, 500, 2000);

		desktopPane.add(back);

		// login
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				AddNewBook add = new AddNewBook();

				desktopPane.add(add);
				add.setLocation((desktopPane.getWidth() - add.getWidth()) / 2,
						(desktopPane.getHeight() - add.getHeight()) / 2);
				add.setVisible(true);
			}
		});

		// AddNew Book
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookList list;
				try {
					list = new BookList();
					desktopPane.add(list);
					list.setLocation((desktopPane.getWidth() - list.getWidth()) / 2,
							(desktopPane.getHeight() - list.getHeight()) / 2);
					list.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					Logger.getLogger("booklist").log(Level.INFO, e1.getMessage());
				}

			}
		});

		// close all windoes
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int a = JOptionPane.showConfirmDialog(back, "Are you sure?");
				// JOptionPane.setRootFrame(null);
				if (a == JOptionPane.YES_OPTION) {
					dispose();
					Login obj = new Login();
					obj.setTitle("Login");
					obj.setLocation((desktopPane.getWidth() - obj.getWidth()) / 2,
							(desktopPane.getHeight() - obj.getHeight()) / 2);
					obj.setVisible(true);
				}
			}
		});

		// Profile
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Profile pro = new Profile(email,password);
				desktopPane.add(pro);
				pro.setLocation((desktopPane.getWidth() - pro.getWidth()) / 2,
						(desktopPane.getHeight() - pro.getHeight()) / 2);
				pro.setVisible(true);

			}

		});

	}
}
