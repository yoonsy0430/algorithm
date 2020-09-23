import java.util.*;

public class p14502 {

	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int wall = 0;
	public static Queue<int[]> que;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		que = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					que.offer(new int[] { i, j, 0 });
			}
		}
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		

	}

	public static void bfs() {
		que = new LinkedList<int[]>();
		
		while (!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			int w = que.peek()[2];
	
			que.poll();
			
			if (map[x][y] == 1) continue;
			if (x < 0 || y < 0 || x >= N || y >= M) continue;
			
			if (w < 3) {
				if (map[x][y] == 2) {
					if (map[x+1][y] == 0) {
						
					}
				}
			}
		}

	}

}
