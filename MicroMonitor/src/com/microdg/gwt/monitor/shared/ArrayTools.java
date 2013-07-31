package com.microdg.gwt.monitor.shared;

import java.util.ArrayList;

public class ArrayTools {

	public static String[] subset(String[] parsed, int i) {
		ArrayList<String> list = new ArrayList<String>();
		for(int index = i;index < parsed.length;index++){
			list.add(parsed[index]);
		}
		return list.toArray(new String[0]);
	}

	public static String toString(String[] parsed) {
		return toString(parsed,",");
	}
	
	public static String toString(String[] parsed,String delim){
		String str = "";
		for(String s : parsed){
			str += str.length() > 0 ? delim : "";
			str += s;
		}
		return str;
	}

}
