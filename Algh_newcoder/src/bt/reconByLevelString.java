package bt;

import java.util.LinkedList;
import java.util.Queue;

public class reconByLevelString {
	// �����л�������
	public static Node reconByLevelStringA(String leveStr) {
		// ����洢��������
		String[] values = leveStr.split("!");
		int index = 0;
		Node head = generateNodeByStringNode(values[index++]);
		Queue<Node> queue = new LinkedList<Node>();
		if (head == null) {
			queue.offer(head);
		}
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByStringNode(values[index++]);
			node.right = generateNodeByStringNode(values[index++]);
			if (head.left != null) {
				queue.offer(head.left);
			}
			if (head.right != null) {
				queue.offer(head.right);
			}
		}
		return head;
	}
	public static Node generateNodeByStringNode(String val) {
		if (val.equals("#")) {
			return null;
		}
		// ���ɽڵ�
		return new Node(Integer.valueOf(val));
	}
	public static void main(String[] args) {
		Node head = reconByLevelStringA("1!2!3!#!4!5!6!7!8!9!10!#!#!#!#!#!11!12!#!#!#!13!14!15!16!#!#!#!#!#!#!#!#!");
		System.out.println(head.value);
	}
}