package offer;

public class CharFirstApperence {
	static int[] arr = new int[257];
	static StringBuilder s = new StringBuilder();
	public static void Insert(char ch)
    {
        int a = ch;
        arr[a]= arr[a] + 1;
        s.append(ch);
    }
  //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {	
    	char res = '#';
    	char[] chas = s.toString().toCharArray();
    	for (int i = 0; i < chas.length; i++) {
			int a = chas[i];
    		if (arr[a] == 1) {
				res = chas[i];
				break;
			}
		}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
