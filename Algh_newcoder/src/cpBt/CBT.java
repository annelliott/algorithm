package cpBt;

import java.util.LinkedList;
import java.util.Queue;

public class CBT {
	public static boolean isBCT(Node head) {
		if (head == null) {
			return false;
		}
		Queue<Node> queue = new LinkedList<Node>();
		// ��ʼʱ����Ҷ�ӽڵ���ڣ���ֻ��ͷ�ڵ���Ϊ���в����������ڵ㣬��ֱ�ӷ���true
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			// ��ǰ�ڵ���ΪҶ�ӽڵ㣬������������Ϊ�ա����򷵻�false��
			// ��ǰ�ڵ������������ڣ�����������������ʱ���򷵻�false��
			if ((leaf && (l != null || r != null)) || (r != null && l == null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		// ���������ֱ�ӷ���true
		return true;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		System.out.println(isBCT(node1));
	}

}
