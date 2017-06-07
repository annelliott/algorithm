package recursionANDdp;

public class minCoins {

	/**
	 * Elliott Su
	 * ����Ǯ��������arr = [2,3,5],aim = 20
	 * δ�����ռ�ѹ��֮ǰ��ʱ�临�ӶȺͿռ临�Ӷȶ�ΪO(N*aim)
	 */
	public static int minCoins(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		// dp[i][j] ��ʾ��������ʹ��arr[0-i]�е�Ǯ�ң��ﵽj��Ŀ��Ǯ
		int[][] dp = new int[n][aim + 1];
		// ���г�ʼ��,��ζ��������Ա�arr[0]����������б�ʾ
		for (int j = 1; j <= aim; j++) {
			// ���˿���������,����Ŀ��Ա�ʾΪmax
			dp[0][j] = max;
			if (j- arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		// ������Ӧ�ĸ�ֵ���㡣dp[i][j]��arr[0...i]�е�����ֵ���л�����ϣ��ϳ�j
		// dp[i][j]����Ϊdp[i][j-arr[i]] + 1 �� dp[i - 1][j]��ɣ�ѡ������
		// ��С��ֵ
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= aim; j++) {
				// ���ֵΪmax
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}
	
	/** ���пռ�ѹ��
	 * 	ʱ�临�Ӷ�ΪO(aim * N)
	 * 	�ռ临�Ӷ�ΪO(min(aim)),������Ϊ������������,
	 * 	ֻ��dp[i][j] = min(dp[i-1][j],dp[i][j-arr[i]]+1)
	 * 	����һ�еľ���,�����ɸ���max(arr[i])���о�������Ҫ����������Ҫ֪��max(arr[i]) * N����
	 * */
	
	public static int minCoin2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		// ���и���
		int[] dp = new int[aim + 1];
		// ���г�ʼֵ�ĸ�ֵ
		for (int i = 1; i <= aim; i++) {
			dp[i] = max;
			if (i - arr[0] >= 0 && dp[i - arr[0]] != max) {
				dp[i] = dp[i - arr[0]] + 1;
			}
		}
		int left = 0;
		// ȡ��Сֵ����������
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				// ���н��л���
				if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
					left = dp[j - arr[i]] + 1;
				}
				// ��֮ǰ��dp��left��������
				dp[j] = Math.min(left, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}	
	public static void main(String[] args) {
		int[] arr = {2,3,5};
		System.out.println(minCoin2(arr, 20));

	}

}
