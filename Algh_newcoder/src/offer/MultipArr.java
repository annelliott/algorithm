package offer;

public class MultipArr {
	/*����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
	����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����*/
	// �ֽ�Ϊǰ�������֣���ΪB��C��B��0�� = 1��B��i�� = A[i] 
	public static int[] multiply(int[] A) { 
		if (A == null || A.length < 2) 
			return null;
		int n = A.length;
		int[] res = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		B[0] = 1;
		C[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		for (int i = n - 2; i > -1; i--) {
			C[i] = C[i + 1] * A[i + 1]; 
		}
		for (int i = 0; i < n; i++) {
			res[i] = B[i] * C[i];
		}
		return res;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] res = multiply(A);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
