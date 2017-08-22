package offer;

public class StringToInt {
	public static void rever(char[] chas) {
		int right = chas.length - 1;
		int left = 0;
		char tmp = ' ';
		while (left < right) {
			tmp = chas[left];
			chas[left++] = chas[right];
			chas[right--] = tmp;
		}
	}
	/*将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
	数值为0或者字符串不是一个合法的数值则返回0*/
	public static int StrToInt(String str) {
		int res = 0;
        if (str == null || str.length() < 1) 
			return res;
        char[] chas = str.toCharArray();
        rever(chas);
        int n = chas.length;
        if (n == 1) {
        	if (chas[0] < '0' || chas[0] > '9') {
				return res;
			} else {
				res = chas[0] - '0';
				return res;
			}
		} 
        int[] arr;
        // 对最后一位进行判断，从而决定问题
        if (chas[n -1] == '-' || chas[n - 1] == '+') {
			arr = new int[n - 1];
		} else if (chas[n - 1] >= 0 && chas[n - 1] <= '9') {
			arr = new int[n];
		} else {
			return res;
		}
        // 进行遍历存储
        for (int i = 0; i < arr.length; i++) {
			arr[i] = chas[i] - '0';
			if (arr[i] < 0 || arr[i] > 9) {
				res = 0;
				return res;
			}
			int cur = (int)Math.pow(10, i);
			res += cur * arr[i];
		}
        if (n == arr.length || chas[n -1] == '+') {
			return res;
		} else {
			return -res;
		}
    }
	public static void main(String[] args) {
		/*String str1 = "123";
		System.out.println(StrToInt(str1) == 123);
		String str2 = "-123";
		System.out.println(StrToInt(str2) == -123);
		String strErr1 = "";
		System.out.println(StrToInt(strErr1) == 0);
		String strErr2 = "-";
		System.out.println(StrToInt(strErr2) == 0);
		String strErr3 = null;
		System.out.println(StrToInt(strErr3) == 0);*/
		String strErr4 = "+123";
		System.out.println(StrToInt(strErr4));
		
	}

}
