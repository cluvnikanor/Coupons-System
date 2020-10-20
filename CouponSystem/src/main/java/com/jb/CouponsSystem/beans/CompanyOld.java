//package com.jb.CouponsSystem.beans;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Companies")
//public class CompanyOld {
//
//	private long id;
//	private String name;
//	private String email;
//	private String password;
//	private List<CouponNew> coupons = new ArrayList<CouponNew>();
//
//	public CompanyOld() {
//	}
//
//	public CompanyOld(long id, String name, String email, String password, List<CouponNew> coupons) {
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.coupons = coupons;
//	}
//
//	public CompanyOld(String name, String email, String password) {
//		this.name = name;
//		this.email = email;
//		this.password = password;
//	}
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	@Column
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	@Column
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@Column
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@OneToMany(cascade = CascadeType.PERSIST)
//	public List<CouponNew> getCoupons() {
//		return coupons;
//	}
//
//	public void setCoupons(List<CouponNew> coupons) {
//		this.coupons = coupons;
//	}
//
//	@Override
//	public String toString() {
//		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", coupons="
//				+ coupons + "]";
//	}
//
//}
