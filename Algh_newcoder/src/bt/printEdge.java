package bt;

public class printEdge {
	public static void printEdge1(Node head) {
		if (head == null) {
			return;
		}
		// �ݹ鷵�����ĸ߶�
		int height = getHeight(head,0);
		// ��ӡedgeMap
		Node[][] edgeMap = new Node[height][2];
		// ����ÿ�������Ԫ�ط���������
		setEdgeMap(head, 0, edgeMap);
		// ��ӡ��߽�
		for (int i = 0; i < edgeMap.length; i++) {
			System.out.println(edgeMap[i][0].value + " ");
		}
		// �������������ӡҶ�ӽڵ�
		printLeafNode(head, 0, edgeMap);
		// ��ӡ�ұ߽�
		for (int i = edgeMap.length - 1; i >= 0; i--) {
			System.out.println(edgeMap[i][1].value + " ");
		}
		System.out.println();
	}
	public static int getHeight(Node head,int i){
		if (head == null) {
			return i;
		}
		// �ݹ鷵�����ҽڵ�����
		return Math.max(getHeight(head.left,i + 1), getHeight(head.right,i + 1));
	}
	// ����ÿ�������Ԫ�ط���������
	public static void setEdgeMap(Node head,int l,Node[][] edgeMap) {
		if (head == null) 
			return;
		edgeMap[l][0] = edgeMap[l][0] == null ? head : edgeMap[l][0];
		edgeMap[l][1] = head;
		setEdgeMap(head.left, l + 1, edgeMap);
		setEdgeMap(head.right, l + 1, edgeMap);
	}
	// �������������ӡҶ�ӽڵ�
	public static void printLeafNode(Node head,int l,Node[][] edgeMap){
		if (head == null) {
			return;
		}
		if (head.left == null && head.right == null && head != edgeMap[l][0] && head != edgeMap[l][1]) {
			System.out.println(head.value + " ");
		}
		printLeafNode(head.left, l + 1, edgeMap);
		printLeafNode(head.right, l + 1, edgeMap);
	}
	// ���ձ�׼�����д�ӡ
	public static void printEdge2(Node head) {
		if (head == null) 
			return;
		System.out.println(head.value + " ");
		if (head.left != null && head.right != null) {
			// ��ӡ���������еı߽�ڵ�
			printLeftLeafNode1(head.left,true);
			printRightLeafNode1(head.right,true);
		} else {
			// δ�ҵ�ͷ�ڵ�֮ǰ
			printEdge2(head.left != null ? head.left : head.right);
		}
		System.out.println();
	}
	// ��ӡ������
	public static void printLeftLeafNode1(Node head,boolean print) {
		if (head == null) 
			return;
		// ������Ѱ���ҽڵ�,��������������ӡ��Ҷ�ӽڵ�
		printLeftLeafNode1(head.left, print);
		// �Ѿ���Ѱ������ڵ㽫print����Ϊfalse,ֻ��Ҷ�ӽڵ���ұ߽�·���ϵ����ֿ��Դ�ӡ����
		printLeftLeafNode1(head.right, print && head.left == null ? true : false);
		if (print || head.left == null && head.right == null) {
			System.out.println(head.value + " ");
		}
	}
	public static void printRightLeafNode1(Node head,boolean print) {
		if (head == null)
			return;
		if (print || head.left == null && head.right == null) {
			System.out.println(head.value + " ");
		}
		//������Ѱ���ҽڵ�
		printRightLeafNode1(head.left,print && head.right == null ? true : false);
		printRightLeafNode1(head.right, print);
		
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
		printEdge2(node1);
	}

}
