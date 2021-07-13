package com.ramdayal.userInterface;


import java.awt.Component;
import java.awt.Graphics;
//to insert photo same size of 
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Util{
	private static String emailPattern="^[a-zA-Z0-9]{1,20}@[a-zA-Z]{1,20}.[a-zA-Z]{2,3}$";
	private static   String regExpn = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	private static String mobilePattern="\\d{10}";
	
	// Image Resize.
public static ImageIcon resize(ImageIcon image,int width,int height) {
	BufferedImage bi=new BufferedImage(width,height,BufferedImage.TRANSLUCENT);
	Graphics2D gd=(Graphics2D) bi.getGraphics();
	gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	gd.drawImage(image.getImage(),0,0,width,height,null);
	gd.dispose();
	return new ImageIcon(bi);
}
// Show Message
public static void  errorMessage(Component cmp,String mass)
{
JOptionPane.showMessageDialog(cmp, mass,"Error-Message",JOptionPane.ERROR);	
}
public static  void   warningMessage(Component cmp,String mass)
{
JOptionPane.showMessageDialog(cmp, mass,"Warning-Message",JOptionPane.WARNING_MESSAGE);	
}
public static void   normalMessage(Component cmp,String mass)
{
JOptionPane.showMessageDialog(cmp, mass);	
}
//Email validation
public static boolean emailValidation(String email)
{
	Pattern pattern=Pattern.compile(emailPattern);
	return pattern.matcher(email).matches();
}
/// Password Validation
public static boolean isPasswordValid(String password) {
	
    CharSequence inputStr = password;

    Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(inputStr);

    if(matcher.matches())
        return true;
    else
        return false;
}


//number validation
public static boolean mobileNumber(String mobile){

	  Pattern pattern=Pattern.compile(mobilePattern);

	  Matcher matcher=pattern.matcher(mobile);

	  if(!matcher.matches()){

	   return false;

	  }else{

	   return true;
	  }
	 }
 

}


