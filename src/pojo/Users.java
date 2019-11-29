package pojo;

public class Users {
int id;
String name;
String email;
String phone;
String passwd;
String role;
public Users(int id, String name, String email, String phone, String passwd, String role) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.passwd = passwd;
	this.role = role;
}

public Users(){
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPasswd() {
	return passwd;
}

public void setPasswd(String passwd) {
	this.passwd = passwd;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", passwd=" + passwd
			+ ", role=" + role + "]";
}



}
