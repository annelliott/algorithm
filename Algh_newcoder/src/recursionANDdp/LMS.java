package recursionANDdp;
/**
 * ��������Ӵ�����
 * ���������ַ���str1��str2,���������ַ�����������Ӵ�
 * */
public class LMS {
	// dp[i][j]��ָ��i��jΪ��β����Ӵ��ĳ���
	public static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		// ��ʼ��
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
	// �ó���󹫹��Ӵ��ĳ���
	// ʱ�临�Ӷ�ΪO(M*N)���ռ临�Ӷ�ΪO(M*N)
	public static String lcst1(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);
		// end�������λ��
		int end = 0;
		// max�����󳤶�
		int max = 0;
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (dp[i][j] > max) {
					end = i;
					max = dp[i][j];
				}
			}
		}
		// ��ȡ�ַ���
		return str1.substring(end - max + 1, end + 1);
	}
	
	// ʱ�临�Ӷ�ΪO(M*N),�ռ临�Ӷ�ΪO(1)
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
