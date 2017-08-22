package offer;

public class LastRemaining {

	/*约瑟夫环形链表问题*/
	// 左神解法，本题本质还是报数为m-1的倍数的人死。，
    /*	报数（A）        实际人员编号（B）
    	0          0
        .          .
        .          .
        n-1        n-1
        n        0
                     则可知B = A % n
        同时，当杀了一个人之后，杀人前记为before,杀人后记为after.
        before         after
        k  (k < n)       (没有了，因为被杀后变为n-1个人了)
    	k+1             0
    	.               .
    	.               .
    	n-2             n-k-3
    	0               n-k-2
    	.               .
    	.               .
    	k-1             n-2
    	符合公式before = (after + k + 1) % n
    	可知，最后一个活着的人为0号，因此可以利用逆推的方法求得活着的那个人。*/        
    	
	public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
			return -1;
		}
        int live = getLive(n, m);
        return live;
    }
	public static int getLive(int n, int m) {
		if (n == 0) {
			return 0;
		}
		return (getLive(n - 1, m) + m) % n;
	}
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5, 3));
	}

}
