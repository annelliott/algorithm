package array;

	/*���1-N��1���ֵĴ��������磬��N����18ʱ��1���ֵĴ���Ϊ2 + 9 = 11
         ��λ������1��Ϊ��1��11��ʮλ������1��Ϊ10-18*/
public class OneNoInN {
	// �����ⷨ
	public static int solution1(int num) {
		// �쳣����
		if (num < 1) 
			return 0;
		// ��Ǳ���count
		int count = 0;
		// ����û�����е�1�ĸ�����Ȼ���������ʱ�临�Ӷ�ΪO(nlogn)
		for (int i = 1; i < num + 1; i++) {
			count += get1Num(i);
		}
		return count;
	}
	public static int get1Num(int num) {
		int res = 0;
		while (num != 0) {
			if (num % 10 == 1) {
				res++;
			}
			num /= 10;			
		}
		return res;
	}
	
	// �ڶ��ַ��������з���
	// ���������
	// ��һ����������λΪ1,1-114�����Ȼ���Ϊ1-14��15-114��
	// ��λΪ1������Ӧ�Ķ�Ӧ��1�ĸ���Ϊnum % tmp1 + 1.��114 % 100 + 1 = 15
	// ʮλΪ1ʱ���� 15 - 19 ����110 - 114��
	// ��λΪ1ʱ����21-91��101��111��
	// ���Ӧ��1�ĸ���Ϊ1 * (3 - 1) * (100 / 10) 
	// �ڶ�������� ���λ����1�������λ�����Ϊtmp1��������λ���������
	public static int solution2(int num) {
		// �쳣����
		if (num < 1)
			return 0;
		// �ó���ǰ�ַ��ĳ���
		int len = getLenOfNum(num);
		// �����жϣ������ǰ�ַ�����Ϊ1���򷵻�1
		if (len == 1) 
			return 1;
		// ��¼��ǰ���ֵһ��������һ����
		int tmp = powBase10(len - 1);
		// �õ����λ��ֵ
		int first = num / tmp;
		int firstOneNum = first == 1 ? num % tmp + 1 : tmp;
		int otherOneNum = first * (len - 1) * (tmp / 10);
		return firstOneNum + otherOneNum + solution1(num % tmp); 
	}
	
	// �ó���ǰ��ֵ��λ��
	public static int getLenOfNum(int num) {
		int len = 0;
		while (num != 0) {
			len++;
			num /= 10;
		}
		return len;
	}
	
	// ��һ��ָ����ֵ
	public static int powBase10(int base) {
		return (int) Math.pow(10, base);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
