
public class nodeMerge {
	public static Node merge(Node head1,Node head2) {
		// ����һ������Ϊ�յ����
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		// ���ó�ͷ�ڵ�
		Node head = head1.value > head2.value ? head2 : head1;
		// ���ó�������������ͷ�ڵ��С���Ǹ�����,����Ϊcur1,����һ������Ϊcur2��
		Node cur1 = head == head1 ? head1 : head2;
		Node cur2 = head == head1 ? head2 : head1;
		// ����ΪС�Ľڵ�
		Node pre = cur1;
		cur1 = cur1.next;
		Node next = null;
		// ����������ϲ�
		while (cur1 != null && cur2 != null) {
			if (cur1.value <= cur2.value) {
				next = cur1.next;
				pre.next = cur1;
				pre = cur1;
				cur1 = next;
			} else {
				next = cur2.next;
				pre.next = cur2;
				pre = cur2;
				cur2 = next;
			}
		}
		// ����ʣ������Ľڵ�
		pre.next = cur1 == null ? cur2 : cur1;
		return head;
	}
	public static void main(String[] args) {
		Node node1 = new Node(0);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(7);
		Node nodea1 = new Node(1);
		Node nodea2 = new Node(3);
		Node nodea3 = new Node(5);
		Node nodea4 = new Node(7);
		Node nodea5 = new Node(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		nodea1.next = nodea2;
		nodea2.next = nodea3;
		nodea3.next = nodea4;
		nodea4.next = nodea5;
		Node cur = merge(node1,nodea1);
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}
	}

}
