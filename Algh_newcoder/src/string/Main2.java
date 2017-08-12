package string;

import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Main2 {
	// 判断是否为偶串
	public static boolean isEven(String str, int begin, int mid, int end) {
		String left = str.substring(begin, mid);
		String right = str.substring(mid, end);
		if(left.equals(right)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();*/
		String str = "abaab";
		 char[] chas = str.toCharArray();
		 int[] arr = new int[26];
		 int even = 0; // 统计偶数个数
		 int odd = 0;  // 
		 for (int i = 0; i < chas.length; i++) {
			int j = chas[i] - 'a';
			arr[j] += 1;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				odd++;
			} else if(arr[i] % 2 == 0 && arr[i] != 0){
				even++;
			}
		}
		System.out.println(odd);
	}

}
