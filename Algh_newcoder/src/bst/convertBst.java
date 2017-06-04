package bst;

import java.util.LinkedList;
import java.util.Queue;

public class convertBst {
	//��ת��Ϊ������ͨ������
	public Node convert1(Node head) {
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(head,queue);
		if (queue.isEmpty()) {
			return head;
		}
		head = queue.poll();
		Node pre = head;
		pre.left = null;
		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null; 
		return head;
	}
	public void inOrderToQueue(Node head,Queue<Node> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}
	public Node convert(Node head) {
		if (head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;
	}
	public Node process(Node head) {
		if (head == null) {
			return null;
		}
		Node leftE = process(head.left); // ��߽���
		Node rightE = process(head.right); // �ұ߽���
		Node leftS = leftE == null ? null : leftE.right; // ��߿�ʼ
		Node rightS = rightE == null ? null : rightE.right; // �ұ߿�ʼ
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = head;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightE;
			rightE.left = head;
			rightS.right = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}
}
