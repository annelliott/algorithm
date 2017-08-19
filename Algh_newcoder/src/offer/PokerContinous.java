package offer;

import java.util.Arrays;
/*���Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,
�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,
������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
�����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�
Ϊ�˷������,�������Ϊ��С����0��*/
public class PokerContinous {
	public static boolean isContinuous(int [] numbers) {
        boolean res = false;
		// �쳣����
		if (numbers == null || numbers.length < 1) {
			return res;
		}
		// ��������
		Arrays.sort(numbers);
		int len = 0;
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (i > 0 && numbers[i - 1] != 0) {
				if (numbers[i - 1] == numbers[i]) {
					return res;
				} else {
					len += numbers[i] - numbers[i - 1] - 1;
				}
			} else if (numbers[i] == 0) {
				count++;
			}
		}
		if (count >= len || count == numbers.length) {
			res = true;
		}
		return res;
    }	
	public static void main(String[] args) {
		int[] arr1 = {0,3,1,6,4};
		int[] arr2 = {4,6,7,0,0};
		int[] arr3 = {0,0,0,0,0};
		System.out.println(isContinuous(arr1));
		System.out.println(isContinuous(arr2));
		System.out.println(isContinuous(arr3));
		String a = "1.1.1.1";
		String[] res = a.split("\\.");
		System.out.println(res);
	}

}
