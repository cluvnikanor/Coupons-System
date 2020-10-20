//package com.jb.CouponsSystem.beans;
//
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
//@Table(name = "Categories")
//public class CategoryOld {
//	private long id;
//	private String name;
//	private List<CouponNew> coupons;
//
//	public CategoryOld() {
//	}
//
//	public CategoryOld(long id, String name, List<CouponNew> coupons) {
//		this.id = id;
//		this.name = name;
//		this.coupons = coupons;
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
//		return "Category [id=" + id + ", name=" + name + ", coupons=" + coupons + "]";
//	}
//
//}
