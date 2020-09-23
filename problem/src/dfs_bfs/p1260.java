package dfs_bfs;

import java.util.*;

public class p1260 {
	public static int[][] arr;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int point = sc.nextInt(); //정점의 개수
		int line = sc.nextInt(); //간선의 개수
		int start = sc.nextInt(); //시작 정점의 번호
		
		arr = new int[point+1][point+1]; //정점 숫자대로 넣어야 편리하기 때문에 +1
		
		for (int i = 0; i < line; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			arr[v1][v2] = arr[v2][v1] = 1; //1은 두 정점이 연결되었음을 의미
		}
		
		visited = new boolean[point+1]; //dfs 방문표시용 객체 생성
		dfs(start);
		//dfs2(start);
		
		System.out.println();
		
		visited = new boolean[point+1]; //bfs 방문표시용 객체 생성
		bfs(start);
		
	}
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " "); 

		for (int i = 1; i < arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) { //정점이 1이면서 아직 방문하지 않았으면 
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		visited[start] = true;
		System.out.print(start + " ");
		
		while (!que.isEmpty()) { 
			int temp = que.peek(); 
			que.poll(); 
			for (int i = 1; i < arr.length; i++) {
				if (arr[temp][i] == 1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	public static void dfs2(int start) { //스택 활용한 깊이우선탐색
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		visited[start] = true;
		System.out.print(start + " ");
		
		while (!stack.isEmpty()) {
			for(int i = 1; i < arr.length; i++) {
				if (arr[start][i] == 1 && visited[i] == false) {
					dfs2(i);
				}
			}
			stack.pop();
		}
	}
	
}
