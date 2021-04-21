import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FileIO {


	public String GetLastKey(Map<String, String> englSpan) {
		String lastKey = new String();

		final Set<Entry<String, String>> mapValues = englSpan.entrySet();
        final int maplength = mapValues.size();
        final Entry<Integer,String>[] test = new Entry[maplength];
        mapValues.toArray(test);

        System.out.print("First Key:"+test[0].getKey());
        System.out.println(" First Value:"+test[0].getValue());

        System.out.print("Last Key:"+test[maplength-1].getKey());
        System.out.println(" Last Value:"+test[maplength-1].getValue());

		return lastKey;
	}
	public Map<String, String> ReadFile(String path) {
		Map <String, String> englSpan = new HashMap<String, String>();
		Dictionary dic = new Dictionary();
		try {
		      File myObj = new File(path);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.contains("`")) {
		        	String[] parts = data.split("`");
		        	englSpan.put(parts[0], parts[1]);		        			        	
		        }

		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return englSpan;
	}
	public void WriteFile(String path, Map<String, String> dic) {
		try {
		      FileWriter myWriter = new FileWriter(path);
		      dic.entrySet().forEach(entry -> {
		    	  	 try {
		    	  		 System.out.println(entry.getKey() + "`" + entry.getValue() +"\n");
						myWriter.write(entry.getKey() + "`" + entry.getValue() +"\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		      myWriter.close();
//		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	public void WriteFileHistory(String path, String word) {
		try {
		      FileWriter myWriter = new FileWriter(path);
//		      Dictionary historyDic = new Dictionary();
		      List<String> historyDic = new ArrayList<>();
		      historyDic.add(word);
		      
		      //Read file
		      try {
			      File myObj = new File(path);
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			    	  String data = myReader.nextLine();
//			        historyDic.add(myReader.nextLine());
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		    
		      for(int i=0;i<historyDic.size();i++) {
		    	  System.out.print(historyDic.get(i));
//		    	  myWriter.write(historyDic.get(i) + "\n");
		      }
		      
		      myWriter.close();
//		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
