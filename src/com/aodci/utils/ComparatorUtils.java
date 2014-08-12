package com.aodci.utils;

import java.util.Comparator;

import com.aodci.bean.ScoreBoard;

public class ComparatorUtils implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		ScoreBoard s1 = (ScoreBoard) o1;
		ScoreBoard s2 = (ScoreBoard) o2;
		int result = 2;
		int flag = s1.getScore() - (s2.getScore());
		if (flag == 0) {
			int i = (s1.getGain() - s1.getLose())
					- (s2.getGain() - s2.getLose());
			if (i > 0) {
				result = -1;
			} else if (i == 0) {
				result = 0;
			} else {
				result = 1;
			}
		} else if (flag > 0) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}
}
