package recursionANDdp;

	// 最长递增子序列，arr = [2,1,5,3,6,4,8,9,7]
	// 则返回的最长递增子序列为[1,3,4,8,9]
public class LIS {
	//  主方法,时间复杂度为O(n^2)
	public static int[] lis1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);
	}
	public static int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}
	
	// 已经得出最优的情况下，如何重新得出圆满的数组
	public static int[] generateLIS(int[] arr,int[] dp) {
		// 记录最长递增子数组长度
		int len = 0;
		// 维护结尾
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index; i > -1; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}
	
	/** 利用数组ends和right变量来进行维护
	 * 同时在对dp数组进行更新时，使用相应的ends数组来进行
	 * 时间复杂度为O(NLOG(N)),使用了二分查找  
	 * */
	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int m = 0;
		int r = 0;
		for (int i = 0; i < arr.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				if (arr[i] > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}
	// 将时间复杂度降为O(nlog(n))
	public static int[] lis2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp2(arr);
		return generateLIS(arr, dp);
	}
	public static void main(String[] args) {
		int[] arr = {2,1,5,3,6,4,8,9,7};
		int[] res = lis2(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
