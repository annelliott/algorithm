import java.util.Scanner;
public class Taxi {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//ע��while������case
	            //��ʼ�������С
	        	int n = in.nextInt();
	        	//��ʼ���������
	            int k = in.nextInt();
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) {
					arr[i] = in.nextInt();
				}
	            for (int i = 0; i < k; i++) {
	            	int ini = arr[0];
					for (int j = 0; j < n-1; j++) {
						arr[j] = (arr[j] + arr[j+1]) % 100;
					}
					arr[n-1] = (arr[n-1] + ini) % 100;
				}
	            for (int i = 0; i < n - 1; i++) {
					System.out.print(arr[i] + " ");
				}
	            System.out.print(arr[n-1]);
	        }
	            //���м���
	    }	
}
