package string;

	// ����һ���ַ������ж����е������ַ��Ƿ�ֻ������һ�Σ�
	// ���ǣ��򷵻�true,���򷵻�false
public class WordOnce {
	// ��򵥵ķ�����ʱ�临�Ӷ�ΪO(n)
	public static boolean isUnique1(char[] chas) {
		if (chas == null) {
			return true;
		}
		// ��ASCII�����Ӧ��ֵ���洢��ȥ
		boolean[] map = new boolean[256];
		for (int i = 0; i < chas.length; i++) {
			// ���ж���ȷǰ���ж��Ƿ����
			if (map[chas[i]]) {
				return false;
			}
			// ��һ�β���Ļ�������Ϊtrue
			map[chas[i]] = true;
		}
		return true;
	}
	// Ҫ�����ռ临�Ӷ�ΪO(1)��ʱ�临�Ӷ�Խ��Խ��
	public static boolean isUnique2(char[] chas) {
		// �ع˸��������㷨��ʱ�临�ӶȺͶ���ռ临�Ӷȣ�����ֻ�ж�����ȽϷ���Ҫ��
		if (chas == null) {
			return true;
		}
		heapSort(chas);
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == chas[i - 1]) {
				return false;
			}
		}
		return true;
	}
	// ���ж�����
	public static void heapSort(char[] chas) {
		for(int i = 0; i < chas.length; i++) {
			// �������
			heapInsert(chas, i);
		}
		for (int i = chas.length - 1; i > 0; i--) {
			// �������ֵ�͸��ڵ�
			char temp = chas[0];
			chas[0] = chas[i];
			chas[i] = temp;
			heapify(chas, 0, i);
		}
	}
	// �������
	public static void heapInsert(char[] chas, int i) {
		int parent = 0;		
		while (i != 0) {
			parent = (i - 1) / 2;
			if (chas[parent] < chas[i]) {
				char temp = chas[parent];
				chas[parent] = chas[i];
				chas[i] = temp;
				i = parent;
			} else {
				break;
			}			
		}
	}
	// ���жѵ���
	public static void heapify(char[] chas, int i, int size) {
		// Ҷ�ӽڵ�
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;
		while (left < size) {
			if (chas[left] > chas[i]) {
				largest = left;
			}			
			if (right < size && chas[right] > chas[right]) {
				largest = right;
			}
			if (largest != i) {
				char temp = chas[i];
				chas[i] = chas[largest];
				chas[largest] = temp;
			} else {
				break;
			}
			i = largest;
			left = i * 2 + 1;
			right = i * 2 + 2;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chas = {'a','b','a'};
		System.out.println(isUnique2(chas));
	}

}
