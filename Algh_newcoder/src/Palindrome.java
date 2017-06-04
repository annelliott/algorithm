import java.util.Stack;


public class Palindrome {
	public boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		//һ��ƽ�֣��ֳ��ұߵĵ�һ��ֵ
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		// ���ұߵ�ֵ����
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		// ���������ߵ�ֵ���бȶԣ����в�ͬ�ģ��򷵻�false
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}			
			head = head.next;
		}
		return true;
	}
	public static boolean isPalindromeNew(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		//��������
		Node n1 = head;
		Node n2 = head;
		while (n2.next != null && n2.next.next != null) {
			n1 = n1.next;      // �в�
			n2 = n2.next.next; // �ֳ���β
		}
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while (n2 != null) {  // �Ұ�����ת
			n3 = n2.next;
			n2.next = n1;
			n1 = n2; // n1�ƶ�
			n2 = n3; // n2�ƶ�
		}
		//���бȶ�
		n3 = n1; // ת�����ұ�
		n2 = head; // ת�������
		boolean res = true;
		while (n1 != null && n2 != null) {
			if (n1.value != n2.value) {
				res = false;
				break;
			}			
			n1 = n1.next; // ����ߵ��в�
			n2 = n2.next; // ���ұߵ��в�
		}
		n1 = n3.next;//�ָ�ԭ������״
		n3.next = null;
		while (n1 != null) {
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		boolean res = isPalindromeNew(node1);
		System.out.println(res);
	}
}
