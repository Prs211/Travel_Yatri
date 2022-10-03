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
@Table(name = "images")
public class Images extends BaseEntity {
	@Transient
	private String imgUtility;
	@Lob
	@Column(name = "profile_image", length = 10000000)
	private byte[] image;
	
	private String description;

	public Images() {
		super();
	}

	public Images(byte[] image, String description) {
		super();
		this.image = image;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Images [imgUtility=" + imgUtility + ", image=" + Arrays.toString(image) + ", description=" + description
				+ "]";
	}
	
	
	
}
