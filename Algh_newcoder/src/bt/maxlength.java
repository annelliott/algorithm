package bt;

public class maxlength {
	public static int getMaxLength(Node head) {
		int[] record = new int [1];
		return posOrder(head, record);
	}
	public static int posOrder(Node head, int[] record) {
		// ��������Ҷ�ӽڵ㣬����Ӧ��record�����ȼ�¼Ϊ0��ͬʱ��ʱΪ��͵㣬������¼Ϊ0
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		// ���������������ص�ǰ�ڵ��������µ����ڵ���
		int lmax = posOrder(head.left, record);
		// ���ص�ǰ���ڵ����������������� 
		int maxFromLeft = record[0];
		int rmax = posOrder(head.right, record);
		int maxFromRight = record[0];
		// ��¼��ǰ�ڵ������������+1�����ڵ���
		int curNodeMax = maxFromLeft + maxFromRight + 1;
		// ��ͷ��β��ÿ���߶�ֻ��ȡһ����
		record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
		// ��¼���ڵ����������ء�
		// �������ڵ���������������࣬���������͵�ǰ������ڵ���������
		return Math.max(Math.max(lmax, rmax), curNodeMax);
	}
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n4.left = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		System.out.println(getMaxLength(n1));
	}
}