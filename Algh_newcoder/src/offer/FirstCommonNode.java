package offer;

public class FirstCommonNode {

	/*输入两个链表，找出它们的第一个公共结点。*/
	
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode res = null;
		// 异常处理
		if (pHead1 == null || pHead2 == null) {
			return res;
		}		
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;
		ListNode firstCur = null;
		ListNode lastCur = null;
		int count1 = 0;
		int count2 = 0;
		int first = 0;
		int last = 0;
		while (cur1 != null) {
			cur1 = cur1.next;
			count1++;
		}
		while (cur2 != null) {
			cur2 = cur2.next;
			count2++;
		}
		firstCur = count1 > count2 ? pHead1 : pHead2;
		lastCur = count1 > count2 ? pHead2 : pHead1;
		first = count1 > count2 ? count1 : count2;
		last = count1 > count2 ? count2 : count1;
		while (first > last) {
			first--;
			firstCur = firstCur.next;
		}
		while (firstCur != null && firstCur != lastCur) {
			firstCur = firstCur.next;
			lastCur = lastCur.next;
		}
		res = firstCur;
		return res;
    }
	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		ListNode p6 = new ListNode(6);
		ListNode p7 = new ListNode(7);
		p1.next = p2;
		p2.next = p3;
		p4.next = p5;
		p3.next = p6;
		p5.next = p6;
		p6.next = p7;
		ListNode res = FindFirstCommonNode(p1, p4);
		System.out.println(res.val);
	}

}
