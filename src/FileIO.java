import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FileIO {
	private static String pathSlangOriginal = "slang-origin.txt";
	private static String pathHistory = "history.txt";
	private static String pathSlangUsed = "slang-used.txt";

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
	public Map<String, String> ReadFileSlang() {
		Map <String, String> englSpan = new HashMap<String, String>();
		try {
		      File myObj = new File(pathSlangUsed);
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
	public void WriteFile(List<String> slangword, String path) {

		List<String> historyDic = new ArrayList<>();
		FileWriter myWriter;
		try {
			
			try {
			     File myObj = new File(path);
			     Scanner myReader = new Scanner(myObj);
			     while (myReader.hasNextLine()) {
			       String data = myReader.nextLine();
			       historyDic.add(data);	        			        	
			      }
			      	myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			
			Dictionary dic = new Dictionary();
			dic.InitialDictionary();
			for(int i=0; i<slangword.size(); i++) {
				String sw = slangword.get(i).toString().replaceAll("[\\[\\]\\(\\)]", "");
				historyDic.add( sw + "`" + dic.getDic().get(sw));
			}
			
			//Write File
			myWriter = new FileWriter(path);
			 PrintWriter pw = new PrintWriter(new FileOutputStream(path));
			    for(int i=0; i<historyDic.size(); i++) {
			    	pw.println(historyDic.get(i));			    	
			    }
			    pw.close();
			    System.out.println("Done!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void ReadFileHistory() {
		List<String> historyDic = new ArrayList<>();
		System.out.println("History: ");
		try {
		     File myObj = new File(pathHistory);
		     Scanner myReader = new Scanner(myObj);
		     while (myReader.hasNextLine()) {
		       String data = myReader.nextLine();
		       historyDic.add(data);	        			        	
		      }
		      	myReader.close();
		      	for(int i=0; i<historyDic.size(); i++) {
		      		System.out.println(historyDic.get(i));
		      	}
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
