package dfs_bfs;
import java.util.*;

public class p7576 {
	public static int N, M;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int day = Integer.MIN_VALUE;
	public static int dd = Integer.MAX_VALUE;
	public static Queue<int[]> que;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		que = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1 && !visited[i][j]) que.offer(new int[] {i, j, 0});
			}
		}
		bfs();
		
		//만약 안익은 토마토가 있으면 -1 반환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					day = -1; 
				}
			}
		}
		System.out.println(day);
	}
	public static void bfs() {
		
		while (!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			int d = que.peek()[2];
			
			que.poll();
			
			if (x < 0 || y < 0 || x >= N || y >= M) continue;
			if (visited[x][y]) continue;
			if (arr[x][y] != 1) continue;
			
			visited[x][y] = true;

			if (dd > d) day = d;
//			System.out.println(day);
		
			if (x > 0 && arr[x - 1][y] == 0) {
				que.offer(new int[] {x - 1, y, d + 1});
				arr[x - 1][y] = 1;
			}
			if (x < N - 1 && arr[x + 1][y] == 0) {
				que.offer(new int[] {x + 1, y, d + 1});
				arr[x + 1][y] = 1;
			}
			if (y > 0 && arr[x][y - 1] == 0) {
				que.offer(new int[] {x, y -1, d + 1});
				arr[x][y - 1] = 1;
			}
			if (y < M - 1 && arr[x][y + 1] == 0) {
				que.offer(new int[] {x , y + 1, d + 1});
				arr[x][y + 1] = 1;
			}
		
		}
	}

}
