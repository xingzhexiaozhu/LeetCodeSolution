import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//题意描述：所数组排组最小的数

public class PrintMinNumber {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<>();
		num.add(3);
		num.add(32);
		num.add(321);
		printMinNumber(num);
	}

	private static void printMinNumber(ArrayList<Integer> num) {
		Comparator cmp = new Comparator(){		
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = o1.toString() + o2.toString();
				String s2 = o2.toString() + o1.toString();				
				return Integer.parseInt(s1)-Integer.parseInt(s2);
			}
		};
		
		Collections.sort(num, cmp);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<num.size(); i++)
			sb.append(num.get(i));
		System.out.println(sb);
	}

}
