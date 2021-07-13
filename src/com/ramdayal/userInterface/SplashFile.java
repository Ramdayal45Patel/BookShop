package com.ramdayal.userInterface;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

public class SplashFile extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SplashFile frame = new SplashFile();
			frame.setUndecorated(true);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			for (int i = 0; i <= 100; i++) {
				frame.progressBar.setValue(i);
				Thread.sleep(50);
			}
			if (frame.progressBar.getValue() ==100) {
				frame.dispose();
				Login l = new Login();
				l.setResizable(false);
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public SplashFile() throws IOException {

		LookAndFeelInfo lf[] = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < lf.length; i++) {
			System.out.println(lf[i].getClassName());
		}
		try {
			UIManager.setLookAndFeel(lf[1].getClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(20, 50, 590, 330);

		label.setBackground(new Color(0.0f, 0.5f, 0.0f, 0.1f));
		// label.setIcon(Util.resize(new
		// ImageIcon(SplashFile.class.getResource("/ramdayalbookapp/image/book.gif")),590,330));
		// label.setIcon(Util.resize(new
		// ImageIcon(SplashFile.class.getResource("/ramdayalbookapp/image/book_logo.png")),635,
		// 461));
		// contentPane.add(label);

		progressBar = new JProgressBar();
		progressBar.setBounds(0, 440, 635, 24);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		contentPane.add(progressBar);
		JLabel jj = new JLabel();
		jj.setSize(635, 461);
		jj.setIcon(Util.resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image\\book1.jpg"), 635, 461));
		contentPane.add(jj);
	}
}