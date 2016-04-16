import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class takeStones {

	public static boolean canWinNim(int n){
		if(n%4 == 0)
			return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		while(text != null){
			int stones = Integer.parseInt(text);
			if(canWinNim(stones))
				System.out.println("You can win!");
			else System.out.println("You lost!");			
			
			text = br.readLine();
		}
	}

}
