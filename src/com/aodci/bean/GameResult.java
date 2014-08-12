package com.aodci.bean;

public class GameResult {
	private int id;
	private String pName;
	private String cName;
	private int pGoal;
	private int cGoal;
	private String gameTime;
	private String field;
	private int leg;
	
	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}

	private String msg;

	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getpGoal() {
		return pGoal;
	}

	public void setpGoal(int pGoal) {
		this.pGoal = pGoal;
	}

	public int getcGoal() {
		return cGoal;
	}

	public void setcGoal(int cGoal) {
		this.cGoal = cGoal;
	}

	public String getGameTime() {
		return gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "GameResult [id=" + id + ", pName=" + pName + ", cName=" + cName + ", pGoal=" + pGoal + ", cGoal=" + cGoal + ", gameTime=" + gameTime
				+ ", field=" + field + ", leg=" + leg + ", msg=" + msg + "]";
	}

}
