package string;

	/*�������пյ������в����ַ���
	��һ���ַ�������strs[]�У���strs����Щλ��Ϊnull�����ڲ�Ϊnull��λ���ϡ�
	���ַ����ǰ����ֵ�˳���С�������γ��ֵģ��ָ���һ���ַ���str,�뷵��str��strs��
	���ֵ������λ��*/
public class GetIndex {
	// ����ȷ�����ö��ֲ��ҵķ����������Ҫ���ַ��������ж�
	// 1. ���ַ����м��ַ���Ϊ��ʱ
	// 1.1 ���м��ַ����ڸ��ַ�ʱ����Ǹô�λ��res = mid����right = mid - 1��
	// 1.2 ���м��ַ�С�ڸ��ַ�ʱ����left = mid + 1;
	// 1.3 ���м��ַ����ڸ��ַ�ʱ����right = mid - 1;
	// 2. ���м��ַ�Ϊ��ʱ����������б�����ֱ���ҵ���һ����Ϊ�յġ�
	// 2.1 �����ַ�������λ��С�����߽磬����ַ�С��str����left = mid + 1
	// 2.2 �����ַ�����str,��res���б�ע���������ڣ�����֮ǰ��ֵ��
	// ͬʱright = i - 1
	public static int getIndex(String[] strs, String str) {
		// �����쳣��
		if (strs == null || strs.length == 0 || str == null) {
			return -1;
		}
		// ���б�����ʼ����ȷ���������ֱ�Ϊleft,right,mid��res
		int res = -1;
		int left = 0;
		int right = strs.length - 1;
		int mid = 0;
		int i = 0;
		// ���ú��ж�����
		while (left <= right) {
			mid = (left + right) / 2;
			// ���strs[mid] == str,��ֹ��ָ�룬Ҫ���ж�strs[mid] != null
			if (strs[mid] != null && strs[mid].equals(str)) {
				res = mid;
				right = mid - 1;
			} else if (strs[mid] != null) {
				// �����ж�
				if (strs[mid].compareToIgnoreCase(str) > 0) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// ���б��
				i = mid;
				while (strs[i] == null && --i >= left) 
					;
				// �ж���֮�����Խ����߸�ֵС��str����ȥ����һ���߽�����ж�
				if (i < left || strs[i].compareTo(str) < 0) {
					left = mid + 1;					
				} else {
					// �жϺ�������Ȼ��Ǵ���str����Ҫ����
					res = strs[i].equals(str) ? i : res;
					right = mid - 1;
				}
			}			
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs = new String[5];
		strs[0] = "a";
		strs[1] = "b";
		strs[3] = "c";
		strs[4] = "d";
		String str = "c";
		System.out.println(getIndex(strs, str));
	}

}
