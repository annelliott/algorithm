package string;

public class CharReplace {
	// 字符串的调整和替换
	// 对中间空格进行替换，如"a b c  d",将" "替换为%20
	// 首先统计空格个数，其次将char数组从后往前进行拓宽
	public static void replace(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;
		for (; len < chas.length && chas[len] != 0; len++) {
			if (chas[len] == ' ') {
				num++;
			}
		}
		int j = len + num * 2 - 1;
		for (int i = len - 1; i > -1; i--) {
			if (chas[i] != ' ') {
				chas[j--] = chas[i]; 
			} else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}
	}
	// 将空格看为*和数字组成，将*全部挪到前面去
	public static void replace1(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int j = chas.length - 1;
		for (int i = chas.length - 1; i > -1; i--) {
			if (chas[i] != '*') {
				chas[j--] = chas[i];
			}
		}
		for (; j > -1; j--) {
			chas[j--] = '*';
		}
	}
	 public static void reOrderArray(int[] array) {
	        // 异常处理
	        if(array.length == 0 || array == null) 
	            return;
	        int n = array.length;
	        int num = 0;
	        int left = -1;
	        int right = -1;
	        for (int i = 0; i < n; i++) {
	            if(isEven(array[i]))
	                num++;
	        }
	        int[] res = new int[n];
	        right = n - num;
	        for(int i = 0; i < n; i++) {
	            if(!isEven(array[i])) {
	            	res[++left] = array[i];
	            } else {
	            	res[right++] = array[i];
	            }
	        }
	        for (int i = 0; i < array.length; i++) {
				array[i] = res[i];
			}
	        /*int len=array.length;  
            int count1=0;  
            int count2=0;  
            int[] arr1=new int[len];  
            int[] arr2=new int[len];  
            for(int i=0;i<len;i++){  
                if(array[i]%2==0){  
                    arr2[count2++]=array[i];  
                }else{  
                    arr1[count1++]=array[i];  
                }  
            }  
            for(int i=0;i<count1;i++){  
                array[i]=arr1[i];  
            }  
            for(int i=0;i<count2;i++){  
                array[count1+i]=arr2[i];  
            } */ 
	    }
	 public static boolean isEven(int n) {
	        // 为偶数返回true
	        return (n & 0x1) == 0;
	    }
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		reOrderArray(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}