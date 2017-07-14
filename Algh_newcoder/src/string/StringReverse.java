package string;

public class StringReverse {

	// 进行字符串的反转
	// 例如abcde转化为edcba
	public static void rotateWord(char[] chas) {
		// 判断异常
		if (chas == null || chas.length == 0) {
			return;
		}
		reverse(chas, 0, chas.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < chas.length; i++) {
			// 确定左右边界
			if (chas[i] != ' ') {
				l = i == 0 || chas[i - 1] == ' ' ? i : l;
				r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
			}
			// 调用反转函数进行反转
			if (l != -1 && r != -1) {
				reverse(chas, l, r);
				l = -1;
				r = -1;
			}			
		}
	} 
	// 定义字符串反转方法
	public static void reverse(char[] chas, int left, int right) {
		char temp = ' ';
		while (left < right) {
			temp = chas[left];
			chas[left] = chas[right];
			chas[right] = temp;
			left++;
			right--;
		}
	}	
	// 制定反转的部分，进行部分反转
	// 例如abc改为acb
	public static void rotateWord1(char[] chas, int size) {
		if (chas == null || size <= 0 || size >= chas.length) {
			return;
		}
		reverse(chas, 0, size - 1);
		reverse(chas, size, chas.length - 1);
		reverse(chas, 0, chas.length - 1);
	}
	public static void main(String[] args) {
		String str = "i am a student";
		char[] chas = str.toCharArray();
		rotateWord(chas);
		for (int i = 0; i < chas.length; i++) {
			System.out.print(chas[i]);
		}		
	}
}
