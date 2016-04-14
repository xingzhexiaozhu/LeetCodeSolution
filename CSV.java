import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

//import com.opencsv.CSVReader;

public class CSV {

	//方法一：
//	public static void main(String[] args) throws FileNotFoundException {
//		String [] str = {"省","市","区","街","路","里","幢","村","室","园","苑","巷","号"};
//        File inFile = new File("F:/Program/InterviewAlgorithm/TestData/tianchi_fresh_comp_train_item.csv"); // 读取的CSV文件
//        File outFile = new File("F:/Program/InterviewAlgorithm/TestData/out.csv");//写出的CSV文件
//        String inString = "";
//        String tmpString = "";
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(inFile));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
//            while((inString = reader.readLine())!= null){
//                char [] c = inString.toCharArray();
//                String [] value = new String[c.length];
//                String result = "";
//                for(int i = 0;i < c.length;i++){
//                    value[i] = String.valueOf(c[i]);
//                    for(int j = 0;j < str.length;j++){
//                        if(value[i].equals(str[j])){
//                            String tmp = value[i];
//                            value[i] = "," + tmp + ",";
//                        }
//                    }
//                    result += value[i];
//                }            
//               writer.write(inString);
//               writer.newLine();
//            }
//            reader.close();
//            writer.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("没找到文件！");
//        } catch (IOException ex) {
//            System.out.println("读写文件出错！");
//        }
//    }
	
	//方法二：String类的replace()方法之后代码的简化
	public static void main(String[] args) throws FileNotFoundException {
		String [] str = {"省","市","区","街","路","里","幢","村","室","园","苑","巷","号"};
        File inFile = new File("F:/Program/InterviewAlgorithm/TestData/tianchi_fresh_comp_train_item.csv"); // 读取的CSV文件
        File outFile = new File("F:/Program/InterviewAlgorithm/TestData/out.csv");//写出的CSV文件
        String inString = "";
        String tmpString = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

            while((inString = reader.readLine())!= null){
                for(int i = 0;i<str.length;i++){
                    tmpString = inString.replace(str[i], "," + str[i] + ",");
                    inString = tmpString;
                }
               writer.write(inString);
               writer.newLine();
            }
            
            reader.close();
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("没找到文件！");
        } catch (IOException ex) {
            System.out.println("读写文件出错！");
        }
    }
	
	//方法三：
//	public static void main(String[] args) throws Exception {
//		File file = new File("e:\\read.csv");
//		FileReader fReader = new FileReader(file);
//		CSVReader csvReader = new CSVReader(fReader);
//		String[] strs = csvReader.readNext();
//		if(strs != null && strs.length > 0){
//			for(String str : strs)
//				if(null != str && !str.equals(""))
//					System.out.print(str + " , ");
//			System.out.println("\n---------------");
//		}
//		List<String[]> list = csvReader.readAll();
//		for(String[] ss : list){
//			for(String s : ss)
//				if(null != s && !s.equals(""))
//					System.out.print(s + " , ");
//			System.out.println();
//		}
//		csvReader.close();
//	}
}
