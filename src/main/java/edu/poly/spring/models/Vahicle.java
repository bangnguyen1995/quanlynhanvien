package edu.poly.spring.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vahicle")
public class Vahicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(length = 50)
	private String Name;
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ProducedDate;
	@Column
	private Integer Quantity;
	@Column(length = 50)
	private String Description;
	@Column
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getProducedDate() {
		return ProducedDate;
	}
	public void setProducedDate(Date producedDate) {
		ProducedDate = producedDate;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Vahicle(Integer id, String name, Date producedDate, Integer quantity, String description, double price) {
	
		Id = id;
		Name = name;
		ProducedDate = producedDate;
		Quantity = quantity;
		Description = description;
		this.price = price;
	}
	public Vahicle() {

	}

	
}
