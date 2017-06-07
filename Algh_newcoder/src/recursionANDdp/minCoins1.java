package recursionANDdp;

public class minCoins1 {

	/**
	 * @author Elliott Su
	 * 	each element in arr means this coin's number is only.
	 * 	we need to user them represent the nums.
	 */
	
	// 暴力解法，分析该题目可知，arr数组中的钱币一旦使用，均不能再对其进行使用了
	// dp[i][j]表示使用0-i中所有的纸币,达到基数j时,所花费的最少纸币数.
	// 因此相应的值可表示的表达式为：dp[i][j] = min(dp[i - 1][j], 
	// dp[i - 1][j - arr[i]] + 1)
	
	public static int minCoin3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		// 初始化中，aim考虑了为0的情况
		int[][] dp = new int[n][aim + 1];
		// 只使用第一张货币时，则除了需求的是当前第一张货币，其余的dp为最大值。
		for (int i = 1; i <= aim; i++) {
			dp[0][i] = max;
		}
		// 初始值设计。
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
	  * @category 空间压缩，矩阵压缩。可以按照dp[i-1][j]和dp[i-1][j-arr[i]]+1
	  * 		     两个思路来进行空间压缩。由此可知，dp[i-1][j]是按照行来进行压缩的；
	  * 		     而 dp[i-1][j-arr[i]]需要耗费max(arr[i]) * n
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
				// 为保证left = dp[i - 1][j - arr[i]] + 1
				// 需要逆序开始。
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
