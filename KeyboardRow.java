
//Ã‚“‚√Ë ˆ£∫Given a List of words, return the words that can be typed 
//using letters of alphabet on only one row's of American keyboard 
//like the image below.

//Input: ["Hello", "Alaska", "Dad", "Peace"]
//Output: ["Alaska", "Dad"]

import java.util.ArrayList;

public class KeyboardRow {

	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] res = findWords(words);		
		if(res != null){
			StringBuilder str = new StringBuilder();
			str.append(res[0]);
			for(int i=1; i<res.length; i++)
				str.append(", " + res[i]);
			System.out.println(str);
		}
			
	}

	private static String[] findWords(String[] words) {
		if(words == null || words.length == 0)
			return null;
		
		ArrayList<String> res = new ArrayList<>();
		for(int i=0, k=0; i<words.length; i++){
			if(keyBoardRow(words[i]))
				res.add(words[i]);
		}
		
		return (String[]) res.toArray(new String[res.size()]);
	}

	private static boolean keyBoardRow(String str) {
		if(str == null || str.length() == 0)
			return false;
		
		int[] ch = new int[256];		
		ch['z']=ch['x']=ch['c']=ch['v']=ch['b']=ch['n']=ch['m']=1;
		ch['a']=ch['s']=ch['d']=ch['f']=ch['g']=ch['h']=ch['j']=ch['k']=ch['l']=2;
		ch['q']=ch['w']=ch['e']=ch['r']=ch['t']=ch['y']=ch['u']=ch['i']=ch['o']=ch['p']=3;
		
		str = str.toLowerCase();
		for(int i=1; i<str.length(); i++){
			if(ch[str.charAt(i)] != ch[str.charAt(i-1)])
				return false;
		}
		
		return true;
	}

}
