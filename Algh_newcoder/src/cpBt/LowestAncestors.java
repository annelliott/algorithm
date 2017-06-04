package cpBt;

import java.util.HashMap;

public class LowestAncestors {
	// �������е�����Ŀ��ڵ�o1��o2��
	public Node lowestAncestor(Node head, Node o1, Node o2) {
		// ����ǰ�ڵ�Ϊ�ջ����֮��������o1��o2�е�ĳһ��ֵ�����䷵��
		if (head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		// ��o1��o2������֮���򷵻ظ��ڵ㡣
		if (left != null && right != null) {
			return head;
		}
		// ��ֻ����������������֮һ�����ˣ��������߶�û����ʱ�����������
		return left != null ? left : right;
	}
	// ͨ����hashmap��������
    public void Record1(Node head) {
    	HashMap<Node, Node> map = new HashMap<Node, Node>();
    	if (head != null) {
			map.put(head, null);
		}
    	
    }
    
}
