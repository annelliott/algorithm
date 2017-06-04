package cpBt;

import java.util.ArrayList;
import java.util.LinkedList;

public class MorrisIn {
	// �ж��Ƿ�Ϊ����������
	public static ArrayList<Integer> isBST(Node head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (head == null) {
			System.out.println("Empty Tree");
			return null;
		}
		Node cur1 = head;
		Node cur2 = null;
		// ����ͷ�ڵ�����ж�
		while (cur1 != null) {
			// cur2Ϊcur1��������
			cur2 = cur1.left;
			// ��cur2��Ϊ��ʱ��������������
			if (cur2 != null) {
				// ��cur2����������Ϊ�գ��Ҳ�Ϊ���ڵ�ʱ
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;					
				}
				// ��һ�α����������������ҽڵ㡣
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					// ���������ҽڵ�
					cur2.right = null;
				}
			}
			// ��cur1������Ҷ�ӽڵ�ʱ���Ὣcur1��ֵ���
			list.add(cur1.value);
			// ������cur1���ҽڵ�
			cur1 = cur1.right;
		}
		return list;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node4.left = node5;
		ArrayList<Integer> list = isBST(node1);
		int count = 1;
		while (count < list.size()) {
			if (list.get(count) < list.get(count-1)) {
				System.out.println("false");
				break;
			}
			count++;
		}
		System.out.println("end!!!");
	}

}
