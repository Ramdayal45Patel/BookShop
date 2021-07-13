package com.ramdayal.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.ramdayal.model.User;

public class UserData {
	public static String email;
	public static String pass;

	private static UserData userdata = new UserData();

	public UserData() {
	}

	public static UserData getUserData() {
		return userdata;
	}

	public int insert(User user) {
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement psmt = con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?)");
			psmt.setString(1, user.getEmail());
			psmt.setString(2, user.getPass());
			psmt.setString(3, user.getfName());
			psmt.setString(4, user.getlName());
			psmt.setString(5, user.getGender());
			psmt.setString(6, user.getDob());
			psmt.setString(7, user.getMobile());
			psmt.setString(8, user.getAddress());
			psmt.setString(9, user.getImage());
			i = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public User login(String email, String pass) {
		User user = null;
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement stm = con.prepareStatement("Select *from userdetails where email=? and Password=?");
			stm.setString(1, email);
			stm.setString(2, pass);

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setEmail(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setMobile(rs.getString(7));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return user;
	}
	// profile

	public User getAllData(String email, String pass) {
		User user = null;

		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement stm = con.prepareStatement("Select *from userdetails where email=?");
			stm.setString(1, email);
			

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				user = new User();

				user.setEmail(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setfName(rs.getString(3));
				user.setlName(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setMobile(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setImage(rs.getString(9));

				File file = new File("Images.jpg");

			}
		}

		/*
		 * Blob imageData = rs.getBlob("Images");
		 * 
		 * if( imageData != null ) { try { File tmpFile = new File(".jpg");
		 * FileOutputStream fos = new FileOutputStream(tmpFile); fos.write(
		 * imageData.getBytes(1L, (int)imageData.length()) ); fos.close(); String
		 * ss=tmpFile.getAbsolutePath(); System.out.println(ss);
		 * 
		 * //ImageIcon icon = new ImageIcon(ImageIO.read(tmpFile) ); //
		 * JOptionPane.showMessageDialog(null, icon); // tmpFile.deleteOnExit();
		 * 
		 * 
		 * } catch(IOException ioe) { ioe.printStackTrace();
		 * JOptionPane.showMessageDialog(null, "Failed To Load Image Data",
		 * "Load Error", JOptionPane.ERROR_MESSAGE); } } }
		 */

		catch (Exception asw) {

		}

		return user;
	}

}
