package offer;

/*��ʵ��һ����������ƥ�����'.'��'*'���������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��*/
public class StrMat {
	public static boolean match(char[] str, char[] pattern)
    {
		// �쳣����  
		boolean res = false;
        if (str == null ||pattern == null) {
			return res;
		}
        // �����ж�
        res = matchCore(str, 0, pattern, 0);
        return res;
    }
	public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
	    //��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
	    if (strIndex == str.length && patternIndex == pattern.length) {
	        return true;
	    }
	    //pattern�ȵ�β��ƥ��ʧ��
	    if (strIndex != str.length && patternIndex == pattern.length) {
	        return false;
	    }
	    //ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
	    if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
	        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
	            return matchCore(str, strIndex, pattern, patternIndex + 2)//ģʽ����2����Ϊx*ƥ��0���ַ�,��"bbbba",".*a*a"
	                    || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//��Ϊģʽƥ��1���ַ�
	                    || matchCore(str, strIndex + 1, pattern, patternIndex);//*ƥ��1������ƥ��str�е���һ��
	        } else {
	            return matchCore(str, strIndex, pattern, patternIndex + 2);
	        }
	    }
	    //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
	    if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
	        return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
	    }
	    return false;
	}
	public static void main(String[] args) {
		char[] str = {'a'};
		char[] pattern = {'.','*'};
		boolean res = match(str, pattern);
		System.out.println(res);
	}
}