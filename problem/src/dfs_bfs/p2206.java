package dfs_bfs;

import java.util.*;

public class p2206 {
	public static int N, M;
	public static int[][] map;
	public static boolean[][][] visited;
	public static Queue<int[]> que = new LinkedList<int[]>();
	public static int count = Integer.MIN_VALUE;
	public static int drill = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		visited = new boolean[2][N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i + 1][j + 1] = line.charAt(j) - '0';
			}
		}

		bfs();
	}

	public static void bfs() {
		que.offer(new int[] { 1, 1, 1, 0 });

		while (!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			int c = que.peek()[2];
			int w = que.peek()[3];

			que.poll();

			if (x == N & y == M) {
				count = c;
				break;
			}
			else count = -1;
			
			if (x > 0 && x <= N && y > 0 && y <= M) {
				if (map[x][y] == 1) {
					if (w == 0 && !visited[1][x][y]) {
						que.offer(new int[] {x+1, y, c+1, 1});
						que.offer(new int[] {x-1, y, c+1, 1});
						que.offer(new int[] {x, y+1, c+1, 1});
						que.offer(new int[] {x, y-1, c+1, 1});
						visited[1][x][y] = true;
					}
				}
				else {
					if (!visited[w][x][y]) {
						que.offer(new int[] {x+1, y, c+1, w});
						que.offer(new int[] {x-1, y, c+1, w});
						que.offer(new int[] {x, y+1, c+1, w});
						que.offer(new int[] {x, y-1, c+1, w});
						visited[w][x][y] = true;
					}
				}
			}
		}
		System.out.print(count);

	}
	public static void offer(int x, int y, int c, int w) {
		que.offer(new int[] { x + 1, y, c + 1, w });
		que.offer(new int[] { x - 1, y, c + 1, w });
		que.offer(new int[] { x, y + 1, c + 1, w });
		que.offer(new int[] { x, y - 1, c + 1, w });
	}
}
