package dfs_bfs;

import java.util.*;

public class p1260 {
	public static int[][] arr;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int point = sc.nextInt(); //������ ����
		int line = sc.nextInt(); //������ ����
		int start = sc.nextInt(); //���� ������ ��ȣ
		
		arr = new int[point+1][point+1]; //���� ���ڴ�� �־�� ���ϱ� ������ +1
		
		for (int i = 0; i < line; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			arr[v1][v2] = arr[v2][v1] = 1; //1�� �� ������ ����Ǿ����� �ǹ�
		}
		
		visited = new boolean[point+1]; //dfs �湮ǥ�ÿ� ��ü ����
		dfs(start);
		//dfs2(start);
		
		System.out.println();
		
		visited = new boolean[point+1]; //bfs �湮ǥ�ÿ� ��ü ����
		bfs(start);
		
	}
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " "); 

		for (int i = 1; i < arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) { //������ 1�̸鼭 ���� �湮���� �ʾ����� 
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
	public static void dfs2(int start) { //���� Ȱ���� ���̿켱Ž��
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
