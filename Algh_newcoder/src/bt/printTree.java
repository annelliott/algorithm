package bt;

public class printTree {
	// ֱ�۴�ӡ������
	public static void printTree(Node head) {
		System.out.println("��������");
		// �������ң����У������˳����д�ӡ�����ñ����ķ���������
		printInorder(head, 0, "H", 17);
		System.out.println();
	}
	public static void printInorder(Node head,int height,String to,int len) {
		if (head == null) {
			return;
		}
		// ��ӡ������
		printInorder(head.right,height + 1,"v",17);
		// �ó��������ַ�
		String val = to + head.value + to;
		// ������в��ո�����
		int strLen = val.length();
		// �������ĳ���leftLen
		int leftLen = (len - strLen) / 2;
		// �����Ҳ�ĳ���rightLen
		int rightLen = len - strLen - leftLen;
		// ���ո���ж�������
		val = getSpace(leftLen) + val + getSpace(rightLen);
		
		// ���ÿ���ӡ��϶������ֵ���
		System.out.println(getSpace(len * height) + val);
		
		//�������  
		printInorder(head.left, height + 1, "^", len);
	}
	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node5.left = node9;
		node5.right = node10;
		node8.right = node11;
		node9.left = node12;
		node11.left = node13;
		node11.right = node14;
		node12.left = node15;
		node12.right = node16;
		printTree(node1);
	}

}
