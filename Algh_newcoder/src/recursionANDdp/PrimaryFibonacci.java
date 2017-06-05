package recursionANDdp;

	// 쳲��������е���ʽ��f(n) = f(n-1) + f(n-2)
	// ���׵��ƹ�ʽ����ת��Ϊ״̬������Բ�����
	// 쳲��������п��Ա�ʾΪ{1,1;1,0}
public class PrimaryFibonacci {
	// 쳲��������б����ⷨ������ÿ��f(n)��Ҫ������,ʱ�临�Ӷ�ΪO(N^2)
	public static int f1(int n) {
		// ���ȴ����쳣
		if (n < 1) {
			return 0;
		}
		// ��δ����ʼֵ
		if (n == 1 || n == 2) {
			return 1;
		}
		return f1(n-1) + f1(n-2);
	}
	// �����ⷨ���ֱ����f(n-1)��f(n-2),Ȼ���ǰ������,ʱ�临�Ӷ�ΪO(n)
	public static int f2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int fn1 = 1;
		int fn2 = 1;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = fn1 + fn2;
			fn2 = fn1;
			fn1 = res;
		}
		return res;
	}        
	// ͨ������ķ��������ټ������������n�γ˷�����ʵ���ǿ���ͨ��log(n)�ó���
	// 1. ����һ��������10,����������10��75�η�
	// 2. 10��75�η�=10^64 * 10^8 * 10^2 * 10^1,����������У�����10^1���10^2,
	//    �������10^64.��֮,75�Ķ�������ʽ�ܹ��ж���λ�����Ǿ�ʹ���˶��ٴγ˷�
	// 3. 64,8,2,1��Щλ��Ϊ1,��������������.����λ��Ϊ0,��������������㡣
	
	// ���Ƚ��о���˷��ļ���
	public static int[][] matrixPower(int[][] m, int p) {
		// ���ȳ�ʼ���������
		int[][] res = new int[m.length][m[0].length];
		// �Ȱѽ�������ʼ��Ϊ��λ����,�൱�������е�1
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		// mΪ���˵ľ���res�����0λ����ǰλ�ľ���
		int[][] tmp = m;
		for (; p != 0; p = (p >> 1)) {
			if ((p & 1) != 0) {
				res = muliMatrix(res, tmp);
			}
			// tmp�洢��ǰλ��Ӧ��m��2�ı�����
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}
	// ������˷���
	public static int[][] muliMatrix(int [][] m1, int[][] m2) {
		// ��һ��������г��Եڶ����������
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
	// �þ���˷����쳲��������е�N���ȫ������
	public static int f3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n - 2);
		// res[0][0]��ʾ
		return res[0][0] + res[1][0];
	}
	public static void main(String[] args) {
		System.out.println(f3(4));
	}
}
