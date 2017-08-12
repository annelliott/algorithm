package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class WordQuanpailie {
	
	
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if (str == null) {
			return res;
		}
		TreeSet<String> set = new TreeSet<String>();
		set = placeAll(set, str, 0);
		
		res.addAll(set);
		return res;
    }
	public static TreeSet<String> placeAll(TreeSet<String> set, String str, int index) {
		char[] chas = str.toCharArray();
		for (int i = index; i < chas.length; i++) {
			String strN = swap(chas, index, i);
			set.add(strN);
			placeAll(set, strN, index + 1);
		}
		return set;
	}
	
	public static String swap(char[] chas, int start, int end) {
		String str = "";
		char tmp = chas[start];
		chas[start] = chas[end];
		chas[end] = tmp;
		for (int i = 0; i < chas.length; i++) {
			str += String.valueOf(chas[i]);
		}
		return str;
	}
	
	public static ArrayList<String> Permutation1(String str) {
		ArrayList<String> list = new ArrayList<String>();
		// �ж��쳣
		if (str == null || str.length() == 0) 
			return list;
		// ���õݹ鷽�������ж�
		list = perMuatate(list, str, 0);
		Collections.sort(list);
		return list;
		
	}
	// �жϹ̶�λ�Ƿ���Ҫ��endλ���н�������[begin end]λ֮���Ƿ����ظ�λ
	public static boolean isSwap(char[] chas, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if(chas[i] == chas[end])
				return false;			
		}
		return true;
	}
	public static ArrayList<String> perMuatate(ArrayList<String> list, String str, int index) {
		// �߽�����
		if (index == str.length()) {
			list.add(str);
		}			
		// ����ת��Ϊchar���͵�����
		char[] chas = str.toCharArray();
		// ��ν�����������������
		// index��ʾ���ι̶���ֵ����ǰstr�ĵ�index + 1λ��
		// i������ʾ����index + 1λ���̶�ʱ������index + 1λ�͵�i + 1λ��
		// ��������i�Ǵ�index��ʼ�ģ���˿��԰��������֮�������Ϊ׼����һλ
		for (int i = index; i < chas.length; i++) {
			if(isSwap(chas, index, i)) {
				str = swap(chas, index, i);
				perMuatate(list, str, index + 1);
				str = swap(chas, index, i);
			}
		}
		return list;
	}
	
	
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		ArrayList<String> res = Permutation1(str);
		System.out.println(res);
	}

}
