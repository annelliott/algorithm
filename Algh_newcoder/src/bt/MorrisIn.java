package bt;

public class MorrisIn {
	// ʱ�临�Ӷ�O(n)������ռ临�Ӷ�O(1)
	public static void morrriIn(Node head) {
		if (head == null || head.left == null && head.right == null) 
			return;
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			// �ж��������Ƿ���ڣ������ڣ��������������
			cur2 = cur1.left;
			// ���������������ҽڵ�
		    if (cur2 != null) {
		    	// �������ұ�����ǰ��cur1�ڵ�Ϊͷ�ڵ����������ֱ�����ҽڵ��ҵ���
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;					
				}
				
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					// ��Ѱ��һ���ڵ㣬�������ҽڵ�
					continue;
				} else {
					cur2.right = null;
				}
			}
		    // �������ڵ�������Ǻ��������ǰ��
		    System.out.println(cur1.value);
		    // ��ൽͷ�����ҷ����м估���漰ͷ�ڵ�
		    cur1 = cur1.right;
		}
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		morrriIn(node1);
	} 
}