package dfs_bfs;

import java.util.*;

public class p1697 {
	public static int N, M, S;
	public static Queue<int[]> que;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		bfs();
		System.out.println(S);
	}

	public static void bfs() {
		que = new LinkedList<int[]>();
		
		que.offer(new int[] {N, 0});

		while (!que.isEmpty()) {
			int a = que.peek()[0];
			int s = que.peek()[1];

			que.poll();

			if (a == M) {
				S = s;
				break;
			}
			que.offer(new int[] { a + 1, s + 1 });
			que.offer(new int[] { a - 1, s + 1 });
			que.offer(new int[] { a * 2, s + 1 });

		}
	}

}
