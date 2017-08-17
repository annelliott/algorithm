package offer;

public class TreeDep {
	/*输入一棵二叉树，求该树的深度。
	从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
	最长路径的长度为树的深度。*/
	public static int TreeDepth1(TreeNode root) {
		int dep = 0;
		int[] max = new int [1];
		max[0] = Integer.MIN_VALUE;
		// 异常处理
		if (root == null) {
			return dep;
		} 
		preOrder(root, dep, max);
		return max[0];
	}
	public static void preOrder(TreeNode root, int depth, int[] max) {
		++depth;
		if (depth > max[0]) 
			max[0] = depth;
		if (root.left != null) {
			preOrder(root.left, depth, max);
		} 
		if (root.right != null) {
			preOrder(root.right, depth, max);
		}
	}
	// 简化方法,递归的合理利用
	public static int TreeDepth(TreeNode root) {
		if (root == null) 
			return 0;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return (left > right) ? (left + 1) : (right + 1);
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n2.right = n3;
		n3.right = n4;
		int res = TreeDepth(n1);
		System.out.println(res);
	}

}
