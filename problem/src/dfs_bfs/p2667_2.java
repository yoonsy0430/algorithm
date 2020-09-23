package dfs_bfs;
import java.util.*;

public class p2667_2 { 
	public static int n; //�� ���� ��
	public static int[][] apart; 
	public static boolean[][] visited;
	public static PriorityQueue<Integer> pq; //������ ���� �� ������������ ����ϱ� ����
	public static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		apart = new int[n][n];
		visited = new boolean[n][n];
		
		pq = new PriorityQueue<Integer>(); //������ ���� ���������°�
		
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				apart[i][j] = line.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (apart[i][j] == 1 && visited[i][j] == false) {
					count = 0;
					dfss(i, j); 
				}
			}
		}
		System.out.println(pq.size());
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		
		int count = 0;
		while (!queue.isEmpty()) {
			int cX = queue.peek()[0];
			int cY = queue.peek()[1];
			queue.poll();
			
			if (cX < 0 || cY < 0 || cX >= n || cY >= n) { //����Ʈ ���� ���� ������ �Ѿ��
				continue;
			}
			if (apart[cX][cY] == 0) { //���� ������ �Ѿ��
				continue;
			}
			if (visited[cX][cY] == true) { //�湮�� �߾����� �Ѿ��
				continue;
			}
			count++;
			visited[cX][cY] = true;
			
			//�����¿� Ȯ��
			queue.offer(new int[] {cX + 1, cY}); 
			queue.offer(new int[] {cX - 1, cY});
			queue.offer(new int[] {cX, cY + 1});
			queue.offer(new int[] {cX, cY - 1});
		}
		pq.offer(count);
	}
	
	public static void dfss(int x, int y) {	
		visited[x][y] = true;
		count++;
		
	
				if(x < n-1) {
				if(apart[x+1][y] == 1 ) {
					dfss(x+1, y);
				}
				}
				if (x > 1) {
				if (apart[x-1][y] == 1 && !visited[x-1][y]) {
					dfss(x+1, y);
				}}
				if(y < n-1) {
				if (apart[x][y+1] == 1 && !visited[x][y+1]) {
					dfss(x, y+1);
				}}
				if(y > 1) {
				if (apart[x][y-1] == 1 && !visited[x][y-1]) {
					dfss(x, y-1);
				}
				}
		
		pq.offer(count);
	}

}
