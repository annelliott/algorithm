package bt;

import java.util.HashMap;

public class reConstructTreeByOrder {
	// �����������������
	/* ������������ģʽ�� ���ڵ�-���ڵ��������-���ڵ��������
	 * ������������ģʽ�� ���ڵ��������-���ڵ�-���ڵ��������
	 * ����Ⱦ������������ͷ�ڵ㣬ȷ������������е�λ��i��
	 * ˳�㽫��Ӧ�������������������������������Ҳȷ��������
	 * �ڸ���������������ȷ�������������ȣ�ȷ�������������еĳ���
	 * ����������������������������飬����������������*/	
	public static Node preToTree(int[] pre, int[] in) {
		if(pre == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}
	public static Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		// �����˵㳤�ȴ����Ҷ˵㣬�򷵻�null
		if (pi > pj) {
			return null;
		}
		// ���������������ڵ�����Ϊͷ�ڵ�
		Node head = new Node(p[pi]);
		// �ó����ڵ����ڵ�λ��index
		int index = map.get(p[pi]);
		// ����������ʱ��Ӧ����ĸı�
		head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		// ����������ʱ��Ӧ����ĸı�
		head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
		return head;
	}
	/*
	 * ������������ͺ��������������������Ӧ�����
	 * ���������е�˳���Ǹ��ڵ�������������ڵ�������������ڵ�
	 * ���������е�˳���Ǹ��ڵ�������������ڵ㣬���ڵ��������
	 * ��˺��������е����ҽڵ㼴���ڵ�
	 * */
	public static Node inPosToTree(int[] in, int[] pos) {
		if (in == null || pos == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, map);
	}
	// ���½��л��֣����ָ��ڵ�������������ڵ���������Լ����ڵ�
	public static Node inPos(int[] n, int ni, int nj, int[] s, int si, int sj, 
			HashMap<Integer, Integer> map) {
		// ÿ�ζ������»��ֺ����������������
		if (si > sj) {
			return null;
		}
		// �������ڵ�
		Node head = new Node(s[sj]);
		// ȷ��������������Ӧ��λ��
		int index = map.get(s[sj]);
		// ��������������� ni �� index - 1����������� si �� si + index - ni - 1
		head.left = inPos(n, ni, index - 1, s, si, si + index - ni - 1, map);
		// ���������index + 1 �� nj, ���������si + index - ni ��sj - 1 
		head.right = inPos(n, index + 1, nj, s, si + index - ni, sj - 1, map);
		// �������ڵ�head
		return head;
	}
	public static void main(String[] args) {
		
	}
}