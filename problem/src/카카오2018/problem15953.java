package Ä«Ä«¿À2018;

import java.util.*;

public class problem15953 {
	public static int[] reward2017 = {0, 5000000, 3000000, 2000000, 500000, 300000, 100000 };
	public static int[] reward2018 = {0, 5120000, 2560000, 1280000, 640000, 320000 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		int[][] reward = new int[T][2];
		
		for (int i = 0; i < T; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			reward[i][0] = reward2017[year2017(a)];
			reward[i][1] = reward2018[year2018(b)];
			
		}
		for (int i = 0; i < T; i++) {
			System.out.println(reward[i][0] + reward[i][1]);
		}

	}

	public static int year2017(int a) {
		int sum = 0;
		int rank = 0;
		
		if (a > 21) {
			rank = 0;
		}
		else {
			for (int i = 1; i <= 6; i++) {
				sum += i;
				if (a <= sum) {
					rank = i;
					break;
				}
			}
		}
		return rank;
	}

	public static int year2018(int b) {
		int sum = 0;
		int rank = 0;

		if (b > 31) {
			rank = 0;
		}
		else {
			for (int i = 1; i <= 16; i*=2) {
				sum += i;
				rank++;
				if (b <= sum) {
					break;
				}
			}
		}
		return rank;
	}
}
