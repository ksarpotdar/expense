/**
 * Package that contains classes related to user
 */
package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db.Db;

/**
 * @author	Srivathsa PV
 * @email	pv.srivathsa@gmail.com
 * @date	15/01/2013
 * 
 * Users form the basic entity who use this expense management system
 */
public class User {

	/**
	 * Name of the table to which the class is mapped to
	 * 
	 * @var String
	 */
	private static String t_name = "USER";
	
	/**
	 * Unique id of the user - usually the employee code given in the id card
	 * 
	 * @var String
	 */
	private String userid;
	
	/**
	 * The social security number of the user
	 * 
	 * @var String
	 */
	private String socialSecurity;
	
	/**
	 * User's first name
	 * 
	 * @var String
	 */
	private String firstName;
	
	/**
	 * User's middle name
	 * 
	 * @var String
	 */
	private String middleName;
	
	/**
	 * User's last name
	 * 
	 * @var String
	 */
	private String lastName;
	
	/**
	 * Id of the department to which the user belongs
	 * 
	 * @var Integer
	 */
	private int deptid;
	
	/**
	 * User's designation
	 * 
	 * @var String
	 */
	private String designation;
	
	/**
	 * User's residential address
	 * 
	 * @var String
	 */
	private String address;
	
	/**
	 * User's phone number
	 * 
	 * @var String
	 */
	private String phone;
	
	/**
	 * User's mobile number
	 * 
	 * @var String
	 */
	private String mobile;
	
	/**
	 * User's email id
	 * 
	 * @var String
	 */
	private String email;
	
	/**
	 * User's photo in blob format
	 * 
	 * @var String
	 */
	private String photo;
	
	/**
	 * User's date of birth
	 * 
	 * @var Date
	 */
	private Date dob;
	
	/**
	 * Constructs an empty object
	 */
	public User() {}
	
	/**
	 * Fetches necessary data and initializes the variables
	 * 
	 * @param String
	 * Id of the user to be fetched (Optional)
	 * 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User(String userid) throws ClassNotFoundException, SQLException {
		Db db = new Db();
		db.connect();
		
		ResultSet rs = db.executeQuery("SELECT * FROM " + t_name + " WHERE USERID = '" + userid);
		rs.next();
		
		this.userid = userid;
		this.socialSecurity = rs.getString("SOCIALSECURITY");
		this.firstName = rs.getString("FIRSTNAME");
		this.middleName = rs.getString("MIDDLENAME");
		this.lastName = rs.getString("LASTNAME");
		this.deptid = rs.getInt("DEPTID");
		this.designation = rs.getString("DESIGNATION");
		this.address = rs.getString("ADDRESS");
		this.phone = rs.getString("PHONE");
		this.mobile = rs.getString("MOBILE");
		this.email = rs.getString("EMAIL");
		this.photo = rs.getString("PHOTO");
		this.dob = rs.getDate("DOB");
		
		db.disconnect();
	}
	
	/**
	 * Gets the user id
	 * 
	 * @return String
	 */
	public String getUserid() {
		return this.userid;
	}
	
	/**
	 * Gets the social security number
	 * 
	 * @return String 
	 */
	public String getSocialSecurity() {
		return this.socialSecurity;
	}
	
	/**
	 * Sets the social security number
	 * 
	 * @param String
	 */
	public void setSocialSecurity(String socSec) {
		this.socialSecurity = socSec;
	}
	
	/**
	 * Gets the first name
	 * 
	 * @return String
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Sets the first name
	 * 
	 * @param String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the middle name
	 * 
	 * @return String
	 */
	public String getMiddleName() {
		return this.middleName;
	}
	
	/**
	 * Sets the middle name
	 * 
	 * @param String
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * Gets the last name
	 * 
	 * @return String
	 */
	public String getlastName() {
		return this.lastName;
	}
	
	/**
	 * Sets the last name
	 * 
	 * @param String
	 */
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the department id
	 * 
	 * @return Integer
	 */
	public int getDeptid() {
		return this.deptid;
	}
	
