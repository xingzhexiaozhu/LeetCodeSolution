
//Reverse bits of a given 32 bits unsigned integer.

//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
//return 964176192 (represented in binary as 00111001011110000010100101000000).

public class ReverseBits {

	//解法：相当于数组反转，分别从Integer的两端开始，依次交换对应的位
	public static int reverseBits(int n){
		int INT_SIZE = Integer.SIZE; //32	
		
        for (int i = 0; i < INT_SIZE / 2; i++) {  
            int j = INT_SIZE - 1 - i; 
                       
            int low = (n >> i) & 1;  
            int high = (n >> j) & 1;  
                                    
            int A = 1 << i;  
            int B = 1 << j;  
  
            if ((high ^ low) == 1) {  
                n = n ^ (A | B);  
            }  
            
            System.out.println(i + "\t" + low + "\t" + A);
            System.out.println(j + "\t" + high + "\t" + B);
            System.out.println(n);
        }  
        return n;  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(43261596));
				
		//方法二：调用Java API：  Integer.reverse（）
		System.out.println(Integer.reverse(43261596));
	}

}
