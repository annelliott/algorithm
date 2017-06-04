public class listSortByNo {
	public static Node listPartition1(Node head,int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		//�������鳤��
		while (cur != null) {
			i++;
			cur =cur.next;
		}
		Node[] nodeArr = new Node[i];
		cur = head;
		//�������е�ֵ��������
		for (i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		//�������л��ֳ���
		arrPartition(nodeArr, pivot);
		//������仯Ϊ����
		for (i = 1; i < nodeArr.length; i++) {
			nodeArr[i-1].next = nodeArr[i];
		}
		nodeArr[i-1].next = null;
		return nodeArr[0];
	}
	// ��������ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
	public static Node listPartition2(Node head,int pivot) {
		Node sH = null; // С��ͷ
		Node sT = null; // С��β
		Node eH = null; // �е�ͷ
		Node eT = null; // �е�β
		Node bH = null; // ���ͷ
		Node bT = null; // ���β
		Node next = null; // ������һ���ڵ�
		// ���еĽڵ�ֽ�����������
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// С�ĺ���ȵ�������
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// ���е���������
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null? eH : bH;
	}
	public static void arrPartition(Node[] nodeArr,int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				Node temp = nodeArr[++small];
				nodeArr[small] = nodeArr[index];
				nodeArr[index++] = temp; 
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				Node temp = nodeArr[index];
				nodeArr[index] = nodeArr[--big];
				nodeArr[big] = temp;
			}
		}		
	}
	public static void main(String[] args) {
		Node node1 = new Node(9);
		Node node2 = new Node(0);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		int pivot = 3;
		Node cur = listPartition1(node1, pivot);
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}		
	}
}