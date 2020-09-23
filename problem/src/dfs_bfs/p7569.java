package dfs_bfs;
import java.util.*;

public class p7569 {
	public static int N, M, H;
	public static int[][][] arr;
	public static boolean[][][] visited;
	public static Queue<int[]> que;
	public static int days = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<int[]>();
		
		M = sc.nextInt(); //가로
		N = sc.nextInt(); //세로
		H = sc.nextInt(); //높이
		
		arr = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = sc.nextInt();
					if (arr[i][j][k] == 1 && !visited[i][j][k]) que.offer(new int[] {i, j, k, 0});
				}
			}
		}	
		
		bfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 0) days = -1;
				}
			}
		}
		System.out.println(days);
	}
	public static void tomato(int h, int x, int y, int d) {
		arr[h][x][y] = 1;
		que.offer(new int[] {h, x, y, d});
	}
	public static void bfs() {
		while (!que.isEmpty()) {
			int h = que.peek()[0];
			int x = que.peek()[1];
			int y = que.peek()[2];
			int d = que.peek()[3];
			
			que.poll();
			
			if (x < 0 || y < 0 || h < 0 || x >= N || y >= M || h >= H) continue;
			if (visited[h][x][y]) continue;
			if (arr[h][x][y] != 1) continue;
			
			visited[h][x][y] = true;
			
			if (days < d) days = d;
			
			if (x > 0 && arr[h][x-1][y] == 0) {
				tomato(h, x-1, y, d+1);
			}
			if (x < N-1 && arr[h][x+1][y] == 0) {
				tomato(h, x+1, y, d+1);
			}
			if (y > 0 && arr[h][x][y-1] == 0) {
				tomato(h, x, y-1, d+1);
			}
			if (y < M-1 && arr[h][x][y+1] == 0) {
				tomato(h, x, y+1, d+1);
			}
			if (h > 0 && arr[h-1][x][y] == 0) {
				tomato(h-1, x, y, d+1);
			}
			if (h < H-1 && arr[h+1][x][y] == 0) {
				tomato(h+1, x, y, d+1);
			}
		}
	}

}
