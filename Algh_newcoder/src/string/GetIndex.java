package string;

	/*在有序但有空的数组中查找字符串
	在一个字符串数组strs[]中，在strs的有些位置为null，但在不为null的位置上。
	其字符串是按照字典顺序从小到大依次出现的，现给定一个字符串str,请返回str在strs中
	出现的最左的位置*/
public class GetIndex {
	// 首先确定得用二分查找的方法，其次需要对字符串进行判断
	// 1. 当字符串中间字符不为空时
	// 1.1 当中间字符等于该字符时，标记该处位置res = mid，将right = mid - 1。
	// 1.2 当中间字符小于该字符时，将left = mid + 1;
	// 1.3 当中间字符大于该字符时，将right = mid - 1;
	// 2. 当中间字符为空时不断向左进行遍历，直到找到第一个不为空的。
	// 2.1 若该字符所处的位置小于左侧边界，或该字符小于str，则将left = mid + 1
	// 2.2 若该字符等于str,则将res进行标注，若不等于，则标记之前的值。
	// 同时right = i - 1
	public static int getIndex(String[] strs, String str) {
		// 处理异常，
		if (strs == null || strs.length == 0 || str == null) {
			return -1;
		}
		// 进行变量初始化，确定变量，分别为left,right,mid和res
		int res = -1;
		int left = 0;
		int right = strs.length - 1;
		int mid = 0;
		int i = 0;
		// 设置好判断条件
		while (left <= right) {
			mid = (left + right) / 2;
			// 如果strs[mid] == str,防止空指针，要加判断strs[mid] != null
			if (strs[mid] != null && strs[mid].equals(str)) {
				res = mid;
				right = mid - 1;
			} else if (strs[mid] != null) {
				// 进行判断
				if (strs[mid].compareToIgnoreCase(str) > 0) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// 进行标记
				i = mid;
				while (strs[i] == null && --i >= left) 
					;
				// 判断完之后，如果越界或者该值小于str，则去另外一个边界进行判断
				if (i < left || strs[i].compareTo(str) < 0) {
					left = mid + 1;					
				} else {
					// 判断后，无论相等还是大于str，都要左移
					res = strs[i].equals(str) ? i : res;
					right = mid - 1;
				}
			}			
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs = new String[5];
		strs[0] = "a";
		strs[1] = "b";
		strs[3] = "c";
		strs[4] = "d";
		String str = "c";
		System.out.println(getIndex(strs, str));
	}

}
