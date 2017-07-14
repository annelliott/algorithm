package string;

public class CharReplace {
	// �ַ����ĵ������滻
	// ���м�ո�����滻����"a b c  d",��" "�滻Ϊ%20
	// ����ͳ�ƿո��������ν�char����Ӻ���ǰ�����ؿ�
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
	// ���ո�Ϊ*��������ɣ���*ȫ��Ų��ǰ��ȥ
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