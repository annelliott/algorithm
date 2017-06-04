package cpBt;
// �ж�t1�������Ƿ����t2�����ˡ�
public class checkSameTopo {
	// ��һ�������ҳ���ͬ�Ľڵ㣬ͨ���ݹ������У�
	public boolean contains(Node t1, Node t2) {
		return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}
	// �ڶ��������ڶ��������ڵ�������սڵ�ʱ���ж�Ϊtrue�����ڶ���������Ϊ�գ���һ������
	//Ϊ��ʱ�����ж�Ϊfalse�������߶���Ϊ�գ�����ֵ����ʱ���ж�Ϊfalse��
	// ���������ʱ�����ж����ҽڵ��Ƿ���ȡ�
	public boolean check(Node h, Node t2) {
		// һ�����ж���Ӧ�Ľڵ㣬���Աȵ���󣬷���t2Ϊ�գ���֤��������ȡ�
		if(t2 == null) {
			return true;
		}
		// ����t2��Ϊ�գ�����hΪ�գ���h��t2ֵ��ͬʱ����Ҫ����false
		if (h == null || h.value != t2.value) {
			return false;
		}
		// ��ͷ���ֵ���ʱ���Ƚ����ҽڵ㡣ֱ�����ҽڵ㶼���ԣ��ٽ��б�ġ�
		return check(h.left, t2.left) && check(h.right, t2.right);
	}
	public static void main(String[] args) {

	}
}