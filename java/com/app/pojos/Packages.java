package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "packages")
public class Packages extends BaseEntity {

	private String title;
	private String details;
	private String price;
	private String discount;
	private int rating;

	@Transient
	private String imgUtility;
	@Lob
	@Column(name = "profile_image", length = 10000000)
	private byte[] image;

	public Packages() {
		super();
	}

	public Packages(String title, String details, String price, String discount, int rating, byte[] image) {
		super();
		this.title = title;
		this.details = details;
		this.price = price;
		this.discount = discount;
		this.rating = rating;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public String getImgUtility() throws UnsupportedEncodingException {

		byte[] encodeBase64 = Base64.encodeBase64(getImage());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

	@Override
	public String toString() {
		return "Packages [title=" + title + ", details=" + details + ", price=" + price + ", discount=" + discount
				+ ", rating=" + rating + ", imgUtility=" + imgUtility + ", image=" + Arrays.toString(image) + "]";
	}

}
