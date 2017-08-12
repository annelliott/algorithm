package string;

public class MoreThanHalfNum {

	/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
	超过数组长度的一半，因此输出2。如果不存在则输出0。*/
	
	// 第一种解法，基于partition函数来进行查找。如果一个数超过一半
	// 则这个数肯定位于排序后的数中间。
	public static int MoreThanHalfNum_Solution(int [] array) {
        // 异常处理
		if(array.length == 0 || array == null)
			return 0;
		// 利用快排的中间参数来求得中位数
		int mid = array.length >> 1;
		int start = 0;
		int end = array.length - 1;
		int index = Partition(array, 0, end);
		while (index != mid) {
			if (index > mid) {
				end = index - 1;
				index = Partition(array, start, end);
			} else {
				start = index + 1;
				index = Partition(array, start, end);
			}			
		}
		// 如果存在，得到理论上的值
		int result = array[mid];		
		// 得到这个值的时候，进一步判断
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				++count;
			}
		}
		if (count > array.length / 2) {
			return result;
		} else {
			return 0;
		}
    }
	
	// 来求得划分函数
	public static int Partition(int[] array, int start, int end) {
		int small = start - 1;
		int big = end + 1;
		int index = start;
		int target = array[start];
		while (index < big) {
			if (array[index] < target) {
				++small;
				int tmp = array[small];
				array[small] = array[index];
				array[index] = tmp;
				++index;				
			} else if(array[index] == target) {
				++index;
			} else {
				--big;
				int tmp = array[big];
				array[big] = array[index];
				array[index] = tmp;
			}
		}
		return index - 1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,1,3,2,3};
		int res = MoreThanHalfNum_Solution(arr);
		System.out.println(res);
	}

}
