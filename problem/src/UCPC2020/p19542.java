package UCPC2020;

import java.util.*;

public class p19542 {
	public static int N, S, D;
	public static int[][] arr;
	public static boolean visited[];
	public static int p = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		D = sc.nextInt();

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			arr[x][y] = arr[y][x] = 1;

		}
		bfs();
//		dfs(S);
	}

	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");

		for (int j = 1; j <= N; j++) {
			if (arr[start][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}

	public static void bfs() {

		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(S);
//		System.out.print(S + " ");

//		int count = 0;
		while (!que.isEmpty()) {
			int c = que.peek();
			visited[c] = true;
			que.poll();

			int count = 0;
			for (int j = 1; j <= N; j++) {
				if (arr[c][j] == 1 && !visited[j]) {
					visited[j] = true;
					que.offer(j);
					count++;
//						System.out.print(j + " ");
				}
			}
		}

//		System.out.println(count);
	}

}
