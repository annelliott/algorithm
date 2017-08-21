package offer;

/*ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��*/
public class ReverSentence {
	public static String ReverseSentence(String str) {
		String res = null;       
		// �쳣����
		if (str == null)
			return res;
		if (str == "") {
			str = "";
			return res;
		}
		// �仯Ϊchar���͵�����
		char[] chas = str.toCharArray();
		int start = 0;
		int end = chas.length - 1;
		// ���ȷ�ת�����ַ���
		chas = rever(chas, start, end);
		start = 0;
		end = 0;
		// ����������ʽ��з�ת
		while (start != chas.length) {
			// ���ֱ߽��������ж�
			if (chas[start] == ' ') {
				start++;
				end++;
			} else if(end == chas.length) {
				rever(chas, start, end - 1);
				start = end;
			} else if (chas[end] == ' ') {
				rever(chas, start, end - 1);
				start = ++end;
			} else {
				++end;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(chas);
		res = sb.toString();
		return res;
    }
	public static char[] rever(char[] chas, int start, int end) {
		char tmp = ' ';
		while (start < end) {
			tmp = chas[start];
			chas[start] = chas[end];
			chas[end] = tmp;
			start++;
			end--;
		}
		return chas;
	}
	public static String LeftRotateString1(String str,int n) {
		// �쳣�ж�
		if (str == null || n < 0) {
			return null;
		}
		if (n == 0 || str.equals("")) {
			return str;
		}
        int m = str.length();
		str = str + str;
        str = str.substring(n, m + n);
        return str;
    }
	public static String LeftRotateString(String str,int n) {
		// �쳣�ж�
		if (str == null || n < 0) {
			return null;
		}
		if (n == 0 || str.equals("")) {
			return str;
		}
		// ���ȷ�ת0~n-1
		char[] chas = str.toCharArray();
		chas = rever(chas, 0, n - 1);
		// ��η�תn-chas.length-1
		chas = rever(chas, n, chas.length - 1);
		// ���ת������
		chas = rever(chas, 0, chas.length - 1);
		StringBuilder sb = new StringBuilder();
		sb.append(chas);
		str = sb.toString();
		return str;
	}
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(LeftRotateString(str, 2));
	}
}
