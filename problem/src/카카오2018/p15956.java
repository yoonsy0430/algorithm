package Ä«Ä«¿À2018;

import java.util.*;

public class p15956 {

	public static String[][] word;
	public static String[] sign;
	public static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String line = sc.next();
		
		String[] arr = line.split("&&");
		word = new String[arr.length][];
		sign = new String[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains("==")) {
				word[i] = arr[i].split("==");
				sign[i] = "==";
				
			} 
			if (arr[i].contains("!=")) {
				word[i] = arr[i].split("!=");
				sign[i] = "!=";
			}
		}
	
		for(int i = 0; i < word.length; i++) {
			for(int j = 0; j < word[i].length; j++) {
				if (!map.containsKey(word[i][j]))
					map.put(word[i][j], word[i][j]);
			}
		}
		for(int i = 0; i < word.length; i++) {
			System.out.println(word[i][0] + ", " + word[i][1]);
			union(word[i][0], word[i][1]);
		}
		
		System.out.println("===================");
		/*
		for (int i = 0; i < word.length; i++) {
			for(int j = 0; j < word[i].length; j++) {
				System.out.println(word[i][j] + ", " + find(map.get(word[i][j])));
			}
		}
		*/

		for (String s : map.keySet()) {
			if (s.matches("^[0-9]+$") && find(map.get(s)).matches("^[0-9]+$")) 
				continue;
			
			System.out.println((s + ", " + find(map.get(s))));
		}
		
	}
	public static void union(String x, String y) {
		x = find(map.get(x));
		y = find(map.get(y));
		
		if (!x.equals(y)) {
			if (x.length() > y.length()) {
				map.put(x, y);
			} else {
				map.put(y, x);
			}
		}
	}
	public static String find(String x) {
		if (x.equals(map.get(x))) {
			return x;
		}
		return find(map.get(x));
	}
	
	public static void check(String x, String y) {
		
	}
}