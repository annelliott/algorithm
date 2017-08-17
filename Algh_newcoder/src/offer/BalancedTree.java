package offer;

public class BalancedTree {

	/*输入一棵二叉树，判断该二叉树是否是平衡二叉树。*/
	public static boolean IsBalanced_Solution(TreeNode root) {
        int[] dep = new int[1];
        return isBt(root, dep);
    }
	// 通过深度和后序遍历，实现判断是否为平衡二叉树
	public static boolean isBt(TreeNode root, int[] dep) {
		// 边界条件
		if(root == null) {
			dep[0] = 0;
			return true;
		}
		int[] left = new int[1];
		int[] right = new int[1];
		// 如果左右都是，则进行判断
		if (isBt(root.left, left) && isBt(root.right, right)) {
			int diff = Math.abs(left[0] - right[0]);
			if (diff == 0 || diff == 1) {
				// 别忘了定义，深度是最深。
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
