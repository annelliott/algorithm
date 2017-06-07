package recursionANDdp;

// ͳ����С����·���ͣ�ÿ��ֻ�����������ҡ�
// ������Ҫ����˴�ͳ��DP�㷨�Ϳռ�ѹ���㷨��
// ��ͳ��DP��ʱ�临�Ӷ�ΪM*N,����ռ临�Ӷ�ҲΪM*N,�����е������ܹ���¼�߹���·��
// �ռ�ѹ���㷨ʱ�临�ӶȲ��䣬���Ƕ���ռ临�Ӷ�Ϊmin(M,N).ȱ�����ڲ��ܼ�¼���·��
public class minPathSum1 {          
	
	// �����ⷨ��������M�У�N�У�����Ӧ��ʱ�临�Ӷ�ΪO(M*N),����ռ临�Ӷ�ΪO(M*N)
	// ��dp[i][j]��ʾ��(i,j)λ��,��Ӧ�����·��
	
	public static int minPath1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		// �ó�����������
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		
		// ���г�ʼֵ��ֵ��
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int i = 0; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + m[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = m[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[row - 1][col - 1];
	}
	
	// ���пռ�ѹ����ʱ�临�Ӷ��޷��ı䣬���ռ临�Ӷȸ�ΪO(min{M,N})
	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length); // �ó�����Ǹ���������������
		int less = Math.min(m.length, m[0].length); // �ó�С���Ǹ���������������
		boolean rowmore = more == m.length;         // �ó�����Ǹ������������������������������ѹ������Ĵ�СΪ������
    // ѹ���ķ���Ϊ���ҡ�
		// ��ʼ�����飬��Ϊrowmore,��Ӧ��Ϊ������ͬ����ʼ����Ϊ��һ�С�
		int[] arr = new int[less];
		arr[0] = m[0][0];
		for (int i = 0; i < less; i++) {
			arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
		}
		// ���о���ѹ��
		for (int i = 0; i < more; i++) {
			arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
			for (int j = 0; j < less; j++) {
				arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
			}
		}
		return arr[less - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
