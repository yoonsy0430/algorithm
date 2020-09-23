package dfs_bfs;
import java.util.*;

public class p2178 {
	public static int[][] map;
	public static boolean[][] visited;
	public static int N, M;
	public static int step = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i + 1][j + 1] = line.charAt(j) - '0';
			}
		}
		/*
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		*/
		bfs();
		System.out.println(step);
	}
	public static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {1, 1, 1});
		
		while (!que.isEmpty()) {
			int cX = que.peek()[0];
			int cY = que.peek()[1];
			int cnt = que.peek()[2];
			
			que.poll();

			if (cX < 1 || cY < 1 || cX > N || cY > M) continue;
			if (map[cX][cY] != 1) continue;
			if (visited[cX][cY]) continue;
			
			if (cX == N && cY == M) {
				if (step > cnt) {
					step = cnt;
				}
				continue;
			}
			visited[cX][cY] = true;
					
			que.offer(new int[] {cX - 1, cY, cnt+1});
			que.offer(new int[] {cX + 1, cY, cnt+1});
			que.offer(new int[] {cX, cY - 1, cnt+1});
			que.offer(new int[] {cX, cY + 1, cnt+1});
			
		}
		
		
	}
}
