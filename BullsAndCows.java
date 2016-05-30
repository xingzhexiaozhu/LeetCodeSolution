import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//题意描述：猜数字游戏，你写出4个数字让你的朋友猜，每次你的朋友猜一个数字，你给出一条线索，这个线索告诉你的朋友，
//有多少个数字位置是正确的（被称为Bulls），有多少个数字位置是不正确的（被称为Cows），你的朋友需要根据这些线索最终猜出正确的数字。

//例如，给出的数字是1807，你的朋友猜的是7810，这里用A代表Bulls，B代表Cows，则给出的线索是1A3B

public class BullsAndCows {

	//解题思路：该题主要考察字符匹配问题。由于两串数字中数的个数相同，所以对于位置相同且数字亦相同的情况，只需遍历一次就能得到bull的个数；
	//而对于位置不同且含有相同数的情况，则需要进行特殊处理以得到cow的个数。
	//一方面，可能某一个数在其中的某一串数中出现了多次；另一方面，位置相同且数相同的情况也需要进行过滤。
	//此处，创建一个Map来进行存储和过滤。其中，map的key为数串中的数，value为该数出现的次数。
	//这样通过一次遍历即可将数和其个数存储起来，然后再进行两次遍历，分别得到同一位置上数相同情况的个数和不同位置上数相同情况的个数，即为所求
	private static String getHint(String secret, String guess) {
		char[] secretStr = secret.toCharArray();
        char[] guessStr = guess.toCharArray();
 
        int len = secretStr.length;
        int bull = 0;
        int cow = 0; 
        Map<Character, Integer> seHas = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            if (!seHas.containsKey(secretStr[i])) {
                seHas.put(secretStr[i], 1);
            } else {
                seHas.put(secretStr[i], seHas.get(secretStr[i]) + 1);
            }
        }
 
        Boolean[] b = new Boolean[len];
        for (int i = 0; i < len; i++) {
            if (secretStr[i] == guessStr[i]) {
                b[i]  = true;
                seHas.put(guessStr[i], seHas.get(guessStr[i])-1);
                cow++;
            }else {
                b[i] = false;
            }
        }
 
        for (int j = 0; j < len; j++) {
            if(b[j] == false && seHas.get(guessStr[j])!=null && seHas.get(guessStr[j])>0) {
                bull ++;
                seHas.put(guessStr[j], seHas.get(guessStr[j])-1);
            }
        }
         
        return cow + "A" + bull + "B";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String secret = sc.next();
			String guess = sc.next();
			System.out.println(getHint(secret, guess));
		}
	}

}
