package string;

public class CharReplace {
	// 字符串的调整和替换
	// 对中间空格进行替换，如"a b c  d",将" "替换为%20
	// 首先统计空格个数，其次将char数组从后往前进行拓宽
	public static void replace(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;
		for (; len < chas.length && chas[len] != 0; len++) {
			if (chas[len] == ' ') {
				num++;
			}
		}
		int j = len + num * 2 - 1;
		for (int i = len - 1; i > -1; i--) {
			if (chas[i] != ' ') {
				chas[j--] = chas[i]; 
			} else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}
	}
	// 将空格看为*和数字组成，将*全部挪到前面去
	public static void replace1(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int j = chas.length - 1;
		for (int i = chas.length - 1; i > -1; i--) {
			if (chas[i] != '*') {
				chas[j--] = chas[i];
			}
		}
		for (; j > -1; j--) {
			chas[j--] = '*';
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}