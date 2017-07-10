package string;

public class CountString {
	// ����һ���ַ���str,����str��ͳ���ַ���.
	// ����,"aaabbadddffc"��ͳ���ַ���Ϊ��a_3_b_2_a_1_d_3_f_2_c_1��
	public static String getCountString(String str) {
		// �����쳣
		if (str == null || str.equals("")) {
			return null;
		}
		char[] chas = str.toCharArray();
		String res = "";
		int num = 1;
		// ���д����ƴ��
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
