package BinarySearch;

public class CountNodes {
	/*����һ����ȫ�������ĸ��ڵ�root������������Ľڵ������
	�����ȫ�������Ľڵ���ΪN����ʵ��ʱ�临�Ӷȵ���O(N)�Ľⷨ��
	�������ĸ����root���뷵�����Ĵ�С*/
	public static int count(TreeNode root) {
       int[] res = new int[1];
       if (root == null) {
		return res[0];
       }
       getNode(root, res);
       return res[0];
    }
	public static void getNode(TreeNode root, int[] res) {
			if (root == null) {
				res[0] += 0;
				return;
			}
			if (root.left == null && root.right == null) {
				res[0] += 1;
				return;
			}
			TreeNode curL = root.left;
			TreeNode curR = root.right;
			int left = 1;
			int right = 1;
			// �������������ĸ߶�
			while (curL != null) {
				left++;
				curL = curL.left;
			}
			while (curR != null) {
				right++;
				curR = curR.left;
			}
			if (left == right) {
				// ����������
				res[0] += (int) Math.pow(2, left - 1) - 1;
				getNode(root.right, res);
				res[0]++;
			} else {
				res[0] += (int) Math.pow(2, right - 1) - 1;
				getNode(root.left, res);
				res[0]++;
			}
			return;
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t8;
		System.out.println(count(t1));
	}

}
