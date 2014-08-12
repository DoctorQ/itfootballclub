package com.aodci.bean;

public class Sporter {
	private int id;
	private String name;
	private String cName;
	private String born;
	private String country;
	private String sendClub;
	private String band;
	private String image;
	private int number;
	private String role;

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSendClub() {
		return sendClub;
	}

	public void setSendClub(String sendClub) {
		this.sendClub = sendClub;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Sporter [id=" + id + ", name=" + name + ", cName=" + cName + ", born=" + born + ", country=" + country + ", sendClub=" + sendClub
				+ ", band=" + band + ", image=" + image + ", number=" + number + ", role=" + role + "]";
	}
	
	
}
