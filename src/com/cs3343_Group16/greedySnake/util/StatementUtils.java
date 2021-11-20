package com.cs3343_Group16.greedySnake.util;

public class StatementUtils {
	public static String[][] copyState(String[][] template) {
		String[][] result = new String[template.length][template[0].length];
		for (int i = 0; i < template.length; i++) {
			for (int j = 0; j < template[i].length; j++) {
				result[i][j] = template[i][j];
			}
		}
		return result;
	}
}
