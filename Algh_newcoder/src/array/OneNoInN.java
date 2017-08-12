package array;

	/*标记1-N中1出现的次数。例如，当N等于18时，1出现的次数为2 + 9 = 11
         个位数出现1的为：1，11，十位数出现1的为10-18*/
public class OneNoInN {
	// 暴力解法
	public static int solution1(int num) {
		// 异常处理
		if (num < 1) 
			return 0;
		// 标记变量count
		int count = 0;
		// 计算没个数中的1的个数，然后加起来，时间复杂度为O(nlogn)
		for (int i = 1; i < num + 1; i++) {
			count += get1Num(i);
		}
		return count;
	}
	public static int get1Num(int num) {
		int res = 0;
		while (num != 0) {
			if (num % 10 == 1) {
				res++;
			}
			num /= 10;			
		}
		return res;
	}
	
	// 第二种方法，进行分析
	// 两种情况：
	// 第一种情况：最高位为1,1-114，首先划分为1-14和15-114，
	// 百位为1，则相应的对应的1的个数为num % tmp1 + 1.即114 % 100 + 1 = 15
	// 十位为1时，有 15 - 19 还有110 - 114；
	// 个位为1时，有21-91，101，111，
	// 则对应的1的个数为1 * (3 - 1) * (100 / 10) 
	// 第二种情况： 最高位大于1，则最高位的情况为tmp1，其他低位的情况类似
	public static int solution2(int num) {
		// 异常处理
		if (num < 1)
			return 0;
		// 得出当前字符的长度
		int len = getLenOfNum(num);
		// 进行判断，如果当前字符长度为1，则返回1
		if (len == 1) 
			return 1;
		// 记录当前最大值一个量级的一个数
		int tmp = powBase10(len - 1);
		// 得到最高位的值
		int first = num / tmp;
		int firstOneNum = first == 1 ? num % tmp + 1 : tmp;
		int otherOneNum = first * (len - 1) * (tmp / 10);
		return firstOneNum + otherOneNum + solution1(num % tmp); 
	}
	
	// 得出当前数值的位数
	public static int getLenOfNum(int num) {
		int len = 0;
		while (num != 0) {
			len++;
			num /= 10;
		}
		return len;
	}
	
	// 求一个指数的值
	public static int powBase10(int base) {
		return (int) Math.pow(10, base);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
