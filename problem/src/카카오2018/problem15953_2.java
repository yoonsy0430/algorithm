package Ä«Ä«¿À2018;
import java.util.*;

public class problem15953_2 {
	public static int[] reward2017 = {0, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6};
	public static int[] reward2018 = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		
		int[][] reward = new int[T][2];
		
		for (int i = 0; i < T; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if (a > 21) a = 0;
			if (b > 31) b = 0;
		
			switch(reward2017[a]) {
			case 0 :
				reward[i][0] = 0;
				break;
			case 1 :
				reward[i][0] = 5000000;
				break;
			case 2 :
				reward[i][0] = 3000000;
				break;
			case 3 :
				reward[i][0] = 2000000;
				break;
			case 4 :
				reward[i][0] = 500000;
				break;
			case 5 :
				reward[i][0] = 300000;
				break;
			case 6 :
				reward[i][0] = 100000;
				break;
			}
			switch(reward2018[b]) {
			case 0 :
				reward[i][1] = 0;
				break;
			case 1 :
				reward[i][1] = 5120000;
				break;
			case 2 :
				reward[i][1] = 2560000;
				break;
			case 3 :
				reward[i][1] = 1280000;
				break;
			case 4 :
				reward[i][1] = 640000;
				break;
			case 5 :
				reward[i][1] = 320000;
				break;
			}
		}
		for (int i = 0; i < T; i ++) {
			System.out.println(reward[i][0] + reward[i][1]);
		}
		
	}
}
