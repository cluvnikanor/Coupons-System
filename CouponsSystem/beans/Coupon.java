package com.jb.CouponsSystem.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Coupons")
public class Coupon {
	private int id;
	private int CompanyId;
	private int CategoryId;
	private String title;
	private String description;
	private Date startDate;
	private Date endDateDate;
	private int amount;
	private double price;
	private String image;
	private List<Customer> customers = new ArrayList<Customer>();

	public Coupon() {
	}

	public Coupon(int id, int companyId, int categoryId, String title, String description, Date startDate,
			Date endDateDate, int amount, double price, String image, List<Customer> customers) {
		this.id = id;
		CompanyId = companyId;
		CategoryId = categoryId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDateDate = endDateDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
		this.customers = customers;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}

	@Column
	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column
	public Date getEndDateDate() {
		return endDateDate;
	}

	public void setEndDateDate(Date endDateDate) {
		this.endDateDate = endDateDate;
	}

	@Column
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToMany(cascade = CascadeType.PERSIST)
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", CompanyId=" + CompanyId + ", CategoryId=" + CategoryId + ", title=" + title
				+ ", description=" + description + ", startDate=" + startDate + ", endDateDate=" + endDateDate
				+ ", amount=" + amount + ", price=" + price + ", image=" + image + "]";
	}

}
