package string;

import java.util.HashMap;

public class ArrayNoApartHalf {

	public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
			return 0;
		}
        int half = array.length / 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				int val = map.get(array[i]);
				++val;
				if (val > half) {
					return array[i];
				}
				map.put(array[i], val);
			} else {
				map.put(array[i], 1);
				if (half == 0) {
					return array[i];
				}
			}
		}
        return 0;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {2};
		int res = MoreThanHalfNum_Solution(arr);
		System.out.println(res);
	}

}
