package offer;

import java.util.HashMap;
import java.util.Map;
	/*���ǰ�����ֻ����2,3,5������Ϊ������*/
public class UglyNo {
	public static int GetUglyNumber_Solution(int index) {
		// �쳣����
		if(index <= 0)
			return 0;
		// �ó���С�ĳ�������С�ĵ�һ����1�����������У��±�Ϊ0��Ȼ��ֱ����*2��*3��*5��
		// �������ֱ�Ϊugly_2,ugly_3,ugly_5
		int[] res = new int[index];
		res[0] = 1;
		int ugly_2 = 0;
		int ugly_3 = 0;
		int ugly_5 = 0;
		int i = 1;
		int M = 1;
		while (i < index) {
			int min = Math.min(res[ugly_2] * 2, res[ugly_3] * 3);
			min = Math.min(min, res[ugly_5] * 5);
			res[i] = min;
			while (res[ugly_2] * 2 <= res[i]) 
				++ugly_2;
			while (res[ugly_3] * 3 <= res[i]) 
				++ugly_3;
			while (res[ugly_5] * 5 <= res[i]) 
				++ugly_5;
			i++;
		}
		return res[index - 1];
	}
	public static int FirstNotRepeatingChar(String str) {
		int res = 0;
		if (str == null || str.length() == 0) 
			return res;
		int[] helper = new int[256];
		char[] chas = str.toCharArray();
		for (int i = 0; i < chas.length; i++) {
			int a = chas[i];
			helper[a] = helper[a] + 1;
		}
		for (int i = 0; i < chas.length; i++) {
			int a = chas[i];
			if (helper[a] == 1) {
				res = i + 1;
				break;
			}
		}
        return res;
    }
	public static void main(String[] args) {
		String str = null;
		int res = FirstNotRepeatingChar(str);
		System.out.println(res);
	}

}
