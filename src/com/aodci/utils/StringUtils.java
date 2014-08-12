package com.aodci.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.aodci.bean.ShotBoard;

public class StringUtils {
	private String band ;
	private String cname;
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public void splitString(String s) {
		int size = s.length();
		band = s.substring(size-1);
		cname = s.substring(0,size-1);
	}
	
	@Override
	public String toString() {
		return "StringUtils [band=" + band + ", cname=" + cname + "]";
	}

	public static void main(String args[]){
		StringUtils su = new StringUtils();
		String msg = "GOAL:Arsenal_aense_SECOND-HALF_13"+"GOAL:Arsenal_aense_SECOND-HALF_13"+
"GOAL:Manchester United_22_SECOND-HALF_11"+
				"GOAL:Manchester United_22_SECOND-HALF_11"+"GOAL:Arsenal_aense_SECOND-HALF_13"+"GOAL:Arsenal_aenses_SECOND-HALF_13";
		su.getShotBoardFromMsg(msg);
				
	}
	public int getSubNumber(String des, String reg) {
	     Pattern p = Pattern.compile(reg);
	     Matcher m = p.matcher(des);
	     int count = 0;//记录个数
	     while(m.find()){
	           count++;
	     }
	     return count;
	} 
	public List<ShotBoard> getShotBoardFromMsg(String msg){
		List<ShotBoard> list = new ArrayList<ShotBoard>();
		String ss[] = msg.split("GOAL:");
		ShotBoard sb = null;
		for(int i=1;i<ss.length;i++){
			sb = new ShotBoard();
			System.out.println(ss[i]);
			String s[] = ss[i].split("_");
			System.out.println(s.length);
			sb.setCname(s[0]);
			sb.setName(s[1]);
			sb.setGoals(1);
			sb.setCc(sb.getCname()+"_"+sb.getName());
			list.add(sb);
		}
		System.out.println("---------------------------------");
		for(ShotBoard sbShotBoard : list){
			System.out.println(sbShotBoard.toString());
		}
		for(int i=list.size()-1;i>=0;i--){
			ShotBoard shotBoard = list.get(i);
			int score = shotBoard.getGoals();
			for(int j = i-1;j>=0;j--){
				if(shotBoard.getCc().endsWith(list.get(j).getCc())){
					score=score+1;
					list.remove(j);
				}
			}
			shotBoard.setGoals(score);
		}
		System.out.println("---------------------------------");
		for(ShotBoard sbShotBoard : list){
			System.out.println(sbShotBoard.toString());
		}
		return list;
	}

}
