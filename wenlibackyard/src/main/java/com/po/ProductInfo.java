package com.po;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 商品信息表
 * @author Zeral
 *
 */
@Entity
@Table(name = "product_info")
public class ProductInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;	
	// Fields
	
	private Integer productId;
	private ProductType productType;
	private UserInfo userInfo;
	private String productName;
	private String brand;
	private String context;
	private String imgs;
	private Float price;
	private Integer number;
	private Date buydate;
	private Date pbdate;
	private Integer state;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private Set<Favorite> favorites = new HashSet<Favorite>(0);
	/*********************与界面关联的属性***************************/
	private File pic;
	private String picFileName;
	private String picContentType;
	
	
	// Constructors

	/** default constructor */
	public ProductInfo() {
	}

	/** minimal constructor */
	public ProductInfo(ProductType productType, UserInfo userInfo,
			String productName, String context, String imgs, Float price,
			Integer number, Date pbdate, Integer state) {
		this.productType = productType;
		this.userInfo = userInfo;
		this.productName = productName;
		this.context = context;
		this.imgs = imgs;
		this.price = price;
		this.number = number;
		this.pbdate = pbdate;
		this.state = state;
	}

	/** full constructor */
	public ProductInfo(ProductType productType, UserInfo userInfo,
			String productName, String brand, String context, String imgs,
			Float price, Integer number, Date buydate, Date pbdate,
			Integer state, Set<OrderDetail> orderDetails,
			Set<Favorite> favorites) {
		this.productType = productType;
		this.userInfo = userInfo;
		this.productName = productName;
		this.brand = brand;
		this.context = context;
		this.imgs = imgs;
		this.price = price;
		this.number = number;
		this.buydate = buydate;
		this.pbdate = pbdate;
		this.state = state;
		this.orderDetails = orderDetails;
		this.favorites = favorites;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "product_id", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_type_id", nullable = false)
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "product_name", nullable = false, length = 20)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "brand", length = 20)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "context", nullable = false, length = 65535)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "imgs", nullable = false, length = 65535)
	public String getImgs() {
		return this.imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	@Column(name = "price", nullable = false, precision = 7, scale = 2)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "number", nullable = false)
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "buy_date", length = 10)
	public Date getBuydate() {
		return this.buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pb_date", nullable = false, length = 10)
	public Date getPbdate() {
		return this.pbdate;
	}

	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}

	@Column(name = "state", nullable = false)
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productInfo")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productInfo")
	public Set<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	/**********************于界面关联的属性***************************/
	@Transient
	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	@Transient
	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	@Transient
	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

}