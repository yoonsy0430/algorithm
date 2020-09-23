package 최단경로;

import java.util.*;

public class p1753 {

	public static int V, E;
	public static int[][] arr;
	public static boolean[] visited;
	public static int[] distance;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		int start = sc.nextInt();
		arr = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			arr[u][v] = w;	
		}
		aa(start);
	}
	public static void aa(int start) {
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		
		que.offer(start);
		while(!que.isEmpty()) {
			int c = que.peek();
			que.poll();
			
			visited[c] = true;
			
			for(int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
	
						
					}
				}
			}
			
		}

}
