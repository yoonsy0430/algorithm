package dfs_bfs;
import java.util.*;

public class p2606 {
	public static int[][] arr;
	public static boolean[] visited;
	public static int c = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int point = sc.nextInt(); //컴퓨터의 수
		int line = sc.nextInt(); //서로 연결되어 있는 수
		
		arr = new int[point + 1][point + 1];
		
		for (int i = 0; i < line; i++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			
			arr[p1][p2] = arr[p2][p1] = 1;
		}
		
		visited = new boolean[point + 1];
		dfs(1);
//		dfs2(1);
//		bfs(1);
		System.out.print(c);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) {
				c++;
				dfs(i);
			}
		}
	}
	
	public static void dfs2(int start) {
		Stack<Integer> s = new Stack<Integer>();

		s.push(start);
		visited[start] = true;
		
		while (!s.isEmpty()) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[start][i] == 1 && visited[i] == false) {
					dfs2(i);
					c++;
				}
			}
			s.pop();
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		visited[start] = true;
		
		while (!que.isEmpty()) {
			int temp = que.peek();
			que.poll();
			for (int i = 1; i < arr.length; i++) {
				if (arr[temp][i] == 1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					c++;
				}
			}
		}
	}
	
}
