package bt;
public class Bt {
	// ��������ݹ����
	public void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	// ��������ݹ����
	public void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value + " ");
		inOrderRecur(head.right);
	}
	// ��������ݹ����
	public void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		preOrderRecur(head.right);
		System.out.println(head.value + " ");		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
