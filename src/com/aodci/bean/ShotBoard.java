package com.aodci.bean;

public class ShotBoard {
	private int id;
	private String name;
	private String cname;
	private int goals;
	private String cc;

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "ShotBoard [id=" + id + ", name=" + name + ", cname=" + cname + ", goals=" + goals + ", cc=" + cc + "]";
	}

}
