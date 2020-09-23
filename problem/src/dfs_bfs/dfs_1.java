package dfs_bfs; //https://pangsblog.tistory.com/26?category=806773

import java.util.*;
public class dfs_1 {
	public static ArrayList<Integer>[] list;
	public static int n;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt(); //���� ����
		
		int m = scanner.nextInt(); //������ ����
		int start = scanner.nextInt(); //���� ����
		
		list = new ArrayList[n+1];
		
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Integer>(); //����Ʈ �ʱ�ȭ
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
		if (visited[x]) { //�湮�ߴ��Ÿ� ����
			return;
		}
		visited[x] = true; //�湮, ǥ��
		System.out.print(x + " ");
		for (int y: list[x]) { // �湮�� �������� ����Ʈ���� Ž��
			if (!visited[y]) { //�湮���� �ʾ����� �� ���������κ��� �ٽ� dfs
				dfs(y);
			}
		}
	}
	public static void bfs(int start) {

	}	
}
