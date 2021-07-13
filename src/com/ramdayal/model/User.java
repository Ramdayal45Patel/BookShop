package com.ramdayal.model;

public class User {
private String Email;
private String pass;
private String fName;
private String lName;
private String gender;
private String dob;
private String address;
private String mobile;
private String image1;

public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String email, String pass, String fName, String lName, String gender,String dob, String mobile, String address,
		 String image) {
	super();
	Email = email;
	this.pass = pass;
	this.fName = fName;
	this.lName = lName;
	this.gender = gender;
	this.address = address;
	this.mobile = mobile;
	this.dob = dob;
	this.image1 = image;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
private String image;

public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getImage() {
	return image1;
}
public void setImage(String image) {
	this.image1 = image;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}


}
