package recursionANDdp;

public class minCoins1 {

	/**
	 * @author Elliott Su
	 * 	each element in arr means this coin's number is only.
	 * 	we need to user them represent the nums.
	 */
	
	// �����ⷨ����������Ŀ��֪��arr�����е�Ǯ��һ��ʹ�ã��������ٶ������ʹ����
	// dp[i][j]��ʾʹ��0-i�����е�ֽ��,�ﵽ����jʱ,�����ѵ�����ֽ����.
	// �����Ӧ��ֵ�ɱ�ʾ�ı��ʽΪ��dp[i][j] = min(dp[i - 1][j], 
	// dp[i - 1][j - arr[i]] + 1)
	
	public static int minCoin3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		// ��ʼ���У�aim������Ϊ0�����
		int[][] dp = new int[n][aim + 1];
		// ֻʹ�õ�һ�Ż���ʱ�������������ǵ�ǰ��һ�Ż��ң������dpΪ���ֵ��
		for (int i = 1; i <= aim; i++) {
			dp[0][i] = max;
		}
		// ��ʼֵ��ơ�
		if (arr[0] <= aim) {
			dp[0][arr[0]] = 1;
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
					left = dp[i - 1][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}
	
	 /**
	  * @category �ռ�ѹ��������ѹ�������԰���dp[i-1][j]��dp[i-1][j-arr[i]]+1
	  * 		     ����˼·�����пռ�ѹ�����ɴ˿�֪��dp[i-1][j]�ǰ�����������ѹ���ģ�
	  * 		     �� dp[i-1][j-arr[i]]��Ҫ�ķ�max(arr[i]) * n
	  * */
	
	public static int minCoin4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[aim + 1];
		for (int i = 1; i <= aim; i++) {
			dp[i] = max;
		}
		if (arr[0] <= aim) {
			dp[arr[0]] = 1;
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = aim; j > 0; j--) {
				left = max;
				// Ϊ��֤left = dp[i - 1][j - arr[i]] + 1
				// ��Ҫ����ʼ��
				if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
					left = dp[j - arr[i]] + 1;
				}
				dp[j] = Math.min(left, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(minCoin3(arr,9));

	}

}
