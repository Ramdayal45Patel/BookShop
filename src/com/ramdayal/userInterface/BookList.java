package com.ramdayal.userInterface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.ramdayal.BookService.BookService;
import com.ramdayal.dao.AddDataBase;
import com.ramdayal.dao.Dao;
import com.ramdayal.model.BookAdd;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookList extends JInternalFrame {
	private JTable table;
	private List<BookAdd> book;
	private JTextField updatetitle;
	private JTextField updateprice;
	private JTextField updateauthor;
	private JTextField txtSearchByName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public BookList() throws SQLException {
		getContentPane().setBackground(new Color(51, 204, 153));
		setClosable(true);
		setTitle("BookList");
		setBounds(30, 10, 830, 463);
		getContentPane().setLayout(null);

		String[] cols = { "NAME", "AUTHOR", "Category", "PRICE" };
		DefaultTableModel dt = new DefaultTableModel(cols, 0);
		table = new JTable(dt);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(Color.LIGHT_GRAY);
		scroll.setBounds(21, 67, 770, 341);
		getContentPane().add(scroll);

		/*
		 * JComboBox comboBox = new JComboBox(); comboBox.setBorder((Border) new
		 * BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 * comboBox.setBounds(610, 7, 162, 29); getContentPane().add(comboBox);
		 * comboBox.setModel(new DefaultComboBoxModel( new String[] { "Sorting Here",
		 * "Sort By Name", "Sort By Date", "Sort By Price" }));
		 */
		JLabel lblTitle = new JLabel("Book");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 12));
		lblTitle.setBounds(26, 67, 103, 14);
		getContentPane().add(lblTitle);

		updatetitle = new JTextField();
		updatetitle.setColumns(10);
		updatetitle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updatetitle.setBounds(0, 0, 0, 0);
		getContentPane().add(updatetitle);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Serif", Font.BOLD, 12));
		lblPrice.setBounds(0, 0, 0, 0);
		getContentPane().add(lblPrice);

		updateprice = new JTextField();
		updateprice.setColumns(10);
		updateprice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updateprice.setBounds(0, 0, 0, 0);
		getContentPane().add(updateprice);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Serif", Font.BOLD, 12));
		lblAuthor.setBounds(26, 179, 103, 14);
		getContentPane().add(lblAuthor);

		updateauthor = new JTextField();
		updateauthor.setColumns(10);
		updateauthor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updateauthor.setBounds(0, 0, 0, 0);
		getContentPane().add(updateauthor);

		JButton btnUpdateHere = new JButton("Update Here");
		btnUpdateHere.setForeground(Color.WHITE);
		btnUpdateHere.setFont(new Font("Serif", Font.BOLD, 12));
		btnUpdateHere.setBackground(new Color(0, 102, 153));
		btnUpdateHere.setBounds(41, 252, 137, 30);
		getContentPane().add(btnUpdateHere);

		txtSearchByName = new JTextField();
		txtSearchByName.setBounds(642, 11, 162, 29);
		getContentPane().add(txtSearchByName);
		txtSearchByName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Search", JLabel.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(527, 11, 110, 25);
		getContentPane().add(lblNewLabel);

		book = AddDataBase.getAddDataBase().getAllBooks();
		Iterator<BookAdd> it = book.iterator();
		DefaultTableModel dt1 = (DefaultTableModel) table.getModel();

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		while (it.hasNext()) {
			BookAdd book = it.next();
			dt1.addRow(new Object[] { book.getBook(), book.getAuthor(), book.getCategory(), book.getPrice() });
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JPopupMenu pm = new JPopupMenu();
				JMenuItem m1 = new JMenuItem("Update Book");
				JMenuItem m2 = new JMenuItem("Delete Book");
				JMenuItem m3 = new JMenuItem("Purchase Book");
				pm.add(m1);
				pm.add(m2);
				pm.add(m3);

				pm.show(table, e.getX(), e.getY());

				m1.addActionListener((x) -> updateBook(table.getSelectedRow()));

				m2.addActionListener((x) -> deleteBook(table.getSelectedRow()));
				m3.addActionListener((x) -> new BookInverntory().setVisible(true));

			}
		});

		// search by name

		txtSearchByName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search;

				search = txtSearchByName.getText().toLowerCase();

				DefaultTableModel table2 = (DefaultTableModel) table.getModel();

				TableRowSorter<DefaultTableModel> tmodel = new TableRowSorter<DefaultTableModel>(table2);
				table.setRowSorter(tmodel);
				tmodel.setRowFilter(RowFilter.regexFilter(search));

				/*
				 * search = txtSearchByName.getText().toUpperCase(); DefaultTableModel table3 =
				 * (DefaultTableModel) table.getModel();
				 * 
				 * TableRowSorter<DefaultTableModel> tmodel1 = new
				 * TableRowSorter<DefaultTableModel>(table3); table.setRowSorter(tmodel1);
				 * tmodel1.setRowFilter(RowFilter.regexFilter(search));
				 */
			}
		});

	}

	private void updateBook(int selectedrow) {
		DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
		String book = (String) dt1.getValueAt(selectedrow, 0);
		updatetitle.setText(dt1.getValueAt(selectedrow, 1).toString());
		updateprice.setText(dt1.getValueAt(selectedrow, 2).toString());
		updateauthor.setText(dt1.getValueAt(selectedrow, 3).toString());
	}

	private void deleteBook(int selectedrow) {
		DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
		String book = (String) dt1.getValueAt(selectedrow, 0);
		BookService.getBookService().deleteBookbyName(book);
		dt1.removeRow(selectedrow);
	}
}
