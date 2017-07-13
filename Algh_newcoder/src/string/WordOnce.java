package string;

	// 给定一个字符串，判断其中的所有字符是否都只出现了一次，
	// 若是，则返回true,否则返回false
public class WordOnce {
	// 最简单的方法，时间复杂度为O(n)
	public static boolean isUnique1(char[] chas) {
		if (chas == null) {
			return true;
		}
		// 把ASCII编码对应的值都存储进去
		boolean[] map = new boolean[256];
		for (int i = 0; i < chas.length; i++) {
			// 在判断正确前先判定是否存在
			if (map[chas[i]]) {
				return false;
			}
			// 第一次插入的话，则判为true
			map[chas[i]] = true;
		}
		return true;
	}
	// 要求额外空间复杂度为O(1)，时间复杂度越低越好
	public static boolean isUnique2(char[] chas) {
		// 回顾各种排序算法的时间复杂度和额外空间复杂度，发现只有堆排序比较符合要求
		if (chas == null) {
			return true;
		}
		heapSort(chas);
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == chas[i - 1]) {
				return false;
			}
		}
		return true;
	}
	// 进行堆排序
	public static void heapSort(char[] chas) {
		for(int i = 0; i < chas.length; i++) {
			// 建大根堆
			heapInsert(chas, i);
		}
		for (int i = chas.length - 1; i > 0; i--) {
			// 交换最大值和根节点
			char temp = chas[0];
			chas[0] = chas[i];
			chas[i] = temp;
			heapify(chas, 0, i);
		}
	}
	// 建大根堆
	public static void heapInsert(char[] chas, int i) {
		int parent = 0;		
		while (i != 0) {
			parent = (i - 1) / 2;
			if (chas[parent] < chas[i]) {
				char temp = chas[parent];
				chas[parent] = chas[i];
				chas[i] = temp;
				i = parent;
			} else {
				break;
			}			
		}
	}
	// 进行堆调整
	public static void heapify(char[] chas, int i, int size) {
		// 叶子节点
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;
		while (left < size) {
			if (chas[left] > chas[i]) {
				largest = left;
			}			
			if (right < size && chas[right] > chas[right]) {
				largest = right;
			}
			if (largest != i) {
				char temp = chas[i];
				chas[i] = chas[largest];
				chas[largest] = temp;
			} else {
				break;
			}
			i = largest;
			left = i * 2 + 1;
			right = i * 2 + 2;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chas = {'a','b','a'};
		System.out.println(isUnique2(chas));
	}

}
