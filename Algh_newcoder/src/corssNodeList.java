
public class corssNodeList {
	public Node getLoopNode(Node head) {
		// �����ж��Ƿ��ܹ��ɻ��Ļ�������
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;
		Node n2 = head.next.next;
		// ����ж��Ƿ��л����޻�����null���л������ҵ�fast��slow�ڵ�������λ��
		// ����������������������ָ��
		while (n1 != n2) {
			if (n1.next == null || n2.next == null) {
				return null;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		// ��������fastָ��ָ��ͷ�ڵ㡣
		n2 = head;
		// ���±������ҵ������ڵ�
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	// �ж��޻�����µĵ������ཻ����
	// ��Ҫע����ǣ��ཻ��㲻�ٷֿ�
	public Node noLoop(Node head1,Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		//���ȼ�����
		int n = 0;
		while (cur1 != null) {
			n++;
			cur1 = cur1.next;			
		}
		while (cur2 != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	//  �ж������������л����ڵ�����´����ʵ��
	public Node bothLoop(Node head1,Node head2,Node loop1,Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		//�������ཻ����ͬʱ
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			// ������������δ�غ�ʱ
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
			// �ж����������ʱ�����,���ڻ������
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return cur1;
				}				
				cur1 = cur1.next;
			}
			return null;
		}
	}
	public Node getIntersectNode(Node head1,Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1,head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, head2, loop1, loop2);
		}
		return null;
	}
	public static void main(String[] args) {
		
	}
}
