package offer;

/*牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？*/
public class ReverSentence {
	public static String ReverseSentence(String str) {
		String res = null;       
		// 异常处理
		if (str == null)
			return res;
		if (str == "") {
			str = "";
			return res;
		}
		// 变化为char类型的数组
		char[] chas = str.toCharArray();
		int start = 0;
		int end = chas.length - 1;
		// 首先反转整个字符串
		chas = rever(chas, start, end);
		start = 0;
		end = 0;
		// 进行逐个单词进行反转
		while (start != chas.length) {
			// 各种边界条件的判定
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
		// 异常判断
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
		// 异常判断
		if (str == null || n < 0) {
			return null;
		}
		if (n == 0 || str.equals("")) {
			return str;
		}
		// 首先反转0~n-1
		char[] chas = str.toCharArray();
		chas = rever(chas, 0, n - 1);
		// 其次反转n-chas.length-1
		chas = rever(chas, n, chas.length - 1);
		// 最后反转整个的
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
