package offer;

public class BalancedTree {

	/*����һ�ö��������жϸö������Ƿ���ƽ���������*/
	public static boolean IsBalanced_Solution(TreeNode root) {
        int[] dep = new int[1];
        return isBt(root, dep);
    }
	// ͨ����Ⱥͺ��������ʵ���ж��Ƿ�Ϊƽ�������
	public static boolean isBt(TreeNode root, int[] dep) {
		// �߽�����
		if(root == null) {
			dep[0] = 0;
			return true;
		}
		int[] left = new int[1];
		int[] right = new int[1];
		// ������Ҷ��ǣ�������ж�
		if (isBt(root.left, left) && isBt(root.right, right)) {
			int diff = Math.abs(left[0] - right[0]);
			if (diff == 0 || diff == 1) {
				// �����˶��壬��������
				dep[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n3.right = n4;
		boolean res = IsBalanced_Solution(n1);
		System.out.println(res);
	}

}
