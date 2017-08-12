package string;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	// 先进行第一种，时间复杂度O(N)，空间复杂度为O(N)
	public static TreeNode Convert1(TreeNode pRootOfTree) {
        // 异常判断
		if (pRootOfTree == null) 
			return null;
		// 首先声明一个双端队列来存储相应的值
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// 利用中序遍历将内容存入队列中
		queue = inOrder(pRootOfTree, queue);
		// 首先找到队列中的头结点
		TreeNode head = queue.poll();
		TreeNode pre = head;
		TreeNode cur = null;		
		head.left = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		cur.right = null;
		return head;
    }
	public static Queue<TreeNode> inOrder(TreeNode pRootOfTree, Queue<TreeNode> queue) {
		// 边界判定
		if (pRootOfTree == null) {
			return null;
		}
		inOrder(pRootOfTree.left, queue);
		queue.offer(pRootOfTree);
		inOrder(pRootOfTree.right, queue);
		return queue;
	}
	
	// 时间复杂度O(N)，额外空间复杂度O(h)，之所以是O(h)是因为递归函数最多占用二叉树
	// 高度为h的栈空间
	public static TreeNode Convert2(TreeNode pRootOfTree) {
        // 异常判断
		if (pRootOfTree == null) 
			return null;
		// 找到最后一个节点
		TreeNode last = createLoop(pRootOfTree);
		pRootOfTree = last.right;
		last.right = null;
		return pRootOfTree;
    }
	
	// 设置递归函数来进行
	public static TreeNode createLoop(TreeNode pRootOfTree) {
		// 设置边界条件
		if (pRootOfTree == null) 
			return null;
		// 分别标记当前节点的左节点，右节点，
		// 记录左侧树的最左节点以及右侧树的最左节点
		TreeNode leftE = createLoop(pRootOfTree.left);
		TreeNode rightE = createLoop(pRootOfTree.right);
		TreeNode leftS = leftE == null ? null : leftE.right;
		TreeNode rightS = rightE == null ? null : rightE.right;
		// 进行判定
		if(leftE != null && rightE != null) {
			leftE.right = pRootOfTree;     // 最左节点的右侧为当前节点
			pRootOfTree.left = leftE;	   // 当前节点的左侧为最左节点
			// 右边树的最左节点	
			rightS.left = pRootOfTree;	   // 当前节点的右侧为右侧最左节点
			pRootOfTree.right = rightS;	   // 右侧最左节点的左侧为当前节点
			rightE.right = leftS;		   // 最右节点的右侧为左侧最左节点，之所以这么做是让当前节点为右子树时，容易找到最左节点
			return rightE;				  // 返回最右节点
		} else if(leftE != null) { // 当前节点右子树为空时，则相应链表的最右节点为当前节点head
			leftE.right = pRootOfTree;
			pRootOfTree.left = leftE;
			pRootOfTree.right = leftS;
			return pRootOfTree;
		} else if (rightE != null) {
			pRootOfTree.right = rightS;
			rightS.left = pRootOfTree;
			rightE.right = pRootOfTree;
			return rightE;
		} else {
			pRootOfTree.right = pRootOfTree;
			return pRootOfTree;
		}
	}
	
	// 测试
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n2.left = n1;
		n2.right = n3;
		n4.left = n2;
		n4.right = n5;
		TreeNode cur = Convert2(n4);
		System.out.println();
	}

}
