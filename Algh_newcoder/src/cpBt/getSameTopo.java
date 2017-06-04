package cpBt;
// ֻ�ܲ�����������������ֲܷ㡣
public class getSameTopo {
	public static boolean isSubtree(Node h1, Node h2) {
		String t1Str = serialByPre(h1);
		String t2Str = serialByPre(h2);
		// ����ƥ�䣬��ֵ��Ϊ-1,����Ϊ-1
		return getIndexOf(t1Str, t2Str) != -1;
	}
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res = res + serialByPre(head.left);
		res = res + serialByPre(head.right);
		return res;
	}
	// KMP�㷨
	public static int getIndexOf(String s, String m) { 
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		// ת��Ϊ�ַ�������
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		// �ó���Ӧ��next���顣
		int[] next = getNextArray(ms);
		// �ƶ�ֱ�����ĶԱ����
		while (si < ss.length && mi < ms.length) {
			// �������ַ���ȣ�����Ӧ���±궼��ǰ�ƶ�һλ
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if(next[mi] == -1) { // ����һλ�ԱȲ��ȣ���ԱȵĴ�ǰ��һλ�� 
				si++;
			} else {
				mi = next[mi]; // ���Աȵ�ֵ��ͬ���򷵻�ģʽ����nextλ��ֵ��
			}
		}
		return mi == ms.length ? si - mi : -1;
	}
	// ���next����
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			int[] res = new int[] {-1};
			return res;
		}
		int[] next = new int[ms.length];
		// ��ʼֵ���á�
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn; // ����pos����һ��֮��
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		Node m1 = new Node(2);
		Node m2 = new Node(4);
		Node m3 = new Node(5);
		m1.left = m2;
		m1.right = m3;
		System.out.println(isSubtree(n1, m3));
	}
}
