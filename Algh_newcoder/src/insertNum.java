
public class insertNum {
	// �����������в����½ڵ�
	public Node insertNum(Node head,int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		//��¼ǰ�ýڵ�
		Node pre = head;
		Node cur = head.next;
		// �жϲ����
		while (cur != head) {
			if (pre.value <= num && cur.value >= num) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
