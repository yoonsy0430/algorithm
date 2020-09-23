package 유니언파인드;
import java.util.*;
public class p1717_xx {

	public static ArrayList<Integer> list = new ArrayList<>(); //https://steady-coding.tistory.com/108
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[m][3];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < m; i++) {
			if (arr[i][0] == 0) {
				list.add(arr[i][1]);
				list.add(arr[i][2]);
				System.out.println(arr[i][1] + "," + arr[i][2] + "삽입" );
			}
			else {
				find(arr[i][1], arr[i][2]);
			}
		
		}
		
		
	}
	public static void find(int num1, int num2) {
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
