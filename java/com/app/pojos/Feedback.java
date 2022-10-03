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
@Table(name = "feedback")
public class Feedback extends BaseEntity {

	private String name;
	
	private String feedback;
	@Transient
	private String imgUtility;
	@Lob
	@Column(name = "profile_image", length = 10000000)
	private byte[] image;
	
	private int rating;

	public Feedback() {
		super();
	}

	public Feedback(String name, String feedback, byte[] image, int rating) {
		super();
		this.name = name;
		this.feedback = feedback;
		this.image = image;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getImgUtility() throws UnsupportedEncodingException {

		byte[] encodeBase64 = Base64.encodeBase64(getImage());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", feedback=" + feedback + ", imgUtility=" + imgUtility + ", image="
				+ Arrays.toString(image) + ", rating=" + rating + "]";
	}
	
}
