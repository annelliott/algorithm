package recursionANDdp;

public class MLS {
	//　首先得出矩阵，利用动态规划来实现
	//  比较两个字符串数组中的最长公共子序列
	//  str1 = "1A2C3D4B56", str2 = "B1D23C45B6A",则最长公共子序列为
	//  res = "123456" 或 "12C4B6"
	public static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		// dp[i][j]表示str1[0..i]和str2[0...j]之间的最大公共子序列的长度
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}
		// dp[i][j]可能是dp[i - 1][j],也可能是dp[i][j - 1],
		// 也可能最后一个字符相等dp[i - 1][j - 1] + 1
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp;		
	}
	public static String lcse(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		// 转化为字符串数组
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[][] dp = getdp(chs1, chs2);
		int m = chs1.length - 1;
		int n = chs2.length - 1;
		char[] res = new char[dp[m][n]];
		int index = res.length - 1;
		while (index >= 0) {
			if (n > 0 && dp[m][n] == dp[m][n - 1]) {
				n--;                                                                   
			} else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
				m--;
			} else {
				// 提取出相等的那个字符
				res[index--] = chs1[m];
				m--;
				n--;
			}			
		}
		return String.valueOf(res);
	}
	public static void main(String[] args) {
		String str1 = "1A2C3D4B56";
		String str2 = "B1D23C4A5B6A";
		System.out.println(lcse(str1, str2));
	}
}
