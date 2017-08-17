package offer;

public class NumsAppearOnce {
	// һ�����������������������֮�⣬���������ֶ����������Ρ�
	// ��д�����ҳ�������ֻ����һ�ε����֡�
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	    int num = 0;
		// �쳣����
		if (array == null || array.length < 2) 
			return;
		
		// ���е�һ��������ҳ�������һ���Ĵ����Ľ��
		for (int i = 0; i < array.length; i++) {
			num ^= array[i];
		}
		
		// ������õ��󣬽����λ�����һ����1����λ�ҳ���,��Ϊcount
		int count = 0;
		while ((num & 1) == 0) {
			num = num >> 1;
			++count;
		}
		
		// array�����е�����countλ�������������Ϊ0 ��Ϊ1.�����������,���������ض�����
		// �����Ķ������Ϊ0����Ϊ�����ǳɶԳ��ֵġ�
		num1[0] = 0;
		num2[0] = 0;
		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i], count) == 1) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}
	
	// ����countλΪ0����Ϊ1
	public static int isBit(int num, int count) {
		num = num >> count;
		return (num & 1);
	}
	public static void main(String[] args) {
		int[] array = {1,2,4,4,3,3};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
	}
}