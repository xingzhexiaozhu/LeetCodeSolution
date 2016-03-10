import java.util.HashMap;
import java.util.Map;

//��ǰ�������������֣����ĳ������ǰһ����С������ϸ�������֮����ȥǰһ����������Ȼ����ϸ���

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
