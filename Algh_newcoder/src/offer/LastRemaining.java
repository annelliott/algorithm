package offer;

public class LastRemaining {

	/*Լɪ������������*/
	// ����ⷨ�����Ȿ�ʻ��Ǳ���Ϊm-1�ı�������������
    /*	������A��        ʵ����Ա��ţ�B��
    	0          0
        .          .
        .          .
        n-1        n-1
        n        0
                     ���֪B = A % n
        ͬʱ����ɱ��һ����֮��ɱ��ǰ��Ϊbefore,ɱ�˺��Ϊafter.
        before         after
        k  (k < n)       (û���ˣ���Ϊ��ɱ���Ϊn-1������)
    	k+1             0
    	.               .
    	.               .
    	n-2             n-k-3
    	0               n-k-2
    	.               .
    	.               .
    	k-1             n-2
    	���Ϲ�ʽbefore = (after + k + 1) % n
    	��֪�����һ�����ŵ���Ϊ0�ţ���˿����������Ƶķ�����û��ŵ��Ǹ��ˡ�*/        
    	
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