	/**
	 * Sets the department id
	 * 
	 * @param Integer
	 */
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	/**
	 * Gets the designation
	 * 
	 * @return String
	 */
	public String getDesignation() {
		return this.designation;
	}
	
	/**
	 * Sets the designation
	 * 
	 * @param String
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**
	 * Gets the address
	 * 
	 * @return String
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Sets the address
	 * 
	 * @param String
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the phone number
	 * 
	 * @return String
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Sets the phone number
	 * 
	 * @param String
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the mobile number
	 * 
	 * @return String
	 */
	public String getMobile() {
		return this.mobile;
	}
	
	/**
	 * Sets the mobile number
	 * 
	 * @param String
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the email
	 * 
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the email
	 * 
	 * @param String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the photo in blob format
	 * 
	 * @return String
	 */
	public String getPhoto() {
		return this.photo;
	}
	
	/**
	 * Sets the photo in blob format
	 * 
	 * @param String
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	/**
	 * Gets the date of birth
	 * 
	 * @return Date
	 */
	public Date getDob() {
		return this.dob;
	}
	
	/**
	 * Sets the date of birth
	 * 
	 * @param Date
	 */
	public void setDate(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * Saves the local values to the database
	 * 
	 * @return Boolean - Returns true on success
	 * 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean save() throws ClassNotFoundException, SQLException {
		Db db = new Db();
		db.connect();
		
		String query = "";
		
		if(this.userid.equals("")) {
			query = "INSERT INTO " + t_name + " VALUES(DEFAULT,'" + 
					this.socialSecurity + "','" + this.firstName + "','" + this.middleName + "','" + 
					this.lastName + "','" + this.deptid + "','" + this.designation + "','" + 
					this.address + "','" + this.phone + "','" + this.mobile + "','" + 
					this.email  + "','" + this.photo + "','" + this.dob.toString() + "')";
					
		}
		else {
			query = "UPDATE " + t_name + " SET SOCIALSECURITY = '" + 
					this.socialSecurity + "', FIRSTNAME = '" + 
					this.firstName + "', MIDDLENAME = '" + 
					this.middleName + "', LASTNAME = '" + 
					this.lastName + "', DEPTID = '" + 
					this.deptid + "', DESIGNATION = '" + 
					this.designation + "', ADDRESS = '" + 
					this.address + "', PHONE = '" + 
					this.phone + "', MOBILE = '" + 
					this.mobile + "', EMAIL = '" + 
					this.email + "', PHOTO = '" + 
					this.photo + "', DOB = '" + 
					this.dob.toString() + "' WHERE USERID = '" + this.userid + "'";
		
			
		}
		int n = db.executeUpdate(query);
		db.disconnect();
		
		if(n > 0) return true;
		else return false;
	}
	
	/**
	 * Returns a list of user objects
	 * 
	 * @param String - Column name as the filter parameter
	 * @param String - Value
	 * 
	 * @return Array[user.User]
	 * 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static User[] list(String column,String value) throws ClassNotFoundException, SQLException {
		Db db = new Db();
		db.connect();
		
		ResultSet rs = db.executeQuery("SELECT COUNT(*) FROM " + t_name + " WHERE " + column + " = '" + value);
		rs.next();
		
		User[] list = new User[rs.getInt(1)];
		
		rs = db.executeQuery("SELECT * FROM " + t_name + " WHERE " + column + " = '" + value);
		
		int i=0;
		while(rs.next()) {
			list[i++] = new User(rs.getString("USERID"));
		}
		
		return list;
	}
	
	/**
	 * Returns a count based on the values
	 * 
	 * @param String - Column name as filter parameter
	 * @param String - Value
	 * 
	 * @return Integer - The count
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int count(String column,String value) throws ClassNotFoundException, SQLException {
		Db db = new Db();
		db.connect();
		
		ResultSet rs = db.executeQuery("SELECT COUNT(*) FROM " + t_name + " WHERE " + column + " = '" + value);
		rs.next();
		
		return rs.getInt(1);
	}
		

	
}