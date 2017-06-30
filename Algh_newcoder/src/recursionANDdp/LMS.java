package recursionANDdp;
/**
 * 求最长公共子串问题
 * 给定两个字符串str1和str2,返回两个字符串的最长公共子串
 * */
public class LMS {
	// dp[i][j]是指以i和j为结尾的最长子串的长度
	public static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		// 初始化
		for (int i = 0; i < str1.length; i++) {
			if (str1[i] == str2[0]) {
				dp[i][0] = 1;
			}
		}
		for (int j = 1; j < str2.length; j++) {
			if (str2[j] == str1[0]) {
				 dp[0][j] = 1;
			}
		}
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		return dp;
	}
	// 得出最大公共子串的长度
	// 时间复杂度为O(M*N)，空间复杂度为O(M*N)
	public static String lcst1(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);
		// end标记最终位置
		int end = 0;
		// max标记最大长度
		int max = 0;
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (dp[i][j] > max) {
					end = i;
					max = dp[i][j];
				}
			}
		}
		// 截取字符串
		return str1.substring(end - max + 1, end + 1);
	}
	
	// 时间复杂度为O(M*N),空间复杂度为O(1)
	public static String lcst2(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int row = 0;
		int col = chs2.length - 1;
		int max = 0;
		int end = 0;
		while (row < chs1.length) {
			int i = row;
			int j = col;
			int len = 0;
			while (i < chs1.length && j < chs2.length) {
				if (chs1[i] != chs2[j]) {
					len = 0;
				} else {
					len++;
				}
				if (len > max) {
					max = len;
					end = i;
				}
				i++;
				j++;
			}
			if (col > 0) {
				col--;
			} else {
				row++;
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}
	public static void main(String[] args) {
		String str1 = "a123b";
		String str2 = "aaa23";
		System.out.println(lcst2(str1, str2));
	}

}
