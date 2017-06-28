package recursionANDdp;

	// ����������У�arr = [2,1,5,3,6,4,8,9,7]
	// �򷵻ص������������Ϊ[1,3,4,8,9]
public class LIS {
	//  ������,ʱ�临�Ӷ�ΪO(n^2)
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
	
	// �Ѿ��ó����ŵ�����£�������µó�Բ��������
	public static int[] generateLIS(int[] arr,int[] dp) {
		// ��¼����������鳤��
		int len = 0;
		// ά����β
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
	
	/** ��������ends��right����������ά��
	 * ͬʱ�ڶ�dp������и���ʱ��ʹ����Ӧ��ends����������
	 * ʱ�临�Ӷ�ΪO(NLOG(N)),ʹ���˶��ֲ���  
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
	// ��ʱ�临�ӶȽ�ΪO(nlog(n))
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
