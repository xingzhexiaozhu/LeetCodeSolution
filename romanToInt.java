import java.util.HashMap;
import java.util.Map;

//从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数

public class romanToInt {
	public static int romanToInt(String s){
		char[] symbol = {'I','V','X','L','C','D','M'};
		int[] value = {1,5,10,50,100,500,1000};
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<symbol.length; i++)
			map.put(symbol[i], value[i]);
		
		int len = s.length();
		int result = 0;
		
		if(len < 0) return 0;
		result += map.get(s.charAt(0));
		for(int i=1; i<s.length(); i++){
			int cur = map.get(s.charAt(i));
			int pre = map.get(s.charAt(i-1));
			if(cur <= pre){
				result += cur;
			}else{
				result = result + cur - 2 * pre;
			}
		}
		return result;		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXC"));//1990
		//System.out.println("MCMXC".charAt(0));//M
	}

}
