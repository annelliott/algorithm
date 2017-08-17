package offer;

public class NumsAppearOnce {
	// 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
	// 请写程序找出这两个只出现一次的数字。
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	    int num = 0;
		// 异常处理
		if (array == null || array.length < 2) 
			return;
		
		// 进行第一遍遍历，找出两个不一样的词异或的结果
		for (int i = 0; i < array.length; i++) {
			num ^= array[i];
		}
		
		// 异或结果得到后，将离个位最近的一个是1的那位找出来,记为count
		int count = 0;
		while ((num & 1) == 0) {
			num = num >> 1;
			++count;
		}
		
		// array数组中的数第count位存在两种情况，为0 或为1.共计两种情况,除了两个特定数，
		// 其他的都是异或为0，因为他们是成对出现的。
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
	
	// 检测第count位为0还是为1
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