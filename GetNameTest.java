import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

//�������ļ���
//1,����,28
//2,����,35
//3,����,28
//4,����,35
//5,����,28
//6,����,35
//7,����,28
//8,����,35
//��ȡ�����˵�������������ظ����������ظ��Ĵ��������ظ���������

public class GetNameTest {

	static class User {
		public String name;
		public Integer value;

		public User(String name, Integer value) {
			this.name = name;
			this.value = value;
		}

		public boolean equals(Object obj) {
			boolean result = super.equals(obj);
			System.out.println(result);
			return result;
		}
	}

	private static void sortResults(Map results){
		TreeSet sortedResults = new TreeSet();
//		TreeSet sortedResults =new TreeSet(new Comparator({
//			public int compare(Object o1, Object o2) {
//				User user1 = (User)o1;
//				User user2 = (User)o2;
//				/*��� compareTo ���ؽ��0������Ϊ����������ȣ��µĶ��󲻻����ӵ�������ȥ
//				 *���ԣ�����ֱ��������Ĵ��룬������Щ������ͬ�����������ʹ�ӡ��������
//				 **/
//	//			return user1.value - user2.value;
//	//			return user1.valu < user2.value?-1:user2.value==user2.value?0:1;
//				if(user1.value < user2.value){
//					return -1;
//				}else if(user1.value  > user2.value){
//					return 1;
//				}else{
//					return user1.name.compareTo(user2.name);
//				}
//			}
//		});
			
		Iterator iterator = results.keySet().iterator();
		while(iterator.hasNext()){
			String name = (String)iterator.next();
			Integer value =(Integer)results.get(name);
			if(value > 1){
					sortedResults.add(new User(name,value));
			}
		}
		printResults(sortedResults);
	}

	private static void printResults(TreeSet sortedResults){
		Iterator iterator = sortedResults.iterator();
		while(iterator.hasNext()){
			User user = (User)iterator.next();
			System.out.println(user.name + ":" + user.value);
		}
	}
	
	public static void dealLine(String line, Map map){
		if(!"".equals(line.trim())){
			String[] results = line.split(",");
			if(results.length == 3){
				String name = results[1];
				Integer value = (Integer)map.get(name);
				if(value == null)
					value = 0;
				map.put(name,  value+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Map results = new HashMap();
		File file = new File("F:/Program/InterviewAlgorithm/TestData/GetNameTest.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) {
			dealLine(line, results);
		}
		sortResults(results);
	}

}
