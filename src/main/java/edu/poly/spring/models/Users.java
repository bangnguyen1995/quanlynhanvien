package edu.poly.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(length = 50)
private String username;
	@Column(length = 50)
private String password;
	@Column(length = 50)
private String hoten;
	@Column(length = 50)
private String email;
	@Column(length = 50)
private String diachi;
	@Column(length = 50)
private String sdt;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Users(String username, String password, String hoten, String email, String diachi, String sdt) {
	
		this.username = username;
		this.password = password;
		this.hoten = hoten;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public Users() {
	
	}
	
	
}
