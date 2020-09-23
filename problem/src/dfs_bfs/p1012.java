package dfs_bfs;
import java.util.*;

public class p1012 {
	public static int[][] map;
	public static boolean[][] visited;
	public static int n, row, col, num;
	public static Queue<Integer> pq;
	public static Queue<Integer> que = new LinkedList<Integer>();
	public static Scanner sc = new Scanner(System.in);
//	public static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		n = sc.nextInt();
//		arr = new int[n];
		
		for (int x = 0; x < n; x++) {
			row = sc.nextInt();
			col = sc.nextInt();
			num = sc.nextInt();
			
			map = new int[row][col];
			visited = new boolean[row][col];
			pq = new LinkedList<Integer>();
			
			farm(row, col, num);
			que.offer(pq.size());
//			arr[x] = pq.size();
		}
		
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
		/*
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
	}
	public static void farm(int r, int c, int num) {
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] = 1;
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		
	}
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y});
		
		int count = 0;
		while (!queue.isEmpty()) {
			int cX = queue.peek()[0];
			int cY = queue.peek()[1];

			queue.poll();
			
			if (cX < 0 || cY < 0 || cX >= row || cY >= col) {
				continue;
			}
			if (map[cX][cY] != 1) {
				continue;
			}
			if (visited[cX][cY]) {
				continue;
			}
			visited[cX][cY] = true;
			count++;
			
			queue.offer(new int[] {cX + 1, cY});
			queue.offer(new int[] {cX - 1, cY});
			queue.offer(new int[] {cX, cY + 1});
			queue.offer(new int[] {cX, cY - 1});
		}
		pq.offer(count);
	}

}
