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
		// 判断异常
		if (str == null || str.length() == 0) 
			return list;
		// 利用递归方法进行判断
		list = perMuatate(list, str, 0);
		Collections.sort(list);
		return list;
		
	}
	// 判断固定位是否需要与end位进行交换，即[begin end]位之间是否有重复位
	public static boolean isSwap(char[] chas, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if(chas[i] == chas[end])
				return false;			
		}
		return true;
	}
	public static ArrayList<String> perMuatate(ArrayList<String> list, String str, int index) {
		// 边界条件
		if (index == str.length()) {
			list.add(str);
		}			
		// 首先转化为char类型的数组
		char[] chas = str.toCharArray();
		// 其次将其进行重新排序组成
		// index表示依次固定的值，当前str的第index + 1位。
		// i用来表示当第index + 1位被固定时，交换index + 1位和第i + 1位，
		// 不断由于i是从index开始的，因此可以包括自身和之后的以它为准的下一位
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
