package offer;
	/*��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ���
	�������ж���䣨A?B:C��*/
public class Sum {
	public static int Sum_Solution(int n) {    
		return (n > 0) ? n + Sum_Solution(n - 1) : 0;
    }
	public static void main(String[] args) {
		System.out.println(Sum_Solution(3));
	}
}
