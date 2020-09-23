package ���Ͼ����ε�;
import java.util.*;

public class p1717 {
	public static int[] parent;
	
	public static int[][] nums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		nums = new int[m][3];
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < m; i++) {
			if (nums[i][0] == 0) { 
				union(nums[i][1], nums[i][2]); //a�� b�� ��ģ�� 
			} else {
				checkParent(nums[i][1], nums[i][2]); //a�� b�� ���� ���տ� ���ԵǾ� �ִ��� Ȯ��
			}
		}
	
		
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			if (a < b) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
	}

	public static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]); 
	}
	
	public static void checkParent(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
