package offer;

public class IsNumeric {
	// �ж�����Ĵ��Ƿ�Ϊ����
	public static boolean isNumeric(char[] str) {
		boolean res = true;
		// �쳣�ж�
		if (str == null || str.length == 0) {
			res = false;
			return res;
		}
		int n = str.length;
		int index = 0;
		// �ж��Ƿ�Ϊ����
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		index = scan(str, index);
		if (index < n) {
			// �ж�С�����
			if (str[index] == '.') {
				++index;
				index = scan(str, index);
				if (index < n && (str[index] == 'e' || str[index] == 'E'))
					index = isExp(str, ++index);
			}
			else if (str[index] == 'e' || str[index] == 'E') 
				 index = isExp(str, ++index);
			else 
				res = false;
		}
		return res && (index == str.length);
    }
	public static int isExp(char[] chas, int index) {
		// ע���жϱ߽�
		if (index < chas.length && (chas[index] == '+' || chas[index] == '-'))
			++index;
		if (index == chas.length) 
			return chas.length - 1;
		index = scan(chas, index);
		return index;
	}
	public static int scan(char[] chas, int index) {		
		while (index < chas.length && chas[index] >= '0' && chas[index] <= '9') {
			index++;
		}
		return index;
	}
	public static void main(String[] args) {
		String str2 = "3.1416";
		System.out.println(isNumeric(str2.toCharArray()));
	}

}
