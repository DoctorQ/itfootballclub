package com.aodci.bean;

public class Club {
	private int id;
	private String cName;
	private String homeField;
	private String coach;
	private String imgurl;
	private String builder;
	private String cTime;
	private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getHomeField() {
		return homeField;
	}

	public void setHomeField(String homeField) {
		this.homeField = homeField;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", cName=" + cName + ", homeField="
				+ homeField + ", coach=" + coach + ", imgurl=" + imgurl
				+ ", builder=" + builder + ", cTime=" + cTime + ", location="
				+ location + "]";
	}

}
