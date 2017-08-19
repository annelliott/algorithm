package offer;

import java.util.Arrays;
/*面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
为了方便起见,你可以认为大小王是0。*/
public class PokerContinous {
	public static boolean isContinuous(int [] numbers) {
        boolean res = false;
		// 异常处理
		if (numbers == null || numbers.length < 1) {
			return res;
		}
		// 进行排序
		Arrays.sort(numbers);
		int len = 0;
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (i > 0 && numbers[i - 1] != 0) {
				if (numbers[i - 1] == numbers[i]) {
					return res;
				} else {
					len += numbers[i] - numbers[i - 1] - 1;
				}
			} else if (numbers[i] == 0) {
				count++;
			}
		}
		if (count >= len || count == numbers.length) {
			res = true;
		}
		return res;
    }	
	public static void main(String[] args) {
		int[] arr1 = {0,3,1,6,4};
		int[] arr2 = {4,6,7,0,0};
		int[] arr3 = {0,0,0,0,0};
		System.out.println(isContinuous(arr1));
		System.out.println(isContinuous(arr2));
		System.out.println(isContinuous(arr3));
		String a = "1.1.1.1";
		String[] res = a.split("\\.");
		System.out.println(res);
	}

}
