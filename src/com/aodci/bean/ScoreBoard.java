package com.aodci.bean;

import java.io.Serializable;

public class ScoreBoard implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7632785585987559527L;
	private int id;
	private String name;
	private int win;
	private int faith;
	private int tie;
	private int score;
	private int gain;
	private int lose;
	private String imageUrl;

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

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getFaith() {
		return faith;
	}

	public void setFaith(int faith) {
		this.faith = faith;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGain() {
		return gain;
	}

	public void setGain(int gain) {
		this.gain = gain;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "ScoreBoard [id=" + id + ", name=" + name + ", win=" + win
				+ ", faith=" + faith + ", tie=" + tie + ", score=" + score
				+ ", gain=" + gain + ", lose=" + lose + ", imageUrl="
				+ imageUrl + "]";
	}

}
