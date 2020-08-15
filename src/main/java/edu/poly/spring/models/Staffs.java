package edu.poly.spring.models;



import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staff")
public class Staffs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	@Column(length = 50)
	private String hoten;
	@Column(length = 50)
	private String email;
	@Column
	private boolean gioitinh;
	@Column(length = 15)
	private String sdt;
	@Column(length = 50)
	private String anh;
	@Column
	private double luong;
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	@Column(length = 50)
	private String mota;
	@ManyToOne
	@JoinColumn(name="departID")
	private departs depart;
	@OneToMany (mappedBy = "staff",cascade = CascadeType.ALL )
	private Collection <Records> record;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	
	public departs getDepart() {
		return depart;
	}
	public void setDepart(departs depart) {
		this.depart = depart;
	}
	public Collection<Records> getRecord() {
		return record;
	}
	public void setRecord(Collection<Records> record) {
		this.record = record;
	}
	public Staffs(Integer id, String hoten, String email, boolean gioitinh, String sdt, String anh, double luong,
			Date birthday, String mota, departs depart, Collection<Records> record) {
	
		this.id = id;
		this.hoten = hoten;
		this.email = email;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.anh = anh;
		this.luong = luong;
		this.birthday = birthday;
		this.mota = mota;
		this.depart = depart;
		this.record = record;
	}
	public Staffs() {

	}
	
	

	
}
	
	
	
	


	

