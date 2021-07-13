package com.ramdayal.userInterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.ramdayal.dao.AddDataBase;
import com.ramdayal.model.BookAdd;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class AddNewBook extends JInternalFrame {
	private JTextField bookname;
	private JTextField bookprice;
	private JTextField authorname;
	private JTextField txtimage;
	private JPanel panel;
	private JComboBox txtcategory;
	private File file;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddNewBook() {
		getContentPane().setBackground(new Color(0, 102, 204));
		setClosable(true);
		setTitle("AddNewBook");
		setBounds(60, 10, 690, 422);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setFont(new Font("Serif", Font.BOLD, 12));
		panel.setBackground(new Color(0, 102, 204));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(256, 34, 408, 347);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book Name", JLabel.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(5, 38, 92, 17);
		panel.add(lblNewLabel);

		bookname = new JTextField();
		bookname.setBounds(20, 56, 148, 32);
		panel.add(bookname);
		bookname.setColumns(10);

		JLabel lblBookPrice = new JLabel("Book Price", SwingConstants.CENTER);
		lblBookPrice.setForeground(Color.WHITE);
		lblBookPrice.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookPrice.setBounds(201, 38, 80, 17);
		panel.add(lblBookPrice);

		bookprice = new JTextField();
		bookprice.setColumns(10);
		bookprice.setBounds(216, 56, 148, 32);
		panel.add(bookprice);

		JLabel lblAuthor = new JLabel("Author Name", SwingConstants.CENTER);
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Serif", Font.BOLD, 12));
		lblAuthor.setBounds(8, 95, 92, 15);
		panel.add(lblAuthor);

		authorname = new JTextField();
		authorname.setColumns(10);
		authorname.setBounds(20, 113, 148, 32);
		panel.add(authorname);

		JLabel lblDate = new JLabel("Date", SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Serif", Font.BOLD, 12));
		lblDate.setBounds(201, 94, 51, 16);
		panel.add(lblDate);

		JLabel lblBookCotegory = new JLabel("Book Category", SwingConstants.CENTER);
		lblBookCotegory.setForeground(Color.WHITE);
		lblBookCotegory.setFont(new Font("Serif", Font.BOLD, 12));
		lblBookCotegory.setBounds(12, 149, 94, 17);
		panel.add(lblBookCotegory);

		txtcategory = new JComboBox();
		txtcategory.setModel(new DefaultComboBoxModel(
				new String[] { "Select Category", "Educational book", "Novel", "Magazine", "Science Book" }));
		txtcategory.setEditable(false);
		txtcategory.setToolTipText("");
		txtcategory.setBounds(20, 167, 344, 32);
		panel.add(txtcategory);

		JLabel lblNewLabel_1 = new JLabel("Book Image", JLabel.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(5, 208, 92, 17);
		panel.add(lblNewLabel_1);

		JButton browserButton = new JButton("Browser...");
		browserButton.setBounds(274, 225, 90, 32);
		panel.add(browserButton);

		txtimage = new JTextField();
		txtimage.setBounds(20, 225, 208, 32);
		panel.add(txtimage);
		txtimage.setColumns(10);

		JButton addbook = new JButton("<html>Add Book</html>");
		addbook.setBackground(new Color(0, 153, 102));
		addbook.setFont(new Font("Serif", Font.BOLD, 14));
		addbook.setBounds(43, 301, 121, 32);
		panel.add(addbook);

		JButton resetButton_2 = new JButton("<html>Reset Book</html>");
		resetButton_2.setBackground(new Color(204, 51, 0));
		resetButton_2.setFont(new Font("Serif", Font.BOLD, 14));
		resetButton_2.setBounds(198, 301, 121, 32);
		panel.add(resetButton_2);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(216, 113, 148, 32);
		panel.add(dateChooser);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBounds(22, 34, 225, 347);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel(
				"<html>Select your favorite social network and share our icons with your contacts or friends, if you do not have these social networks copy the link and paste it in the one you use. For more information</html>",
				JLabel.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 174, 205, 162);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(10, 11, 205, 162);
		lblNewLabel_3.setIcon(new Util().resize(new ImageIcon("C:\\Users\\bhola\\MINI_Project\\Mini_project\\src\\com\\ramdayal\\image2\\images.jpg"), 205, 162));
		panel_1.add(lblNewLabel_3);

		// Image selector
		browserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser ch = new JFileChooser();
				int i = ch.showOpenDialog(null);
				if (i == JFileChooser.APPROVE_OPTION) {
					file = ch.getSelectedFile();
					lblNewLabel_3.setIcon(new Util().resize(new ImageIcon(file.getAbsolutePath()), 205, 162));
					txtimage.setText(file.getAbsolutePath());
				}
			}
		});

		// AddNewBook
		addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {

					com.ramdayal.model.BookAdd add = new BookAdd();
					add.setBook(bname);
					add.setPrice(Integer.parseInt(bprice));
					add.setAuthor(bauthor);
					add.setCategory(category);
					add.setDate(new Date().toLocaleString());
					add.setImages(imageloc);

					int callback = AddDataBase.getAddDataBase().insert(add);
					if (callback > 0) {
						Util.normalMessage(AddNewBook.this, "Successfully ADD");
					} else {
						Util.errorMessage(AddNewBook.this, "Faild");
					}

				}
			}
		});

		// Reset Details
		resetButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();

			}
		});

	}

	private String bname, bauthor, category, imageloc, bprice;

	private boolean valid() {
		bname = bookname.getText();
		// bprice = Integer.parseInt(bookprice.getText());
		bprice = bookprice.getText();
		bauthor = authorname.getText();
		category = txtcategory.getSelectedItem().toString();
		imageloc = txtimage.getText();

		if (bname.equals("")) {
			Util.warningMessage(AddNewBook.this, "Enter Book Name");
			bookname.requestFocus();
			return false;
		} else if (String.valueOf(bprice).isEmpty()) {
			Util.warningMessage(AddNewBook.this, "Enter Book Price");
			bookprice.requestFocus();
			return false;
		} else if (bauthor.isEmpty()) {
			Util.warningMessage(AddNewBook.this, "Enter Author Name");
			authorname.requestFocus();
			return false;
		} else if (category.equalsIgnoreCase("Select Category")) {
			Util.warningMessage(AddNewBook.this, "please select book category");
			txtcategory.requestFocus();
			return false;
		} else if (imageloc.isEmpty()) {
			Util.warningMessage(AddNewBook.this, "please select book image");
			txtimage.requestFocus();
			return false;
		}

		else {
			return true;
		}
	}

	public void reset() {
		bookname.setText("");
		bookprice.setText("");
		authorname.setText("");
		txtcategory.setModel(new DefaultComboBoxModel(
				new String[] { "Select Category", "Educational book", "Novel", "Magazine", "Science Book" }));
		txtimage.setText("");
		dateChooser.equals("");

	}
}
