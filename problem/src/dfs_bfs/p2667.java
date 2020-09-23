package dfs_bfs;

import java.util.*;

public class p2667 {
	public static int dx[] = {0, 0, 1, -1};
	public static int dy[] = {1, -1, 0, 0};
	public static int[] apartment = new int[25 * 25];
	public static int apartNum = 0;
	public static boolean[][] visited;
	public static int[][] map;
	public static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (checkLocation(i, j)) {
					int val = dfs(i, j);
					list.add(val);
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(apartNum);
		
		for (int i = 0; i < apartment.length; i++) {
			if (apartment[i] == 1) {
				System.out.println(apartment[i]);
			}
		}
	}
	public static int dfs(int x, int y) {
		int val = 1;
		visited[x][y] = true;
		
		if (checkLocation(x - 1, y)) {
			val += dfs(x - 1, y);
		}
		if (checkLocation(x, y + 1)) {
			val += dfs(x, y + 1);
		}
		if (checkLocation(x + 1, y)) {
			val += dfs(x + 1, y);
		}
		if (checkLocation(x, y - 1)) {
			val += dfs(x, y - 1);
		}
		return val;
		
	}
	public static boolean checkLocation(int x, int y) {
		//좌표 값이 잘못된 경우
		if (x < 1 || x > n || y < 1 || y > n) {
			return false;
		}
		//이미 지나간 경로인 경우 or 집이 아닌 경우
		if (visited[x][y] == true || map[x][y] == 0) {
			return false;
		}
		return true;
	}
	/*
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		apartment[apartNum]++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}
	*/

}
