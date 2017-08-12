package string;

import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Main3 {
	// 求一个数的最大的因数
	public static int getMax(int n) {
		int res = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) 
				res = i;
		}
		return res;
	}
	// dp[n][0]表示第n位为n，dp[n][1]表示第n位为y。
	// flag表示距离最大的因数。
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);*/
		int n = 6;
		int[][] dp = new int[n][2];
	    dp[0][0] = 0;
	    dp[0][1] = 1;
	    for (int i = 1; i < n; i++) {
			int flag = getMax(i + 1);
			if(flag != 1) {
				double d = Math.pow(2, i - flag - 1);
				dp[i][1] = dp[flag][1] * (new Double(d)).intValue();
				dp[i][0] = dp[i][1] * 2;
			}else {
				dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
				dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			}			
		}
	    System.out.println(dp[n - 1][0] + dp[n - 1][1]);
	}
}
