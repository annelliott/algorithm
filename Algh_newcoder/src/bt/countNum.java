package bt;
// ������ȫ�������Ľڵ�����
public class countNum {
	//��������������ڵ�Ĳ���  
	public static int mostLeftLevel(Node root)  
	{  
	    if(root == null)  
	        return 0;  
	    return mostLeftLevel(root.left)+1;  
	}  
	//�ݹ������ȫ�������ڵ����  
	public static int countNodes(Node root)  
	{  
	    if(root == null)  
	        return 0;  
	    int left=mostLeftLevel(root.left);  
	    int right=mostLeftLevel(root.right);  
	    if(left == right)//������������  
	        return (1<<left)+countNodes(root.right);  
	    else //right < left �����������ģ��Ҳ�����һ��  
	        return (1<<right)+countNodes(root.left);  
	} 
	public static void main(String[] args) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		head.left = n1;
		head.right = n2;
		n1.left = n3;
		System.out.println(countNodes(head));
	}

}
