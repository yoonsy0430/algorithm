package 유니언파인드;
import java.util.*;
public class p4195 {
	public static Scanner sc = new Scanner(System.in);
	public static String[][] people;
	public static int F;
	public static Map<String, String> parent;
	public static Map<String, Integer> count;
	public static String str = "";
//	public static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = sc.nextInt(); //테스트 케이스의 개수
		
		for (int k = 0; k < n; k++) {
			F = sc.nextInt(); //친구 관계의 수
			people = new String[F][2];
			parent = new HashMap<>();
			count = new HashMap<>();		
			relation();
		}
		System.out.print(str);
	}
	public static void relation() {
		for (int i = 0; i < F; i++) {
			for (int j = 0; j < 2; j++) {
				people[i][j] = sc.next();
				parent.put(people[i][j], people[i][j]);
				count.put(people[i][j], 1);
			}
		}
		for (int i = 0; i < F; i++) {
			union(people[i][0], people[i][1]);
			checkParent(people[i][0], people[i][1]);
		}

	}
	public static void union(String x, String y) {
		x = find(parent.get(x));
		y = find(parent.get(y));
		
		if (x.compareTo(y) != 0) {
			if (x.compareTo(y) > 0) {
				parent.put(x, y);
			} else {
				parent.put(y, x);
			}
		}
	}
	public static void checkParent(String x, String y) {
		x = find(parent.get(x));
		y = find(parent.get(y));
		
		if (x.equals(y)) {
			count.put(x, count.get(x)+1);
		} 
		str += count.get(x) + "\n";
	}
	public static String find(String x) {
		if (x.equals(parent.get(x))) {
			return x;
		}
		return find(parent.get(x));
	}

}
