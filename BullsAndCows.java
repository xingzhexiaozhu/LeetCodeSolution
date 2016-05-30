import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//������������������Ϸ����д��4��������������Ѳ£�ÿ��������Ѳ�һ�����֣������һ�������������������������ѣ�
//�ж��ٸ�����λ������ȷ�ģ�����ΪBulls�����ж��ٸ�����λ���ǲ���ȷ�ģ�����ΪCows�������������Ҫ������Щ�������ղ³���ȷ�����֡�

//���磬������������1807��������Ѳµ���7810��������A����Bulls��B����Cows���������������1A3B

public class BullsAndCows {

	//����˼·��������Ҫ�����ַ�ƥ�����⡣�����������������ĸ�����ͬ�����Զ���λ����ͬ����������ͬ�������ֻ�����һ�ξ��ܵõ�bull�ĸ�����
	//������λ�ò�ͬ�Һ�����ͬ�������������Ҫ�������⴦���Եõ�cow�ĸ�����
	//һ���棬����ĳһ���������е�ĳһ�����г����˶�Σ���һ���棬λ����ͬ������ͬ�����Ҳ��Ҫ���й��ˡ�
	//�˴�������һ��Map�����д洢�͹��ˡ����У�map��keyΪ�����е�����valueΪ�������ֵĴ�����
	//����ͨ��һ�α������ɽ�����������洢������Ȼ���ٽ������α������ֱ�õ�ͬһλ��������ͬ����ĸ����Ͳ�ͬλ��������ͬ����ĸ�������Ϊ����
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
