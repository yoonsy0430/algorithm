package 유니언파인드;
import java.util.*;

public class p4195_mod {
	public static int[] parent;
	public static int[] rank;
	public static int[] relation;
	public static HashMap<String, Integer> map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			if (x < y) {
				parent[y] = x;
				relation[x] += relation[y];
			} else {
				parent[x] = y;
				relation[y] += relation[x];
			}
		} 
		
		
	}

}
