package string;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	// �Ƚ��е�һ�֣�ʱ�临�Ӷ�O(N)���ռ临�Ӷ�ΪO(N)
	public static TreeNode Convert1(TreeNode pRootOfTree) {
        // �쳣�ж�
		if (pRootOfTree == null) 
			return null;
		// ��������һ��˫�˶������洢��Ӧ��ֵ
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// ����������������ݴ��������
		queue = inOrder(pRootOfTree, queue);
		// �����ҵ������е�ͷ���
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
		// �߽��ж�
		if (pRootOfTree == null) {
			return null;
		}
		inOrder(pRootOfTree.left, queue);
		queue.offer(pRootOfTree);
		inOrder(pRootOfTree.right, queue);
		return queue;
	}
	
	// ʱ�临�Ӷ�O(N)������ռ临�Ӷ�O(h)��֮������O(h)����Ϊ�ݹ麯�����ռ�ö�����
	// �߶�Ϊh��ջ�ռ�
	public static TreeNode Convert2(TreeNode pRootOfTree) {
        // �쳣�ж�
		if (pRootOfTree == null) 
			return null;
		// �ҵ����һ���ڵ�
		TreeNode last = createLoop(pRootOfTree);
		pRootOfTree = last.right;
		last.right = null;
		return pRootOfTree;
    }
	
	// ���õݹ麯��������
	public static TreeNode createLoop(TreeNode pRootOfTree) {
		// ���ñ߽�����
		if (pRootOfTree == null) 
			return null;
		// �ֱ��ǵ�ǰ�ڵ����ڵ㣬�ҽڵ㣬
		// ��¼�����������ڵ��Լ��Ҳ���������ڵ�
		TreeNode leftE = createLoop(pRootOfTree.left);
		TreeNode rightE = createLoop(pRootOfTree.right);
		TreeNode leftS = leftE == null ? null : leftE.right;
		TreeNode rightS = rightE == null ? null : rightE.right;
		// �����ж�
		if(leftE != null && rightE != null) {
			leftE.right = pRootOfTree;     // ����ڵ���Ҳ�Ϊ��ǰ�ڵ�
			pRootOfTree.left = leftE;	   // ��ǰ�ڵ�����Ϊ����ڵ�
			// �ұ���������ڵ�	
			rightS.left = pRootOfTree;	   // ��ǰ�ڵ���Ҳ�Ϊ�Ҳ�����ڵ�
			pRootOfTree.right = rightS;	   // �Ҳ�����ڵ�����Ϊ��ǰ�ڵ�
			rightE.right = leftS;		   // ���ҽڵ���Ҳ�Ϊ�������ڵ㣬֮������ô�����õ�ǰ�ڵ�Ϊ������ʱ�������ҵ�����ڵ�
			return rightE;				  // �������ҽڵ�
		} else if(leftE != null) { // ��ǰ�ڵ�������Ϊ��ʱ������Ӧ��������ҽڵ�Ϊ��ǰ�ڵ�head
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
	
	// ����
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
