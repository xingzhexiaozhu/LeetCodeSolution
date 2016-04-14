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

	//����һ��
//	public static void main(String[] args) throws FileNotFoundException {
//		String [] str = {"ʡ","��","��","��","·","��","��","��","��","԰","Է","��","��"};
//        File inFile = new File("F:/Program/InterviewAlgorithm/TestData/tianchi_fresh_comp_train_item.csv"); // ��ȡ��CSV�ļ�
//        File outFile = new File("F:/Program/InterviewAlgorithm/TestData/out.csv");//д����CSV�ļ�
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
//            System.out.println("û�ҵ��ļ���");
//        } catch (IOException ex) {
//            System.out.println("��д�ļ�����");
//        }
//    }
	
	//��������String���replace()����֮�����ļ�
	public static void main(String[] args) throws FileNotFoundException {
		String [] str = {"ʡ","��","��","��","·","��","��","��","��","԰","Է","��","��"};
        File inFile = new File("F:/Program/InterviewAlgorithm/TestData/tianchi_fresh_comp_train_item.csv"); // ��ȡ��CSV�ļ�
        File outFile = new File("F:/Program/InterviewAlgorithm/TestData/out.csv");//д����CSV�ļ�
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
            System.out.println("û�ҵ��ļ���");
        } catch (IOException ex) {
            System.out.println("��д�ļ�����");
        }
    }
	
	//��������
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
