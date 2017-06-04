import java.util.Stack;

public class reverseKNode {
	// ����ջ�ṹ��ʵ��K���ڵ������
	public Node reverseKNode1(Node head,int k) {
		if (k < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		// ��Ҫ���ص���newHead
		Node newHead = head;
		Node cur = head;
		Node pre = null;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == k) {
				pre = resign(stack,pre,next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	// ��ջ�е��������½��з���
	public Node resign(Stack<Node> stack,Node left,Node right) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
	// �ڲ���������½���ÿK�����������
	public Node reverseKNode2(Node head,int k) {
		// ���ص�ͷ�ڵ�newHead
		if (k < 2) {
			return head;
		}
		Node pre = null;
		Node newHead = head;
		Node start = null;
		Node cur = head;
		Node next = null;
		int count = 1;
		while (cur != null) {
			next = cur.next;
			// ���ﵽ��K���ڵ�ʱ����ת��β�ڵ�
			if (count == k) {
				start = pre == null ? head : pre.next;
				newHead = pre == null ? cur : newHead;
				// ���¶�K���ڵ����β���й滮
				resign2(pre,start,cur,next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;			
		}
		return newHead;
	}
	public void resign2(Node left,Node start,Node end,Node right) {
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		// ����ڲ��ڵ�ķ�ת
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;			
		}
		// ����ǰ���ڵ�
		if (left != null) {
			left.next = end;
		}
		// ���Ӻ󲿽ڵ�
		start.next = right;
	}
	public static void main(String[] args) {
		
	}

}
