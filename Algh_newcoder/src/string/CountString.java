package string;

public class CountString {
	// 给定一个字符串str,返回str的统计字符串.
	// 例如,"aaabbadddffc"的统计字符串为“a_3_b_2_a_1_d_3_f_2_c_1”
	public static String getCountString(String str) {
		// 处理异常
		if (str == null || str.equals("")) {
			return null;
		}
		char[] chas = str.toCharArray();
		String res = "";
		int num = 1;
		// 进行处理和拼接
		for (int i = 0; i < chas.length; i++) {
			if (i != (chas.length - 1)) {
				if (chas[i] != chas[i + 1]) {
					res = res + String.valueOf(chas[i]) + "_" + String.valueOf(num) + "_";
					num = 1;
				} else {
					num++;
				}
			} else {
				res = res + String.valueOf(chas[i]) + "_" + String.valueOf(num);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "";  
		System.out.println(getCountString(str));
	}

}
