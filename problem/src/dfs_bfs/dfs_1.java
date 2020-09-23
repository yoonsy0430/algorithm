package dfs_bfs; //https://pangsblog.tistory.com/26?category=806773

import java.util.*;
public class dfs_1 {
	public static ArrayList<Integer>[] list;
	public static int n;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt(); //정점 개수
		
		int m = scanner.nextInt(); //간선의 개수
		int start = scanner.nextInt(); //시작 정점
		
		list = new ArrayList[n+1];
		
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Integer>(); //리스트 초기화
		}
		
		for (int i = 0; i < m; i++) {
			int v1 = scanner.nextInt(); 
			int v2 = scanner.nextInt();
			
			list[v1].add(v2);
			list[v2].add(v1);
		}
		for (int i = 1; i < n; i++) {
			Collections.sort(list[i]);
		}
		visited = new boolean[n+1];
		dfs(start);
		System.out.println();
	}
	public static void dfs(int x) {
		if (visited[x]) { //방문했던거면 리턴
			return;
		}
		visited[x] = true; //방문, 표시
		System.out.print(x + " ");
		for (int y: list[x]) { // 방문한 꼭짓점의 리스트에서 탐색
			if (!visited[y]) { //방문되지 않았으면 그 꼭짓점으로부터 다시 dfs
				dfs(y);
			}
		}
	}
	public static void bfs(int start) {

	}	
}
