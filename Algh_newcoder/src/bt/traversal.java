package bt;
import java.util.Stack;
public class traversal {
	public static void preTraversal(Node head) { // �������
		System.out.println("preOrderTraversal");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			// �Ⱥ��������ڵ�
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	public static void inTraversal(Node head) { // �������
		System.out.println("inTraversal");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head !=  null) {
				if (head != null) {
					// ѹ��һ����ߵĵ�
					stack.push(head);
					head = head.left;
				} else {
					// ������ǰջ����
					head = stack.pop();
					System.out.println(head.value + " ");
					// ѹ���ұߵĶ���
					head = head.right;
				}
			}
		}
		System.out.println();
	} 
	// ʹ������ջ���ȷŽ�ͷ�ڵ㣬Ȼ���׳���s2��Ȼ��s1ѹ��head�����ҽڵ�
	public void posOrderTraversal1(Node head) {
		System.out.println("pos-order");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.println(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	// ���������ֻ��һ��ջʵ�ֺ������
	public void posOrderTraversal2(Node h) {
		System.out.println("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) { // ������δ��ӡ
					stack.push(c.left);
				} else if (c.right != null && h != c.right) { // ������δ��ӡ
					stack.push(c.right);
				} else { // �����������Ѵ�ӡ��ϣ���һ����ӡc
					System.out.println(stack.pop().value + " ");
					h = c;
				}
			}
		}
	}
	public static void main(String[] args) {

	}
}