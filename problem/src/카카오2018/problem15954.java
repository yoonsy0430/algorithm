package 카카오2018;
import java.text.DecimalFormat;
import java.util.Scanner;

public class problem15954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		double K = sc.nextInt();
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		double[] m = new double[(int) (N-K+1)];
			
		//평균
		for (int i = 0; i < N-K+1; i++) {
			double c = 0.0;
			for (int j = i; j < K+i; j++) {
//				System.out.print(num[j] + " ");
				c += num[j];
			}	
			m[i] = (double)(c / K);
//			System.out.println("\n" + m[i]);
		}
		
		//분산
		double[] d = new double[m.length];
		for (int i = 0; i < N-K+1; i++) {
			for (int j = i; j < K+i; j++) {		
				
				d[i] += (double)Math.pow(num[j] - m[i], 2);
			}
//			System.out.println(d[i]);
		}
		double[] result = new double[m.length];
		double min = Double.MAX_VALUE;
		for (int i = 0; i < result.length; i++) {
			result[i] = (double)Math.sqrt(d[i] / K);
			if (result[i] < min) {
				min = result[i];
			}
//			System.out.println(result[i]);
		}
		DecimalFormat format = new DecimalFormat("#.###########");
		String str = format.format(min);
		System.out.println(str);
	}

}
